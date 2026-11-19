package com.example.NutreAPP.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;

@Component 
public class UsuarioValidacion {

    @Autowired 
    private IUsuarioRepositorio repositorio;

    //validacion de formato

    //1.validar que un campo sea obligatorio

    public void validarTextoObligatorio(String valor, String campo){
        if (valor== null || valor.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el campo "+campo+" es obligatorio");
        }
    }

    //2.validar la longitud de un nombre

    public void validarNombre(String nombre){
        if (nombre.trim().length()<3 || nombre.trim().length()>100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el nombre debe tener entre 3 y 100 caracteres");
            
        }
    }

    //3.expresion regular para validar que un correo si sea un correo

    public void validarCorreo(String correo){
        if (!correo.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el correo nocumple el formato esperado");
            
        }
    }

    //4.validar que la contraseña tenga minimo 8 caracteres

    public void validarContraseña(String contraseña){
        if (contraseña.length()>8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La contraseña debe de tener maas de 8 caracteres");

            
        }
    }

    //validaciones de negocio

    //1. validar que el correo de un usuario que se quiera registrar no exista en la BS

    public void validarUsuarioNuevo(Usuario datos){
        String correoEntregado=datos.getCorreo();
        if (this.repositorio.existsByCorreo(correoEntregado)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El correo entregado ya existe en BD");
            
        }
    }

}
