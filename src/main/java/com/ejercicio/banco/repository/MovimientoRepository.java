package com.ejercicio.banco.repository;

import com.ejercicio.banco.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Esta interfaz extiende JpaRepository y maneja la entidad Movimiento con clave primaria tipo Long
@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
