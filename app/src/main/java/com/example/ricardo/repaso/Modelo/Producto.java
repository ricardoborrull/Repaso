package com.example.ricardo.repaso.Modelo;

/**
 * Created by Ricardo on 30/01/2018.
 */

public class Producto {

    private String nombre;
    private String precio;

    public Producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
