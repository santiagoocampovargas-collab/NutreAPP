package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service 
public class VisualizacionServicio {

    @Autowired 
    private IVisualizacionRepositorio repositorio;

    public Visualizacion guardar(Visualizacion datos){

        return this.repositorio.save(datos);
    }

    //metodo para guardar
    //metodo para buscar por id
    //metodo para bscar todos
    //metodo para modificar
    //metodo para eliminar

}
