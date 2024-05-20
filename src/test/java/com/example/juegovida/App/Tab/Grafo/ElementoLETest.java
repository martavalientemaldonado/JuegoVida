package com.example.juegovida.App.Tab.Grafo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLETest {

    @Test
    void getSiguiente() {
        ElementoLE<Integer> el2= new ElementoLE<>(4);
        ElementoLE<Integer> el= new ElementoLE<>(el2,3);
        assertEquals(el2, el.getSiguiente());
    }

    @Test
    void insertarmeEn() {
        ElementoLE<Integer> el2= new ElementoLE<>(4);
        ElementoLE<Integer> el3= new ElementoLE<>(5);
        ElementoLE<Integer> el= new ElementoLE<>(el2,3);
        el.insertarmeEn(el3);
        assertEquals(el3, el.getSiguiente());
    }

    @Test
    void getData() {
        ElementoLE<Integer> el2= new ElementoLE<>(4);
        ElementoLE<Integer> el3= new ElementoLE<>(5);
        ElementoLE<Integer> el= new ElementoLE<>(el2,3);
        assertEquals(3, el.getData());
    }

    @Test
    void setData() {
        ElementoLE<Integer> el= new ElementoLE<>(3);
        assertEquals(3, el.getData());
        el.setData(2);
        assertEquals(2, el.getData());
    }
    @Test
    void setSiguiente(){
        ElementoLE<Integer> el= new ElementoLE<>(3);
        ElementoLE<Integer> el3= new ElementoLE<>(4);
        ElementoLE<Integer> el2= new ElementoLE<>(el,3);
        assertEquals(el, el2.getSiguiente());
        el.setSiguiente(el3);
        assertEquals(el3, el2.getSiguiente());
    }
}