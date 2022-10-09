package models;

import java.io.Serializable;

public class Coleccion implements Serializable {
    String id_Coleccion;
    String titulo;
    String volumen;
    String capitulos;

    public Coleccion() {
    }

    public Coleccion(String id_Coleccion, String titulo, String volumen, String capitulos) {
        this.id_Coleccion = id_Coleccion;
        this.titulo = titulo;
        this.volumen = volumen;
        this.capitulos = capitulos;
    }

    public String getId_Coleccion() {
        return id_Coleccion;
    }

    public void setId_Coleccion(String id_Coleccion) {
        this.id_Coleccion = id_Coleccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(String capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "Coleccion{" +
                "id_Coleccion='" + id_Coleccion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", volumen='" + volumen + '\'' +
                ", capitulos='" + capitulos + '\'' +
                '}';
    }
}
