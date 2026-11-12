package com.example.NutreAPP.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Usuario;

@Repository 
public interface IUsuarioRepositorio extends JpaRepository<Usuario,UUID>{

    List<Usuario> findByDepartamentoAndRol(String departamento, String rol);

    Optional<Usuario> findByCorreo(String correo);

    List<Usuario> findByRolOrderByNombreAcs(String rol);

    Boolean existsByCorreo(String correo);
    

}
