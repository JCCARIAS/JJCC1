package com.example.enlatadosmg.estructuras;



import com.example.enlatadosmg.model.Caja;

import java.util.Stack;

public class PilaAlmacen {
    private Stack<Caja> pila;

    public PilaAlmacen() {
        this.pila = new Stack<>();
    }

    public void push(Caja caja) {
        pila.push(caja);
    }

    public Caja pop() {
        return pila.pop();
    }

    public Caja peek() {
        return pila.peek();
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public int size() {
        return pila.size();
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cajas en almacén (LIFO):\n");
        for (int i = pila.size() - 1; i >= 0; i--) {
            Caja c = pila.get(i);
            sb.append("Caja #").append(c.getCorrelativo())
                    .append(" - Fecha: ").append(c.getFechaIngreso()).append("\n");
        }
        return sb.toString();
    }
}