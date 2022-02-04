package com.example.excel.imports.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private Long id;
    private String name;
    private String autor;

}
