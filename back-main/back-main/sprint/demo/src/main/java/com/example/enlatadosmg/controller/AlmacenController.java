package com.example.enlatadosmg.controller;


import com.example.enlatadosmg.model.Caja;
import com.example.enlatadosmg.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/almacen")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @PostMapping("/cajas")
    public ResponseEntity<Caja> agregarCaja() {
        Caja nuevaCaja = almacenService.pushCaja();
        return new ResponseEntity<>(nuevaCaja, HttpStatus.CREATED);
    }

    @DeleteMapping("/cajas")
    public ResponseEntity<Caja> sacarCaja() {
        Caja caja = almacenService.popCaja();
        return ResponseEntity.ok(caja);
    }

    @GetMapping("/cajas/total")
    public ResponseEntity<Integer> totalCajas() {
        int total = almacenService.totalCajas();
        return ResponseEntity.ok(total);
    }
}