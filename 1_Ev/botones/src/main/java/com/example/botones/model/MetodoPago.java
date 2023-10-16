package com.example.botones.model;


public class MetodoPago {

    private int id;

    private String descripcion;

    private String caracteristica;

    public MetodoPago() {
    }

    public MetodoPago(int id, String descripcion, String caracteristica) {
        this.id = id;
        this.descripcion = descripcion;
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "MetodoPago{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", caracteristica='" + caracteristica + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
}
