package com.example.NetpolixWeb.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Coleccion")
public class Coleccion {
    @Id
    public int id_coleccion;
    private String titulo;
    private int volumen;
    private int capitulos;

    public Coleccion() {
    }

    public Coleccion(int id_coleccion, String titulo, int volumen, int capitulos) {
        this.id_coleccion = id_coleccion;
        this.titulo = titulo;
        this.volumen = volumen;
        this.capitulos = capitulos;
    }

    public int getId_coleccion() {
        return id_coleccion;
    }

    public void setId_coleccion(int id_coleccion) {
        this.id_coleccion = id_coleccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }
}
