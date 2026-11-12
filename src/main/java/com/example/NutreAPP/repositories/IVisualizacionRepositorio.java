package com.example.NutreAPP.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Visualizacion;

@Repository
public interface IVisualizacionRepositorio extends JpaRepository<Visualizacion, UUID> {

    // buscar visualizaciones por fecha (requiere renombrar el atributo a fechaVisualizacion)
    List<Visualizacion> findByFechaVisualizacion(LocalDate fechaVisualizacion);

    // buscar visualizaciones sin completar
    List<Visualizacion> findByCompletadoFalse();

    // buscar visualizaciones completas
    List<Visualizacion> findByCompletadoTrue();
}