package com.example.NetpolixWeb.service;

import com.example.NetpolixWeb.interfaceService.IcoleccionService;
import com.example.NetpolixWeb.interfaces.IColeccion;
import com.example.NetpolixWeb.modelo.Coleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColeccionService implements IcoleccionService {

    @Autowired
    private IColeccion data;

    @Override
    public List<Coleccion> listarColeccion() {
        return (List<Coleccion>)data.findAll();
    }

    @Override
    public Optional<Coleccion> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int saveColeccion(Coleccion p) {
        int res = 0;
        Coleccion coleccion = data.save(p);
        if (!coleccion.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void deleteColeccion(int id) {
        data.deleteById(id);
    }
}
