package com.example.excel.imports.services;

import com.example.excel.imports.dto.BookDto;

import java.util.List;
import java.util.Map;

public interface Books {

    public List<BookDto> cargarLibors(Map<Integer, Object> dataExcel);
}
