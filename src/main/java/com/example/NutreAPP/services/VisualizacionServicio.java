package com.example.NutreAPP.services;

import java.util.List;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service 
public class VisualizacionServicio {

    @Autowired 
    private IVisualizacionRepositorio repositorio;

    public Visualizacion guardar(Visualizacion datos){

        return this.repositorio.save(datos);
    }

       //metodo para buscar por id
    public Video buscarPorId(UUID id){
        Optional<Visualizacion> visualizacionBuscado =this.repositorio.findById(id);
        if (!visualizacionBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
            
        }else{
            return visualizacionBuscado.get();
        }

    }



    //metodo para bscar todos

    public List<Visualizacion> buscarTodos(){
        this.repositorio.findAll();
    }

    //metodo para guardar
    //metodo para buscar por id
    //metodo para bscar todos
    //metodo para modificar
    //metodo para eliminar

}
