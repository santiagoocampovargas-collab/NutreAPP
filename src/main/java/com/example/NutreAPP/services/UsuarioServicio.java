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
    // Para programar los servicios necesito los repositorios 
    // INYECCION DE DEPENDENCIAS
    @Autowired
    private IUsuarioRepositorio repositorio;

    //metodo guardar
    public Usuario guardUsuario(Usuario datos){
        return this.repositorio.save(datos);
    }
    // metodo buscar por id
    public Usuario buscarPorId(UUID id){
        Optional<Usuario>usuarioBuscado = this.repositorio.findById(id);

        if (!usuarioBuscado.isPresent()){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else{
            return usuarioBuscado.get();
        }
    }
    // metodo para buscar por todos
    public List<Usuario> buscarTodos(){
        return this.repositorio.findAll();

    }
    // metodo para modificar

    public Usuario modificarUsuario(UUID id, Usuario datos){
        
        Optional<Usuario>usuarioBuscado = this.repositorio.findById(id);

        if (!usuarioBuscado.isPresent()){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else{
            //1. precargar la info que existe actualmente en la base de datos
            Usuario usuarioExistente = usuarioBuscado.get();

            //2. Espacio para modificar las propiedades permitidas
            usuarioExistente.setNombre(datos.getNombre());
            usuarioExistente.setRol(datos.getRol()); 
            
            //3. Guardar la info modificada en la base de datos
            return this.repositorio.save(usuarioExistente);
        }
    }

    // metdo para eliminar
    public boolean eliminarUsuario(UUID id){
        Optional<Usuario>usuarioBuscado = this.repositorio.findById(id);

        if (!usuarioBuscado.isPresent()){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else{
            this.repositorio.deleteById(id);
            return true;
        }
    }
    
    
}