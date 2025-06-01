package com.example.enlatadosmg.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    private String cui;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;

    // Getters y Setters
    public String getCui() { return cui; }
    public void setCui(String cui) { this.cui = cui; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}