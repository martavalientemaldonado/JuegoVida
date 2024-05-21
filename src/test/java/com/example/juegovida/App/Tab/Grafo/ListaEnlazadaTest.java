package com.example.juegovida.App.Tab.Grafo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    @Test
    void isVacia() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        assertTrue(in.isVacia());
        in.add(e);
        assertFalse(in.isVacia());
    }

    @Test
    void vaciar() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        in.add(e);
        assertFalse(in.isVacia());
        in.Vaciar();
        assertTrue(in.isVacia());
    }

    @Test
    void add() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        assertTrue(in.isVacia());
        in.add(e);
        assertFalse(in.isVacia());
    }

    @Test
    void testAdd() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        assertTrue(in.isVacia());
        in.add(3);
        assertFalse(in.isVacia());
    }

    @Test
    void del() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        ElementoLE<Integer> e2 = new ElementoLE<>(4);
        ElementoLE<Integer> e3 = new ElementoLE<>(5);
        ElementoLE<Integer> e4 = new ElementoLE<>(6);
        in.add(e);
        in.add(e2);
        in.add(e3);
        in.add(e4);
        in.del(0);
        in.del(2);
    }

    @Test
    void getNumeroElementos() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        ElementoLE<Integer> e2 = new ElementoLE<>(4);
        ElementoLE<Integer> e3 = new ElementoLE<>(5);
        ElementoLE<Integer> e4 = new ElementoLE<>(6);
        in.add(e);
        in.add(e2);
        in.add(e3);
        in.add(e4);
        assertEquals(4, in.getNumeroElementos());
    }

    @Test
    void getPosicion() {
        ListaEnlazada<String> le= new ListaEnlazada<>();
        le.add("HOLA");
        le.add("8");
        le.add("2");
        ElementoLE<String> e3=new ElementoLE<>(null, "HOLA");
        ElementoLE<String> e2=new ElementoLE<>(e3, "8");
        ElementoLE<String> e1=new ElementoLE<>(e2, "2");
        assertEquals(2, le.getPosicion(e1));
        assertEquals(0, le.getPosicion(e3));
    }

    @Test
    void getPrimero() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        ElementoLE<Integer> e2 = new ElementoLE<>(4);
        ElementoLE<Integer> e3 = new ElementoLE<>(5);
        ElementoLE<Integer> e4 = new ElementoLE<>(6);
        in.add(e);
        in.add(e2);
        in.add(e3);
        in.add(e4);
        assertEquals(e4.getData(), in.getPrimero().getData());
    }

    @Test
    void getUltimo() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        ElementoLE<Integer> e2 = new ElementoLE<>(4);
        ElementoLE<Integer> e3 = new ElementoLE<>(5);
        ElementoLE<Integer> e4 = new ElementoLE<>(6);
        in.add(e);
        in.add(e2);
        in.add(e3);
        in.add(e4);
        assertEquals(e, in.getUltimo());
    }

    @Test
    void getElemento() {
        ListaEnlazada<Integer> le = new ListaEnlazada<>();
        le.add(3);
        le.add(4);
        le.add(6);
        assertEquals(3, le.getElemento(2).getData());
        assertEquals(4, le.getElemento(1).getData());
        assertEquals(6, le.getElemento(0).getData());
    }

    @Test
    void reverse() {
        ListaEnlazada<Integer> in = new ListaEnlazada<>();
        ElementoLE<Integer> e = new ElementoLE<>(3);
        ElementoLE<Integer> e2 = new ElementoLE<>(4);
        ElementoLE<Integer> e3 = new ElementoLE<>(5);
        ElementoLE<Integer> e4 = new ElementoLE<>(6);
        in.add(e);
        in.add(e2);
        in.add(e3);
        in.add(e4);
        in.reverse(in);
    }
}