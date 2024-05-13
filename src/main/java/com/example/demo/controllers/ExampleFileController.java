package com.example.demo.controllers;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.example.demo.helpers.WorkbookHelpers.convertWorkbookToByteArray;
import static com.example.demo.helpers.example.ExampleExcelProcessor.getExampleFile;

@RestController
@RequestMapping("/api/database")
public class ExampleFileController {
    @GetMapping("/example")
    public ResponseEntity<ByteArrayResource> getFile() throws IOException {
        Workbook workbook = getExampleFile();

        // Преобразуем книгу в массив байтов
        byte[] excelBytes = convertWorkbookToByteArray(workbook);

        // Создаем ресурс ByteArrayResource из массива байтов
        ByteArrayResource resource = new ByteArrayResource(excelBytes);

        // Устанавливаем заголовки для ответа
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Example.xlsx");

        // Возвращаем ответ с содержимым книги Excel
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(excelBytes.length)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }
}
