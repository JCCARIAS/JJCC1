package com.example.enlatadosmg.model;





import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroPedido;
    private String departamentoOrigen;
    private String departamentoDestino;
    private LocalDateTime fechaHoraInicio;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Repartidor repartidor;

    @ManyToOne
    private Vehiculo vehiculo;

    @OneToMany
    private List<Caja> cajas;

    private int numeroCajas;
    private String estado; // "Pendiente" o "Completado"

    // Getters y Setters
    public Long getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(Long numeroPedido) { this.numeroPedido = numeroPedido; }
    public String getDepartamentoOrigen() { return departamentoOrigen; }
    public void setDepartamentoOrigen(String departamentoOrigen) { this.departamentoOrigen = departamentoOrigen; }
    public String getDepartamentoDestino() { return departamentoDestino; }
    public void setDepartamentoDestino(String departamentoDestino) { this.departamentoDestino = departamentoDestino; }
    public LocalDateTime getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Repartidor getRepartidor() { return repartidor; }
    public void setRepartidor(Repartidor repartidor) { this.repartidor = repartidor; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public List<Caja> getCajas() { return cajas; }
    public void setCajas(List<Caja> cajas) { this.cajas = cajas; }
    public int getNumeroCajas() { return numeroCajas; }
    public void setNumeroCajas(int numeroCajas) { this.numeroCajas = numeroCajas; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}