package com.example.excel.imports.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadExcelFile {

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        System.out.println(file.getOriginalFilename());

        return "Done";
    }
}
