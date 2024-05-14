package com.example.juegovida.App.Tab.ColaInd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoColaTest {

    @Test
    void getSiguiente() {
        ElementoCola<Integer> n = new ElementoCola<>(3);
        ElementoCola<Integer> n2 = new ElementoCola<>(4);
        ElementoCola<Integer> n3 = new ElementoCola<>(5);
        ElementoCola<Integer> n4 = new ElementoCola<>(6,n3, n2);
        assertEquals(n2, n4.getSiguiente());
    }
    @Test
    void setSiguiente() {
        ElementoCola<Integer> n = new ElementoCola<>(3);
        ElementoCola<Integer> n2 = new ElementoCola<>(4);
        ElementoCola<Integer> n3 = new ElementoCola<>(5);
        ElementoCola<Integer> n4 = new ElementoCola<>(6,n3, n2);
        assertEquals(n2, n4.getSiguiente());
        n4.setSiguiente(n);
        assertEquals(n, n4.getSiguiente());
    }

    @Test
    void getAnterior() {
        ElementoCola<Integer> n = new ElementoCola<>(3);
        ElementoCola<Integer> n2 = new ElementoCola<>(4);
        ElementoCola<Integer> n3 = new ElementoCola<>(5);
        ElementoCola<Integer> n4 = new ElementoCola<>(6,n3, n2);
        assertEquals(n3, n4.getAnterior());
    }
    @Test
    void setAnterior() {
        ElementoCola<Integer> n = new ElementoCola<>(3);
        ElementoCola<Integer> n2 = new ElementoCola<>(4);
        ElementoCola<Integer> n3 = new ElementoCola<>(5);
        ElementoCola<Integer> n4 = new ElementoCola<>(6,n3, n2);
        assertEquals(n3, n4.getAnterior());
        n4.setAnterior(n);
        assertEquals(n, n4.getAnterior());
    }
    @Test
    void getData() {
        ElementoCola<Integer> n = new ElementoCola<>(3);
        assertEquals(3, n.getData());
    }

    @Test
    void setData() {
        ElementoCola<Integer> n = new ElementoCola<>(3);
        assertEquals(3, n.getData());
        n.setData(5);
        assertEquals(5, n.getData());
    }
}