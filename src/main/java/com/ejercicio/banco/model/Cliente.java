package com.ejercicio.banco.model; // Paquete donde se encuentra la clase

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity // Marca esta clase como una entidad de base de datos
public class Cliente extends Persona { // Hereda atributos de Persona

    @Column
    private String contrasena; // Campo para la contraseña del cliente

    @Column
    private Boolean estado; // Campo para indicar si el cliente está activo o no

    public Cliente() {} // Constructor vacío requerido por JPA

    // Métodos getter y setter para los atributos propios de Cliente

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

