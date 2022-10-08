package com.example.NetpolixWeb.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Serie")
public class Serie {
    @Id
    public int id_serie;
    private String titulo;
    private int temporadas;
    private int capitulos;

    public Serie() {
    }

    public Serie(int id_serie, String titulo, int temporadas, int capitulos) {
        this.id_serie = id_serie;
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.capitulos = capitulos;
    }

    public int getId_serie() {
        return id_serie;
    }

    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }
}
