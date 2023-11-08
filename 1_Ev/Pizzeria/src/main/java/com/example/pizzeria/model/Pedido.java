package com.example.pizzeria.model;

public class Pedido {

    private int id;
    private String nombre;
    private String telefono;
    private Pizza pizza;

    public Pedido(int id, String nombre, String telefono, Pizza pizza) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pizza = pizza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
