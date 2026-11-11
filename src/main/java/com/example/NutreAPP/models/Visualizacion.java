package com.example.NutreAPP.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "visualizacion")
public class Visualizacion {

    @Id 
    @GeneratedValue  (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name="fecha_visualizacion", nullable = false, unique = false, length = 100)
    private LocalDate fecha_visualizacion;

    @Column (name="completado", nullable = false, unique = false )
    private Boolean completado;
    
    public Visualizacion() {
    }

    public Visualizacion(UUID id, LocalDate fecha_visualizacion, Boolean completado) {
        this.id = id;
        this.fecha_visualizacion = fecha_visualizacion;
        this.completado = completado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFecha_visualizacion() {
        return fecha_visualizacion;
    }

    public void setFecha_visualizacion(LocalDate fecha_visualizacion) {
        this.fecha_visualizacion = fecha_visualizacion;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    
}
