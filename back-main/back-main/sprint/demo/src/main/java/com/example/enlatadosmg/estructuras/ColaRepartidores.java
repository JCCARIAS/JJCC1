package com.example.enlatadosmg.estructuras;


import com.example.enlatadosmg.model.Repartidor;

import java.util.LinkedList;
import java.util.Queue;

public class ColaRepartidores {
    private Queue<Repartidor> cola;

    public ColaRepartidores() {
        this.cola = new LinkedList<>();
    }

    public void encolar(Repartidor repartidor) {
        cola.add(repartidor);
    }

    public Repartidor desencolar() {
        return cola.poll();
    }

    public Repartidor peek() {
        return cola.peek();
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }

    public int size() {
        return cola.size();
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("Repartidores disponibles (FIFO):\n");
        int posicion = 1;
        for (Repartidor r : cola) {
            sb.append(posicion++).append(". ")
                    .append(r.getNombre()).append(" ")
                    .append(r.getApellidos()).append(" - ")
                    .append(r.getLicencia()).append("\n");
        }
        return sb.toString();
    }
}