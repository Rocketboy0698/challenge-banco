package com.ejercicio.banco.model; // Define el paquete donde está esta clase

import jakarta.persistence.Entity;      // Marca esta clase como entidad JPA
import jakarta.persistence.Id;         // Indica cuál campo es clave primaria
import jakarta.persistence.Inheritance; // Permite definir herencia entre entidades
import jakarta.persistence.InheritanceType;

@Entity // Esta clase será mapeada a una tabla en la base de datos
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Una sola tabla para todas las clases hijas
public class Persona {

    @Id // Clave primaria de la tabla
    private Long identificacion;

    private String nombre;
    private String genero;
    private int edad;
    private String direccion;
    private String telefono;

    public Persona() {} // Constructor vacío requerido por JPA

    // Métodos Get (obtener) y Set (asignar) para cada atributo

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
