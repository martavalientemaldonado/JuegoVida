package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Grafo.ElementoLE;
import com.example.juegovida.App.Tab.Grafo.ListaEnlazada;
import com.example.juegovida.App.Tab.ListaEnlazadaTablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaCasillasTest {

    @Test
    void isVacia() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        assertTrue(in.isVacia());
        in.add(e);
        assertFalse(in.isVacia());
    }

    @Test
    void vaciar() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        in.add(e);
        in.add(e2);
        in.add(e3);
        assertFalse(in.isVacia());
        in.Vaciar();
        assertTrue(in.isVacia());
    }

    @Test
    void add() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        assertTrue(in.isVacia());
        in.add(e);
        in.add(e2);
        in.add(e3);
        assertFalse(in.isVacia());
    }

    @Test
    void testAdd() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        assertTrue(in.isVacia());
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        in.add(c);
        in.add(c2);
        in.add(c3);
        assertFalse(in.isVacia());
    }

    @Test
    void del() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        in.add(c);
        in.add(c2);
        in.add(c3);
        in.del(1);
        in.del(2);
        in.del(1);
    }

    @Test
    void getNumeroElementos() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        assertTrue(in.isVacia());
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        in.add(c);
        in.add(c2);
        in.add(c3);
        assertEquals(3, in.getNumeroElementos());
    }

    @Test
    void getPosicion() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        assertTrue(in.isVacia());
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        in.add(c);
        in.add(c2);
        in.add(c3);
        assertEquals(2, in.getPosicion(c3));
        assertEquals(1, in.getPosicion(c2));
        assertEquals(0, in.getPosicion(c));
    }

    @Test
    void getPrimero() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        in.add(e);
        in.add(e2);
        in.add(e3);
        assertEquals(e, in.getPrimero());
    }

    @Test
    void getUltimo() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        in.add(e);
        in.add(e2);
        in.add(e3);
        assertEquals(e3, in.getUltimo());
    }

    @Test
    void getElemento() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        in.add(e);
        in.add(e2);
        in.add(e3);
        assertEquals(e2, in.getElemento(1));
        assertEquals(e, in.getElemento(0));
        assertEquals(e3, in.getElemento(2));
    }

    @Test
    void reverse() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        in.add(e);
        in.add(e2);
        in.add(e3);
        in.reverse(in);
    }

    @Test
    void eliminarPrimero() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        in.add(e);
        in.add(e2);
        in.add(e3);
        assertEquals(e, in.getPrimero());
        in.EliminarPrimero();
        assertEquals(e2, in.getPrimero());
    }

    @Test
    void insert() {
        ListaEnlazadaCasillas<Casilla> in = new ListaEnlazadaCasillas<>();
        ElementoLECasillas<Casilla> e = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e2 = new ElementoLECasillas<>();
        ElementoLECasillas<Casilla> e3 = new ElementoLECasillas<>();
        in.add(e);
        in.add(e2);
        in.add(e3);
        assertEquals(e, in.getPrimero());
        Casilla c = new Casilla(1,1);
        in.insert(c,0);
        assertEquals(in.getElemento(0), in.getPrimero());
    }
}