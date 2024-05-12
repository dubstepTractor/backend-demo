package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.WorkloadQuery;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.WorkloadQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.example.demo.helpers.WorkbookHelpers.convertWorkbookToByteArray;
import static com.example.demo.helpers.workload.WorkloadExcelProcessor.createReportWorkload;
import static com.example.demo.helpers.workload.WorkloadExcelProcessor.disassembleData;

@RestController
@RequestMapping("/api/report/workload")
public class WorkloadReportController {
    private final WorkloadQueryService workloadQueryService;
    private final EmployeeService employeeService;

    public WorkloadReportController(WorkloadQueryService workloadQueryService, EmployeeService employeeService) {
        this.workloadQueryService = workloadQueryService;
        this.employeeService = employeeService;
    }

    @GetMapping("/data")
    public ResponseEntity<List<WorkloadQuery>> getWorkloadByYear(@RequestParam(required = true) Integer year, @RequestParam(required = false) Integer id) {
        List<WorkloadQuery> data;
        if (id == null) {
            data = workloadQueryService.getWorkloadByYear(year);
        } else {
            data = workloadQueryService.getWorkloadEmployByYear(year, id);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/file")
    public ResponseEntity<ByteArrayResource> getFile(@RequestParam(required = true) Integer year) throws IOException {
        List<WorkloadQuery> dataWorkLoad = workloadQueryService.getWorkloadByYear(year);
        List<Employee> employees = employeeService.getAll();
        Map<String, List<WorkloadQuery>> mapWorkLoad = disassembleData(dataWorkLoad, employees);
        Workbook workbook = createReportWorkload(mapWorkLoad);

        // Преобразуем книгу в массив байтов
        byte[] excelBytes = convertWorkbookToByteArray(workbook);

        // Создаем ресурс ByteArrayResource из массива байтов
        ByteArrayResource resource = new ByteArrayResource(excelBytes);

        // Устанавливаем заголовки для ответа
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Workload" + year + ".xlsx");

        // Возвращаем ответ с содержимым книги Excel
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(excelBytes.length)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }
}
