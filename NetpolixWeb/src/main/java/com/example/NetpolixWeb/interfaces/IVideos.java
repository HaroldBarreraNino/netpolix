package com.example.NetpolixWeb.interfaces;

import com.example.NetpolixWeb.modelo.Videos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideos extends CrudRepository<Videos, Integer> {
}
