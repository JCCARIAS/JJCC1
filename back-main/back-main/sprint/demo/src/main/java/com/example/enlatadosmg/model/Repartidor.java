package com.example.enlatadosmg.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Repartidor {
    @Id
    private String cui;
    private String nombre;
    private String apellidos;
    private String licencia;
    private String telefono;
    private boolean disponible;

    // Getters y Setters
    public String getCui() { return cui; }
    public void setCui(String cui) { this.cui = cui; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = licencia; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}