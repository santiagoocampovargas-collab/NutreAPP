package com.example.NutreAPP.models;

import java.util.List;
import java.util.UUID;

import com.example.NutreAPP.models.helpers.Departamento;
import com.example.NutreAPP.models.helpers.Rol;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name="usuarios")

public class Usuario {

    @Id 
    @GeneratedValue  (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name="nombre", nullable = false, unique = false, length = 100)
    private String nombre;

    @Column (name = "correo", nullable = false, unique = true, length = 80)
    private String correo;

    @Enumerated (EnumType.STRING)
    @Column (name = "departamento", nullable = false, unique = false)
    private Departamento departamento;

    @Enumerated (EnumType.STRING)
    @Column (name = "rol", nullable = false, unique = false)
    private Rol rol;

    @Column (name = "contraseña_hash", nullable = false, unique = false)
    private String contrasena_hash;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference(value = "usuario-visualizacion")
    private List<Visualizacion> visualizaciones;

    public Usuario() {
    }
    public Usuario(UUID id, String nombre, String correo, Departamento departamento, Rol rol, String contrasena_hash) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
        this.rol = rol;
        this.contrasena_hash = contrasena_hash;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getContrasena_hash() {
        return contrasena_hash;
    }
    public void setContrasena_hash(String contrasena_hash) {
        this.contrasena_hash = contrasena_hash;
    }

    
    
}
