package com.example.excel.imports.controllers;

import com.example.excel.imports.dto.BookDto;
import com.example.excel.imports.services.Books;
import com.example.excel.imports.shared.ExcelProcess;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class UploadExcelFile {

    @Autowired
    private final Books books;

    public UploadExcelFile(Books books) {
        this.books = books;
    }

    @GetMapping("books")
    public ResponseEntity<BookDto> getBookById() {
        return new ResponseEntity<BookDto>(new BookDto(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public List<BookDto> upload(MultipartFile file) throws IOException {
        Map<Integer, Object> data = ExcelProcess.processExcel(file);
        return books.cargarLibors(data);
    }
}
