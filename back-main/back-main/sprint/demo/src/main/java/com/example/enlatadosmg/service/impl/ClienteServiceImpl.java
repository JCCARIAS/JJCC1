package com.example.enlatadosmg.service.impl;





import com.example.enlatadosmg.estructuras.ArbolAVL;
import com.example.enlatadosmg.model.Cliente;
import com.example.enlatadosmg.repository.ClienteRepository;
import com.example.enlatadosmg.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private ArbolAVL arbolClientes;

    @PostConstruct
    public void init() {
        arbolClientes = new ArbolAVL();
        // Cargar clientes existentes en el árbol
        clienteRepository.findAll().forEach(arbolClientes::insertar);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        Cliente saved = clienteRepository.save(cliente);
        arbolClientes.insertar(saved);
        return saved;
    }

    @Override
    public Cliente getClienteByCui(String cui) {
        // Buscar primero en el árbol AVL
        Cliente cliente = arbolClientes.buscar(cui);
        if (cliente == null) {
            return clienteRepository.findById(cui).orElse(null);
        }
        return cliente;
    }

    @Override
    public List<Cliente> getAllClientes() {
        // Para listar todos, usamos el repositorio
        return clienteRepository.findAll();
    }

    @Override
    public String generarReporteArbol() {
        return arbolClientes.inorden();
    }
}