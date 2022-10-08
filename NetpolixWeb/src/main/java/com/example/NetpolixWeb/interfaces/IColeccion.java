package com.example.NetpolixWeb.interfaces;

import com.example.NetpolixWeb.modelo.Coleccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColeccion extends CrudRepository<Coleccion, Integer> {
}
