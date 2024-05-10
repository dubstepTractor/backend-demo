package com.example.demo.controllers;

import com.example.demo.models.PlanQuery;
import com.example.demo.models.WorkloadQuery;
import com.example.demo.services.PlanQueryService;
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

import static com.example.demo.helpers.WorkbookHelpers.convertWorkbookToByteArray;
import static com.example.demo.helpers.plan.PlanExcelProcessor.createReportPlan;

@RestController
@RequestMapping("/api/report/ind-plan")
public class IndPlanReportController {
    private final WorkloadQueryService workloadQueryService;
    private final PlanQueryService planQueryService;

    public IndPlanReportController(WorkloadQueryService workloadQueryService, PlanQueryService planQueryService) {
        this.workloadQueryService = workloadQueryService;
        this.planQueryService = planQueryService;
    }

    @GetMapping("/data")
    public ResponseEntity<List<WorkloadQuery>> getWorkloadByYear(@RequestParam(required = true) Integer year, @RequestParam(required = true) Integer id) {
        List<WorkloadQuery> data = workloadQueryService.getWorkloadEmployByYear(year, id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/file")
    public ResponseEntity<ByteArrayResource> getEmptyFile(@RequestParam(required = true) Integer year, @RequestParam(required = true) Integer id) throws IOException {
        List<WorkloadQuery> dataIndPlan = workloadQueryService.getWorkloadEmployByYear(year, id);
        PlanQuery employee = planQueryService.getEmployee(id);
        Workbook workbook = createReportPlan(employee, dataIndPlan);

        // Преобразуем книгу в массив байтов
        byte[] excelBytes = convertWorkbookToByteArray(workbook);

        // Создаем ресурс ByteArrayResource из массива байтов
        ByteArrayResource resource = new ByteArrayResource(excelBytes);

        // Устанавливаем заголовки для ответа
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Plan" + year + ".xlsx");

        // Возвращаем ответ с содержимым книги Excel
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(excelBytes.length)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }
}