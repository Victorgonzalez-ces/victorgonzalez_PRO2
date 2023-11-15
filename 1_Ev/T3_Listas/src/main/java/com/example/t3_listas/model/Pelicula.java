package com.example.t3_listas.model;

import javafx.collections.ObservableList;

public class Pelicula {

    private String titulo, genero;
    private int anio;

    public Pelicula(String titulo, String genero, int anio) {
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
    }

    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "titulo= " + titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
