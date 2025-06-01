package com.example.enlatadosmg.repository;





import com.enlatadosmg.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    @Query("SELECT v FROM Vehiculo v WHERE v.disponible = true ORDER BY v.placa ASC")
    List<Vehiculo> findFirstDisponible();
}