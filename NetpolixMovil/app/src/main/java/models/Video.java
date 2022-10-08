package models;

public class Video {
    String id_Video;
    String titulo;
    String duracion;
    String categoria;
    String actores;
    String directores;
    String isan;
    String calificacion;
    String idioma;

    public Video(String id_Video, String titulo, String duracion, String categoria, String actores, String directores, String isan, String calificacion, String idioma) {
        this.id_Video = id_Video;
        this.titulo = titulo;
        this.duracion = duracion;
        this.categoria = categoria;
        this.actores = actores;
        this.directores = directores;
        this.isan = isan;
        this.calificacion = calificacion;
        this.idioma = idioma;
    }

    public Video() {
    }

    public String getId_Video() {
        return id_Video;
    }

    public void setId_Video(String id_Video) {
        this.id_Video = id_Video;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
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

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id_Video=" + id_Video +
                ", titulo='" + titulo + '\'' +
                ", duracion='" + duracion + '\'' +
                ", categoria=" + categoria +
                ", actores='" + actores + '\'' +
                ", directores='" + directores + '\'' +
                ", isan='" + isan + '\'' +
                ", calificacion=" + calificacion +
                ", idioma=" + idioma +
                '}';
    }
}
