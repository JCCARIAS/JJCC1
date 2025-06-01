package com.example.enlatadosmg.service.impl;





import com.example.enlatadosmg.estructuras.PilaAlmacen;
import com.example.enlatadosmg.model.Caja;
import com.example.enlatadosmg.repository.CajaRepository;
import com.example.enlatadosmg.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    private CajaRepository cajaRepository;

    private PilaAlmacen pilaAlmacen;

    @PostConstruct
    public void init() {
        pilaAlmacen = new PilaAlmacen();
        // Cargar cajas existentes en la pila (ordenadas por fecha descendente)
        cajaRepository.findAllByOrderByFechaIngresoDesc()
                .forEach(pilaAlmacen::push);
    }

    @Override
    public Caja pushCaja() {
        Caja nuevaCaja = new Caja();
        nuevaCaja.setFechaIngreso(LocalDate.now());
        Caja saved = cajaRepository.save(nuevaCaja);
        pilaAlmacen.push(saved);
        return saved;
    }

    @Override
    public Caja popCaja() {
        Caja caja = pilaAlmacen.pop();
        if (caja != null) {
            cajaRepository.delete(caja);
        }
        return caja;
    }

    @Override
    public int totalCajas() {
        return pilaAlmacen.size();
    }

    @Override
    public String generarReportePila() {
        return pilaAlmacen.generarReporte();
    }
}