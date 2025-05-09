package com.ejercicio.banco.controller;

import com.ejercicio.banco.model.Cuenta;
import com.ejercicio.banco.model.Movimiento;
import com.ejercicio.banco.repository.CuentaRepository;
import com.ejercicio.banco.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos") // URL base: http://localhost:8081/movimientos
public class MovimientoController {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    // Endpoint GET - Lista todos los movimientos registrados
    @GetMapping
    public List<Movimiento> listarMovimientos() {
        return movimientoRepository.findAll();
    }

    // Endpoint POST - Registra un nuevo movimiento
    @PostMapping
    public ResponseEntity<?> crearMovimiento(@RequestBody Movimiento movimiento) {
        // Buscar la cuenta por ID
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(movimiento.getIdCuenta());

        if (optionalCuenta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Cuenta no encontrada");
        }

        Cuenta cuenta = optionalCuenta.get();

        double saldoActual = cuenta.getSaldoInicial();
        double valorMovimiento = movimiento.getValor();

        // Verificar tipo de movimiento y actualizar el saldo
        if (movimiento.getTipoMovimiento().equalsIgnoreCase("Retiro")) {
            if (valorMovimiento > saldoActual) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Saldo no disponible");
            }
            cuenta.setSaldoInicial(saldoActual - valorMovimiento);
        } else if (movimiento.getTipoMovimiento().equalsIgnoreCase("Depósito")) {
            cuenta.setSaldoInicial(saldoActual + valorMovimiento);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Tipo de movimiento no válido (use 'Retiro' o 'Depósito')");
        }

        // Guardar nuevo saldo y registrar movimiento
        movimiento.setFecha(LocalDate.now());
        movimiento.setSaldo(cuenta.getSaldoInicial());

        cuentaRepository.save(cuenta);
        movimientoRepository.save(movimiento);

        return ResponseEntity.ok("Movimiento registrado con éxito");
    }

    // Endpoint PUT - Actualiza un movimiento por su ID
    @PutMapping("/{id}")
    public Movimiento actualizarMovimiento(@PathVariable Long id, @RequestBody Movimiento movimientoActualizado) {
        return movimientoRepository.findById(id).map(movimiento -> {
            movimiento.setFecha(movimientoActualizado.getFecha());
            movimiento.setTipoMovimiento(movimientoActualizado.getTipoMovimiento());
            movimiento.setValor(movimientoActualizado.getValor());
            movimiento.setSaldo(movimientoActualizado.getSaldo());
            movimiento.setIdCuenta(movimientoActualizado.getIdCuenta());
            return movimientoRepository.save(movimiento);
        }).orElseGet(() -> {
            movimientoActualizado.setId(id);
            return movimientoRepository.save(movimientoActualizado);
        });
    }

    // Endpoint DELETE - Elimina un movimiento por su ID
    @DeleteMapping("/{id}")
    public void eliminarMovimiento(@PathVariable Long id) {
        movimientoRepository.deleteById(id);
    }
}



