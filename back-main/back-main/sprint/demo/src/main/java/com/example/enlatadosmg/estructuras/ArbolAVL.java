package com.example.enlatadosmg.estructuras;



import com.example.enlatadosmg.model.Cliente;

public class ArbolAVL {
    private NodoAVL raiz;

    private class NodoAVL {
        Cliente cliente;
        NodoAVL izquierdo;
        NodoAVL derecho;
        int altura;

        NodoAVL(Cliente cliente) {
            this.cliente = cliente;
            this.altura = 1;
        }
    }

    // Método para obtener la altura de un nodo
    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    // Método para obtener el balance de un nodo
    private int getBalance(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Rotación simple a la derecha
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    // Rotación simple a la izquierda
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    // Insertar un cliente en el árbol
    public void insertar(Cliente cliente) {
        raiz = insertar(raiz, cliente);
    }

    private NodoAVL insertar(NodoAVL nodo, Cliente cliente) {
        if (nodo == null) {
            return new NodoAVL(cliente);
        }

        // Comparar por CUI
        if (cliente.getCui().compareTo(nodo.cliente.getCui()) < 0) {
            nodo.izquierdo = insertar(nodo.izquierdo, cliente);
        } else if (cliente.getCui().compareTo(nodo.cliente.getCui()) > 0) {
            nodo.derecho = insertar(nodo.derecho, cliente);
        } else {
            return nodo; // Claves duplicadas no permitidas
        }

        // Actualizar altura del nodo
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Obtener factor de balance
        int balance = getBalance(nodo);

        // Casos de desbalance
        // Izquierda Izquierda
        if (balance > 1 && cliente.getCui().compareTo(nodo.izquierdo.cliente.getCui()) < 0) {
            return rotacionDerecha(nodo);
        }

        // Derecha Derecha
        if (balance < -1 && cliente.getCui().compareTo(nodo.derecho.cliente.getCui()) > 0) {
            return rotacionIzquierda(nodo);
        }

        // Izquierda Derecha
        if (balance > 1 && cliente.getCui().compareTo(nodo.izquierdo.cliente.getCui()) > 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        // Derecha Izquierda
        if (balance < -1 && cliente.getCui().compareTo(nodo.derecho.cliente.getCui()) < 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Buscar un cliente por CUI
    public Cliente buscar(String cui) {
        NodoAVL nodo = buscar(raiz, cui);
        return nodo == null ? null : nodo.cliente;
    }

    private NodoAVL buscar(NodoAVL nodo, String cui) {
        if (nodo == null) {
            return null;
        }

        int comparacion = cui.compareTo(nodo.cliente.getCui());
        if (comparacion < 0) {
            return buscar(nodo.izquierdo, cui);
        } else if (comparacion > 0) {
            return buscar(nodo.derecho, cui);
        } else {
            return nodo;
        }
    }

    // Recorrido inorden (para reportes)
    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inorden(raiz, sb);
        return sb.toString();
    }

    private void inorden(NodoAVL nodo, StringBuilder sb) {
        if (nodo != null) {
            inorden(nodo.izquierdo, sb);
            sb.append(nodo.cliente.getCui()).append(" - ")
                    .append(nodo.cliente.getNombre()).append("\n");
            inorden(nodo.derecho, sb);
        }
    }
}
