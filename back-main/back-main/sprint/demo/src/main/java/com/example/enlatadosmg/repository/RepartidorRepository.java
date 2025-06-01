package com.example.enlatadosmg.repository;



import com.example.enlatadosmg.model.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepartidorRepository extends JpaRepository<Repartidor, String> {
    @Query("SELECT r FROM Repartidor r WHERE r.disponible = true ORDER BY r.cui ASC")
    List<Repartidor> findFirstDisponible();
}