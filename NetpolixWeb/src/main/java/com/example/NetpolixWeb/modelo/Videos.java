package com.example.NetpolixWeb.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Videos")
public class Videos {
    @Id
    public int id_video;
    private String titulo;
    private String duracion;
    private int categoria;
    private String actores;
    private String directores;
    private String isan;
    private int calificacion;
    private int idioma;

    public Videos() {
    }

    public Videos(int id_Video, String titulo, String duracion, int categoria, String actores, String directores, String isan, int calificacion, int idioma) {
        this.id_video = id_Video;
        this.titulo = titulo;
        this.duracion = duracion;
        this.categoria = categoria;
        this.actores = actores;
        this.directores = directores;
        this.isan = isan;
        this.calificacion = calificacion;
        this.idioma = idioma;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirectores() {
        return directores;
    }

    public void setDirectores(String directores) {
        this.directores = directores;
    }

    public String getIsan() {
        return isan;
    }

    public void setIsan(String isan) {
        this.isan = isan;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }
}
