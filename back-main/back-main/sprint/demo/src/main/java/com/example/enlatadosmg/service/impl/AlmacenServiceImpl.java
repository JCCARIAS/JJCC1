package com.example.enlatadosmg.service.impl;




import com.enlatadosmg.model.Caja;
import com.enlatadosmg.repository.CajaRepository;
import com.enlatadosmg.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    private CajaRepository cajaRepository;

    @Override
    public Caja pushCaja() {
        Caja nuevaCaja = new Caja();
        nuevaCaja.setFechaIngreso(LocalDate.now());
        return cajaRepository.save(nuevaCaja);
    }

    @Override
    public Caja popCaja() {
        Caja caja = cajaRepository.findTopByOrderByFechaIngresoDesc();
        if (caja != null) {
            cajaRepository.delete(caja);
        }
        return caja;
    }

    @Override
    public int totalCajas() {
        return (int) cajaRepository.count();
    }
}