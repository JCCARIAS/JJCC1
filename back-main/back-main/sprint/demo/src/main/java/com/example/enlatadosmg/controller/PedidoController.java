package com.example.enlatadosmg.controller;




import com.example.enlatadosmg.model.Pedido;
import com.example.enlatadosmg.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.createPedido(pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/{numeroPedido}")
    public ResponseEntity<Pedido> getPedidoByNumero(@PathVariable Long numeroPedido) {
        Pedido pedido = pedidoService.getPedidoByNumero(numeroPedido);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @PutMapping("/{numeroPedido}/completar")
    public ResponseEntity<Pedido> completarPedido(@PathVariable Long numeroPedido) {
        Pedido pedido = pedidoService.completarPedido(numeroPedido);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<Pedido>> getPedidosPendientes() {
        List<Pedido> pedidos = pedidoService.getPedidosPendientes();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/completados")
    public ResponseEntity<List<Pedido>> getPedidosCompletados() {
        List<Pedido> pedidos = pedidoService.getPedidosCompletados();
        return ResponseEntity.ok(pedidos);
    }
}
