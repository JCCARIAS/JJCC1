package com.example.enlatadosmg.service.impl;





import com.example.enlatadosmg.model.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido createPedido(Pedido pedido);
    Pedido getPedidoByNumero(Long numeroPedido);
    List<Pedido> getAllPedidos();
    Pedido completarPedido(Long numeroPedido);
    List<Pedido> getPedidosPendientes();
    List<Pedido> getPedidosCompletados();
}