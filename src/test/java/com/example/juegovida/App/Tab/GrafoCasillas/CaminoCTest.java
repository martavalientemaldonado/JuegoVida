package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Casilla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaminoCTest {

    @Test
    void getCamino() {
        Casilla c = new Casilla(1,1);
        NodoGrafoCasillas<Casilla> nodo1 = new NodoGrafoCasillas<>(c);
        ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> l = new ListaEnlazadaCasillas<>();
        l.add(nodo1);
        CaminoC<Casilla> caminoC = new CaminoC<>(l,1);
        assertEquals(l,caminoC.getCamino());
    }
    @Test
    void getPeso() {
        Casilla c = new Casilla(1,1);
        NodoGrafoCasillas<Casilla> nodo1 = new NodoGrafoCasillas<>(c);
        ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> l = new ListaEnlazadaCasillas<>();
        l.add(nodo1);
        CaminoC<Casilla> caminoC = new CaminoC<>(l,1);
        assertEquals(1,caminoC.getPeso());
    }

    @Test
    void eliminarPrimero() {
        Casilla c = new Casilla(1,1);
        NodoGrafoCasillas<Casilla> nodo1 = new NodoGrafoCasillas<>(c);
        Casilla c2 = new Casilla(1,2);
        NodoGrafoCasillas<Casilla> nodo2 = new NodoGrafoCasillas<>(c2);
        ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> l = new ListaEnlazadaCasillas<>();
        l.add(nodo1);
        l.add(nodo2);
        CaminoC<Casilla> caminoC = new CaminoC<>(l,1);
        assertEquals(nodo1,caminoC.getCamino().getPrimero().getData());
        caminoC.EliminarPrimero();
        assertEquals(nodo2,caminoC.getCamino().getPrimero().getData());
    }
}