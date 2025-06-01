package com.example.enlatadosmg.service;


import com.example.enlatadosmg.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
    Optional<Cliente> findByEmail(String email);
}