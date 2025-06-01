package com.example.enlatadosmg.service;



import com.example.enlatadosmg.model.Caja;

public interface AlmacenService {
    Caja pushCaja();
    Caja popCaja();
    int totalCajas();
}
