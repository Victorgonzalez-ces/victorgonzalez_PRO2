package com.example.victor_gonzalez_dam2_2711;

import java.io.Serializable;

public class PaisJSON{
    public String nombre_en;

    public PaisJSON(String nombre_en) {
        this.nombre_en = nombre_en;
    }


    public String getNombre_en() {
        return nombre_en;
    }

    public void setNombre_en(String nombre_en) {
        this.nombre_en = nombre_en;
    }

    @Override
    public String toString() {
        return nombre_en;
    }
}
