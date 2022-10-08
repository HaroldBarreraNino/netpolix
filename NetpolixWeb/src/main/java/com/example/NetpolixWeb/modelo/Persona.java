package com.example.NetpolixWeb.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_persona;
    private int cedula;
    private String nombre_completo;
    private String fecha_nacimiento;

    public Persona() {
    }

    public Persona(int id_persona, int cedula, String nombre_completo, String fecha_nacimiento) {
        this.id_persona = id_persona;
        this.cedula = cedula;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getid_Persona() {
        return id_persona;
    }

    public void setid_Persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
