package com.example.NutreAPP.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;

@Service 
public class UsuarioServicio {

    
    
    
    
    //metodo para eliminar

    //metodo para buscar por departamento y rol
    //metodo para buscar por correo
    //metodo para buscar por rol
    //metodo para verificar correo
    
    //metodo para guardar
    @Autowired 
    private IUsuarioRepositorio repositorio;

    public Usuario guardar(Usuario datos){
        return  this.repositorio.save(datos);

}


//metodo para buscar por id


    public Usuario buscarPorId(UUID id){
        Optional<Usuario> usuarioBuscado =this.repositorio.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");

        }else{
            return usuarioBuscado.get();
        }

    }


    // //metodo para buscar todos

    public List<Usuario> buscarTtodos(){
        return this.repositorio.findAll();
    }

    //metodo para modificar

    public Usuario modificar(UUID id, Usuario datos){
         Optional<Usuario> usuarioBuscado =this.repositorio.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");

        }else{

            //1. precargar la infi que existe actualmente en bd
            Usuario usuarioEncontrado=usuarioBuscado.get();

            //2.espacio para modificar solo las propiedades permitidas
            usuarioEncontrado.setNombre(datos.getNombre());
            usuarioEncontrado.setRol(datos.getRol());

            //3.espacio para volver a guardar el usuario que se acaba de modificar
            return this.repositorio.save(usuarioEncontrado);
            
        }

        
    }

}
