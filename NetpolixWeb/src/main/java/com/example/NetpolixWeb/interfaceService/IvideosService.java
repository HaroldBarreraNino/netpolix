package com.example.NetpolixWeb.interfaceService;

import com.example.NetpolixWeb.modelo.Videos;

import java.util.List;
import java.util.Optional;

public interface IvideosService {
    public List<Videos> listarVideos();
    public Optional<Videos> listarId(int id);
    public int saveVideo(Videos p);
    public void deleteVideo(int id);
}
