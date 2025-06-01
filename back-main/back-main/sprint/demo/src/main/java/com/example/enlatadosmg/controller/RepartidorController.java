package com.example.enlatadosmg.controller;




import com.example.enlatadosmg.service.AlmacenService;
import com.example.enlatadosmg.service.ClienteService;
import com.example.enlatadosmg.service.RepartidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private RepartidorService repartidorService;

    @GetMapping("/estructuras")
    public Map<String, String> generarReportesEstructuras() {
        Map<String, String> reportes = new HashMap<>();
        reportes.put("arbolClientes", clienteService.generarReporteArbol());
        reportes.put("pilaAlmacen", almacenService.generarReportePila());
        reportes.put("colaRepartidores", repartidorService.generarReporteCola());
        return reportes;
    }
}