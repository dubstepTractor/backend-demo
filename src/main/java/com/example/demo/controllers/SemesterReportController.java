package com.example.demo.controllers;

import com.example.demo.models.WorkloadQuery;
import com.example.demo.services.WorkloadQueryService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static com.example.demo.helpers.WorkbookHelpers.convertWorkbookToByteArray;
import static com.example.demo.helpers.semester.SemesterExcelProcessor.createSemesterReport;

@RestController
@RequestMapping("/api/report/semester")
public class SemesterReportController {
    private final WorkloadQueryService workloadQueryService;

    public SemesterReportController(WorkloadQueryService workloadQueryService) {
        this.workloadQueryService = workloadQueryService;
    }

    @GetMapping("/file")
    public ResponseEntity<ByteArrayResource> getFile(@RequestParam(required = true) Integer year, @RequestParam(required = true) Boolean isAutumn) throws IOException {
        //Получаем данные
        List<WorkloadQuery> dataWorkLoad = workloadQueryService.getWorkloadByYear(year);
        //Создаём отчёт
        Workbook workbook = createSemesterReport(dataWorkLoad, isAutumn);
        // Преобразуем книгу в массив байтов
        byte[] excelBytes = convertWorkbookToByteArray(workbook);
        // Создаем ресурс ByteArrayResource из массива байтов
        ByteArrayResource resource = new ByteArrayResource(excelBytes);
        // Устанавливаем заголовки для ответа
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Semester" + year + ".xlsx");
        // Возвращаем ответ с содержимым книги Excel
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(excelBytes.length)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }
}
