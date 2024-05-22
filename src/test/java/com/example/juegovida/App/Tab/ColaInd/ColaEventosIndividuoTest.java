package com.example.juegovida.App.Tab.ColaInd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaEventosIndividuoTest {

    @Test
    void esVacia() {
        ColaEventosIndividuo<Integer> c = new ColaEventosIndividuo<>();
        assertTrue(c.esVacia());
        ElementoCola<Integer> el = new ElementoCola<>(3);
        c.push(el);
        assertFalse(c.esVacia());
    }

    @Test
    void encolar() {
        ColaEventosIndividuo<Integer> c = new ColaEventosIndividuo<>();
        assertTrue(c.esVacia());
        ElementoCola<Integer> el = new ElementoCola<>(3);
        ElementoCola<Integer> el2 = new ElementoCola<>(4);
        c.push(el);
        c.push(el2);
        assertFalse(c.esVacia());
    }

    @Test
    void desencolar() {
        ColaEventosIndividuo<Integer> c = new ColaEventosIndividuo<>();
        assertNull(c.pop());
        ElementoCola<Integer> el = new ElementoCola<>(3);
        ElementoCola<Integer> el2 = new ElementoCola<>(4);
        c.push(el);
        c.push(el2);
        assertFalse(c.esVacia());
        c.pop();
        c.pop();
        assertTrue(c.esVacia());
    }

    @Test
    void getCabeza() {
        ColaEventosIndividuo<Integer> c = new ColaEventosIndividuo<>();
        ElementoCola<Integer> el = new ElementoCola<>(3);
        ElementoCola<Integer> el2 = new ElementoCola<>(4);
        c.push(el);
        c.push(el2);
        assertEquals(el, c.getCabeza());
    }

    @Test
    void getCola() {
        ColaEventosIndividuo<Integer> c = new ColaEventosIndividuo<>();
        ElementoCola<Integer> el = new ElementoCola<>(3);
        ElementoCola<Integer> el2 = new ElementoCola<>(4);
        c.push(el);
        c.push(el2);
        assertEquals(el2, c.getCola());
    }

    @Test
    void getElemento() {
        ColaEventosIndividuo<Integer> c = new ColaEventosIndividuo<>();
        ElementoCola<Integer> el = new ElementoCola<>(3);
        ElementoCola<Integer> el2 = new ElementoCola<>(4);
        ElementoCola<Integer> el3 = new ElementoCola<>(5);
        ElementoCola<Integer> el4 = new ElementoCola<>(6);
        c.push(el);
        c.push(el2);
        c.push(el3);
        c.push(el4);
        assertEquals(el, c.getElemento(0));
        assertEquals(el2, c.getElemento(1));
        assertEquals(el3, c.getElemento(2));
        assertEquals(el4, c.getElemento(3));
    }
}