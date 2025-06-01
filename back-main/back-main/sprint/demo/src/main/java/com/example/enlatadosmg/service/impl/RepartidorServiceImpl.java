package com.example.enlatadosmg.service.impl;



import com.example.enlatadosmg.estructuras.ColaRepartidores;
import com.example.enlatadosmg.model.Repartidor;
import com.example.enlatadosmg.repository.RepartidorRepository;
import com.example.enlatadosmg.service.RepartidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RepartidorServiceImpl implements RepartidorService {

    @Autowired
    private RepartidorRepository repartidorRepository;

    private ColaRepartidores colaRepartidores;

    @PostConstruct
    public void init() {
        colaRepartidores = new ColaRepartidores();
        // Cargar repartidores disponibles en la cola
        repartidorRepository.findByDisponibleTrueOrderByCuiAsc()
                .forEach(colaRepartidores::encolar);
    }

    @Override
    public Repartidor createRepartidor(Repartidor repartidor) {
        repartidor.setDisponible(true);
        Repartidor saved = repartidorRepository.save(repartidor);
        colaRepartidores.encolar(saved);
        return saved;
    }

    @Override
    public Repartidor getNextRepartidor() {
        return colaRepartidores.desencolar();
    }

    @Override
    public void liberarRepartidor(Repartidor repartidor) {
        repartidor.setDisponible(true);
        repartidorRepository.save(repartidor);
        colaRepartidores.encolar(repartidor);
    }

    @Override
    public String generarReporteCola() {
        return colaRepartidores.generarReporte();
    }
}