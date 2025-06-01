package com.example.enlatadosmg.repository;




import com.enlatadosmg.model.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CajaRepository extends JpaRepository<Caja, Long> {
    @Query(value = "SELECT * FROM caja ORDER BY fecha_ingreso DESC LIMIT 1", nativeQuery = true)
    Caja findTopByOrderByFechaIngresoDesc();
}