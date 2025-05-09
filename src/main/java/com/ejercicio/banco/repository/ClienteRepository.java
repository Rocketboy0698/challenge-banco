package com.ejercicio.banco.repository;

import com.ejercicio.banco.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aquí se pueden agregar métodos personalizados si se desea
}
