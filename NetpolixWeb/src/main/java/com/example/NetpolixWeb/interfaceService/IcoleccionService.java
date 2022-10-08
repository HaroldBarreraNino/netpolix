package com.example.NetpolixWeb.interfaceService;

import com.example.NetpolixWeb.modelo.Coleccion;

import java.util.List;
import java.util.Optional;

public interface IcoleccionService {
    public List<Coleccion> listarColeccion();
    public Optional<Coleccion> listarId(int id);
    public int saveColeccion(Coleccion p);
    public void deleteColeccion(int id);
}
