package com.example.NetpolixWeb.controlador;

import com.example.NetpolixWeb.interfaceService.IvideosService;
import com.example.NetpolixWeb.modelo.Persona;
import com.example.NetpolixWeb.modelo.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ControladorVideos {
    @Autowired
    private IvideosService service;

    @GetMapping("/listavideos")
    public String listarVideos(Model model){
        List<Videos> videos = service.listarVideos();
        System.out.println("----LISTA DE PERSONAS----");
        System.out.println(videos.toString());
        System.out.println("-------------------------");
        model.addAttribute("videos", videos);
        return "listavideosadmin";
    }

    @GetMapping("/newvideo")
    public String agregarVideo(Model model){
        model.addAttribute("video", new Videos());
        return "formvideo";
    }

    @PostMapping("/savevideo")
    public String saveVideo (Videos p, Model model){
        service.saveVideo(p);
        return "redirect:/listavideos";
    }

    @GetMapping("/eliminarvideo/{id}")
    public String deleteVideo(Model model, @PathVariable int id){
        service.deleteVideo(id);
        return "redirect:/listavideos";
    }
}

