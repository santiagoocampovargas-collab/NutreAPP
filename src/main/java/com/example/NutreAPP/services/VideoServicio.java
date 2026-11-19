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

    //metodo guardar
    
    public Video guarVideo(Video datos){
        return this.repositorio.save(datos);
    }

    // metodo buscar por id

    public Video buscarPorId(UUID id){
        Optional<Video> videoBuscado = this.repositorio.findById(id);

    if (!videoBuscado.isPresent()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");
    } else{
        return videoBuscado.get();

    }

    }

    // metodo para buscar todos

    public List<Video> buscarTodos(){

        return this.repositorio.findAll();
    }

    // metodo para modificar

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

    //metodo para eliminar

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
 
