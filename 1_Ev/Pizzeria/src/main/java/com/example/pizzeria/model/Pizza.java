package com.example.pizzeria.model;

import java.util.ArrayList;

public class Pizza {
    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
    private String tamanio;
    private int precio;

    public Pizza(String nombre, String tamanio, int precio) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
        this.tamanio = tamanio;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + '\'' +
                ", ingredientes=" + ingredientes +
                ", tamanio=" + tamanio +
                ", precio=" + precio;
    }
}
