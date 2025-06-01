package com.example.enlatadosmg.repository;





import com.enlatadosmg.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}