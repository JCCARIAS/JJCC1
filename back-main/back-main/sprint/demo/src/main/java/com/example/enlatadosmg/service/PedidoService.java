package com.example.enlatadosmg.service;





import com.example.enlatadosmg.model.*;
import com.example.enlatadosmg.repository.*;
import com.example.enlatadosmg.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RepartidorRepository repartidorRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private CajaRepository cajaRepository;

    @Override
    public Pedido createPedido(Pedido pedido) {
        // Configurar fecha/hora actual
        pedido.setFechaHoraInicio(LocalDateTime.now());

        // Establecer estado inicial
        pedido.setEstado("Pendiente");

        // Calcular número de cajas
        pedido.setNumeroCajas(pedido.getCajas().size());

        // Marcar repartidor y vehículo como no disponibles
        if (pedido.getRepartidor() != null) {
            Repartidor repartidor = pedido.getRepartidor();
            repartidor.setDisponible(false);
            repartidorRepository.save(repartidor);
        }

        if (pedido.getVehiculo() != null) {
            Vehiculo vehiculo = pedido.getVehiculo();
            vehiculo.setDisponible(false);
            vehiculoRepository.save(vehiculo);
        }

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido getPedidoByNumero(Long numeroPedido) {
        return pedidoRepository.findById(numeroPedido).orElse(null);
    }

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido completarPedido(Long numeroPedido) {
        Pedido pedido = pedidoRepository.findById(numeroPedido).orElse(null);
        if (pedido != null) {
            pedido.setEstado("Completado");

            // Liberar repartidor y vehículo
            if (pedido.getRepartidor() != null) {
                Repartidor repartidor = pedido.getRepartidor();
                repartidor.setDisponible(true);
                repartidorRepository.save(repartidor);
            }

            if (pedido.getVehiculo() != null) {
                Vehiculo vehiculo = pedido.getVehiculo();
                vehiculo.setDisponible(true);
                vehiculoRepository.save(vehiculo);
            }

            return pedidoRepository.save(pedido);
        }
        return null;
    }

    @Override
    public List<Pedido> getPedidosPendientes() {
        return pedidoRepository.findByEstado("Pendiente");
    }

    @Override
    public List<Pedido> getPedidosCompletados() {
        return pedidoRepository.findByEstado("Completado");
    }
}