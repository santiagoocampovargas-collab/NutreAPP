package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

@Service 
public class VideoServicio {

    @Autowired 
    private IVideoRepositorio repositorio;

    public Video guardar(Video datos){
        return this.repositorio.save(datos);
    }

    //metodo para guardar
    //metodo para buscar por id
    //metodo para bscar todos
    //metodo para modificar
    //metodo para eliminar

}



