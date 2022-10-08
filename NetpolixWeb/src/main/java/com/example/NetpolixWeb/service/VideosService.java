package com.example.NetpolixWeb.service;

import com.example.NetpolixWeb.interfaceService.IvideosService;
import com.example.NetpolixWeb.interfaces.IVideos;
import com.example.NetpolixWeb.modelo.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideosService implements IvideosService {

    @Autowired
    private IVideos data;

    @Override
    public List<Videos> listarVideos() {
        return (List<Videos>)data.findAll();
    }

    @Override
    public Optional<Videos> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int saveVideo(Videos p) {
        int res = 0;
        Videos video = data.save(p);
        if (!video.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void deleteVideo(int id) {
        data.deleteById(id);
    }
}
