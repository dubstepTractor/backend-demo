package com.example.demo.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/front")
public class FrontendController {
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() throws IOException {
        // Получаем ресурс для файла index.html из каталога resources/static
        Resource resource = new ClassPathResource("static/index.html");
        // Получаем содержимое файла в виде строки
        String content = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        // Возвращаем содержимое файла как ответ на запрос
        return content;
    }
}
