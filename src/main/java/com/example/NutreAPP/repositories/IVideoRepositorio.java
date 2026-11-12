package com.example.NutreAPP.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Video;


@Repository
public interface IVideoRepositorio extends JpaRepository<Video, UUID> {

    // buscar videos por categoria
    List<Video> findByCategoria(String categoria);

    // buscar videos por titulo (ignora mayúsculas/minúsculas)
    List<Video> findByTituloIgnoreCase(String titulo);

    // buscar videos cuya descripcion contenga un fragmento
    List<Video> findByDescripcionContainingIgnoreCase(String fragmento);

    // buscar videos por URL
    List<Video> findByUrl(String url);

    // buscar videos por titulo y categoria
    List<Video> findByTituloAndCategoria(String titulo, String categoria);
}