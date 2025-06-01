package com.example.enlatadosmg.controller;



import com.example.enlatadosmg.model.Cliente;
import com.example.enlatadosmg.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.createCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{cui}")
    public ResponseEntity<Cliente> getClienteByCui(@PathVariable String cui) {
        Cliente cliente = clienteService.getClienteByCui(cui);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{cui}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable String cui, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(cui, cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{cui}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String cui) {
        clienteService.deleteCliente(cui);
        return ResponseEntity.noContent().build();
    }
}
