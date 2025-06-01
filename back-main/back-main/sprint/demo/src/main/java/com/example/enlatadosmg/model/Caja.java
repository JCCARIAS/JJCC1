package com.example.enlatadosmg.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long correlativo;
    private LocalDate fechaIngreso;

    // Getters y Setters
    public Long getCorrelativo() { return correlativo; }
    public void setCorrelativo(Long correlativo) { this.correlativo = correlativo; }
    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }
}