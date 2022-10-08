package com.example.NetpolixWeb.service;

import com.example.NetpolixWeb.interfaceService.IserieService;
import com.example.NetpolixWeb.interfaces.ISerie;
import com.example.NetpolixWeb.modelo.Coleccion;
import com.example.NetpolixWeb.modelo.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService implements IserieService {

    @Autowired
    private ISerie data;

    @Override
    public List<Serie> listarSerie() {
        return (List<Serie>)data.findAll();
    }

    @Override
    public Optional<Serie> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int saveSerie(Serie p) {
        int res = 0;
        Serie serie = data.save(p);
        if (!serie.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void deleteSerie(int id) {
        data.deleteById(id);
    }
}
