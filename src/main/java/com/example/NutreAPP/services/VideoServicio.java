package com.example.NutreAPP.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

@Service
public class VideoServicio {
    @Autowired
    private IVideoRepositorio repositorio;
    
    public Video guarVideo(Video datos){
        return this.repositorio.save(datos);
    }

    public Video buscarPorId(UUID id){
        Optional<Video> videoBuscado = this.repositorio.findById(id);

    if (!videoBuscado.isPresent()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");
    } else{
        return videoBuscado.get();

    }

    }

    public List<Video> buscarTodos(){

        return this.repositorio.findAll();
    }

    public Video modificarVideo(UUID id, Video datos){
        Optional<Video> videoBuscado = this.repositorio.findById(id);

        if (!videoBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");
        } else{
            Video videoExistente = videoBuscado.get();
            videoExistente.setTitulo(datos.getTitulo());
            videoExistente.setDescripcion(datos.getDescripcion());
            videoExistente.setUrl(datos.getUrl());
            return this.repositorio.save(videoExistente);
        }
    }

    public boolean eliminarVideo(UUID id){
        Optional<Video> videoBuscado = this.repositorio.findById(id);

        if (!videoBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");
        } else{
            this.repositorio.deleteById(id);
            return true;
        }
    }
}
 
