package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;

@Service 
public class UsuarioServicio {

    //metodo para guardar
    //metodo para buscar por id
    //metodo para buscar todos
    //metodo para modificar
    //metodo para eliminar

    //metodo para buscar por departamento y rol
    //metodo para buscar por correo
    //metodo para buscar por rol
    //metodo para verificar correo

    @Autowired 
    private IUsuarioRepositorio repositorio;

    public Usuario guardar(Usuario datos){
        return  this.repositorio.save(datos);

}

}
