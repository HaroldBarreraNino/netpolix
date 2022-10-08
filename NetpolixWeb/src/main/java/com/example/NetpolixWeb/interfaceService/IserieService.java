package com.example.NetpolixWeb.interfaceService;

import com.example.NetpolixWeb.modelo.Coleccion;
import com.example.NetpolixWeb.modelo.Serie;

import java.util.List;
import java.util.Optional;

public interface IserieService {

    public List<Serie> listarSerie();
    public Optional<Serie> listarId(int id);
    public int saveSerie(Serie p);
    public void deleteSerie(int id);
}
