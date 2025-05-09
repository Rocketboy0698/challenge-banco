package com.ejercicio.banco.controller;

import com.ejercicio.banco.model.Cuenta;
import com.ejercicio.banco.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    // GET: Obtener todas las cuentas
    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    // POST: Crear una nueva cuenta
    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    // PUT: Actualizar una cuenta por ID
    @PutMapping("/{id}")
    public Cuenta updateCuenta(@PathVariable String id, @RequestBody Cuenta cuentaDetails) {
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(id);

        if (optionalCuenta.isPresent()) {
            Cuenta cuenta = optionalCuenta.get();
            cuenta.setNumeroCuenta(cuentaDetails.getNumeroCuenta());
            cuenta.setTipoCuenta(cuentaDetails.getTipoCuenta());
            cuenta.setSaldoInicial(cuentaDetails.getSaldoInicial());
            cuenta.setEstado(cuentaDetails.getEstado());
            return cuentaRepository.save(cuenta);
        } else {
            return null;
        }
    }

    // DELETE: Eliminar una cuenta por ID
    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable String id) {
        cuentaRepository.deleteById(id);
    }
}
