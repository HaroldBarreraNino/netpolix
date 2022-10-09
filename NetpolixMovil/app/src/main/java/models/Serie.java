package models;

import java.io.Serializable;

public class Serie implements Serializable {
    String id_Serie;
    String titulo;
    String temporadas;
    String capitulos;

    public Serie() {
    }

    public Serie(String id_Serie, String titulo, String temporadas, String capitulos) {
        this.id_Serie = id_Serie;
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.capitulos = capitulos;
    }

    public String getId_Serie() {
        return id_Serie;
    }

    public void setId_Serie(String id_Serie) {
        this.id_Serie = id_Serie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(String temporadas) {
        this.temporadas = temporadas;
    }

    public String getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(String capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id_Serie='" + id_Serie + '\'' +
                ", titulo='" + titulo + '\'' +
                ", temporadas='" + temporadas + '\'' +
                ", capitulos='" + capitulos + '\'' +
                '}';
    }
}
