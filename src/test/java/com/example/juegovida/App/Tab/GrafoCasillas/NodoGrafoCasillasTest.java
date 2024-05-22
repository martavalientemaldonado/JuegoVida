package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Grafo.NodoGrafo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoGrafoCasillasTest {

    @Test
    void getDato() {
        Casilla c = new Casilla(1,1);
        NodoGrafoCasillas<Casilla> nodo1 = new NodoGrafoCasillas<>(c);
        assertEquals(c, nodo1.getDato(), "El dato no es el esperado");
    }

    @Test
    void getEntrada() {
        Casilla c = new Casilla(1,1);
        ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> l = new ListaEnlazadaCasillas<>();
        ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> l2 = new ListaEnlazadaCasillas<>();
        NodoGrafoCasillas<Casilla> nodo1 = new NodoGrafoCasillas<>(c,l,l2);
        assertEquals(l, nodo1.getEntrada(), "El dato no es el esperado");
    }

    @Test
    void getSalida() {
        Casilla c = new Casilla(1,1);
        ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> l = new ListaEnlazadaCasillas<>();
        ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> l2 = new ListaEnlazadaCasillas<>();
        NodoGrafoCasillas<Casilla> nodo1 = new NodoGrafoCasillas<>(c,l,l2);
        assertEquals(l2, nodo1.getSalida(), "El dato no es el esperado");
    }
}