package com.example.excel.imports.dto;

public class BookDto {

    private String libro;
    private String autor;
    private String ISBN;
    private Double precio;

    public BookDto() {
    }

    public BookDto(String libro, String autor, String ISBN, Double precio) {
        this.libro = libro;
        this.autor = autor;
        this.ISBN = ISBN;
        this.precio = precio;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
