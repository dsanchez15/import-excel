package com.example.excel.imports.services;

import com.example.excel.imports.dto.BookDto;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BooksImpl implements Books {

    @Override
    public List<BookDto> cargarLibors(Map<Integer, Object> dataExcel) {
        List<Object> lista = new ArrayList<>(dataExcel.values());
        lista.remove(0);
        List<BookDto> libros = new ArrayList<>();

        for (Object object : lista) {
            Map<Integer, String> map = (Map<Integer, String>) object;
            map.entrySet().forEach(System.out::println);
            libros.add(procesarLibros(map));
        }

        return libros;
    }

    private BookDto procesarLibros(Map<Integer, String> libro) {
        BookDto bookDto = new BookDto();

        for (Map.Entry<Integer, String> map : libro.entrySet()) {
            switch (map.getKey()) {
                case 0:
                    bookDto.setLibro(map.getValue());
                    break;
                case 1:
                    bookDto.setAutor(map.getValue());
                    break;
                case 2:
                    bookDto.setISBN(map.getValue());
                    break;
                case 3:
                    bookDto.setPrecio(Double.parseDouble(map.getValue()));
                    break;
                default:
                    break;
            }
        }

        return bookDto;
    }
}
