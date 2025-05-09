package com.ejercicio.banco.model; // Ubicación del archivo en el proyecto

import jakarta.persistence.Entity;       // Permite que JPA reconozca esta clase como entidad
import jakarta.persistence.Id;           // Marca un campo como clave primaria
import jakarta.persistence.Table;        // Permite darle un nombre a la tabla en la base de datos

@Entity // Esta clase es una entidad de base de datos
@Table(name = "cuenta") // El nombre de la tabla será "cuenta"
public class Cuenta {

    @Id // Este campo será la clave primaria
    private String numeroCuenta;

    private String tipoCuenta;
    private double saldoInicial;
    private String estado;

    // Métodos GET y SET permiten acceder o modificar los atributos

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
