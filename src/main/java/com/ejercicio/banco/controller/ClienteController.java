package com.ejercicio.banco.controller;

import com.ejercicio.banco.model.Cliente;
import com.ejercicio.banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Define que esta clase es un controlador REST
@RestController
@RequestMapping("/clientes") // Ruta base: http://localhost:8081/clientes
public class ClienteController {

    @Autowired // Inyecta automáticamente el repositorio para usarlo sin crear instancias
    private ClienteRepository clienteRepository;

    // Método GET - Obtener todos los clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll(); // Devuelve todos los registros de clientes
    }

    // Método POST - Crear nuevo cliente
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente); // Guarda el cliente recibido en el cuerpo
    }

    // Método PUT - Actualizar cliente existente
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(); // Busca por ID
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setGenero(clienteActualizado.getGenero());
        cliente.setEdad(clienteActualizado.getEdad());
        cliente.setDireccion(clienteActualizado.getDireccion());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setContrasena(clienteActualizado.getContrasena()); // <- CORREGIDO
        cliente.setEstado(clienteActualizado.getEstado());
        return clienteRepository.save(cliente); // Guarda cambios
    }

    // Método DELETE - Eliminar cliente por ID
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id); // Elimina por ID
    }
}
