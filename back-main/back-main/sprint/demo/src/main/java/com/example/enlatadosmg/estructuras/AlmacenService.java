package com.example.enlatadosmg.estructuras;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlmacenService {
    private PilaAlmacen pila = new PilaAlmacen();

    @Autowired
    private CajaRepository repo; // Para persistencia

    public void pushCaja() {
        Caja c = new Caja();
        repo.save(c); // Persiste
        pila.push(c); // Estructura LIFO
    }
}
