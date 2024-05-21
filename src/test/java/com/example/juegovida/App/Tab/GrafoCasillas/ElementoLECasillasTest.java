package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Grafo.ElementoLE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLECasillasTest {

    @Test
    void setSiguiente() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        ElementoLECasillas<Casilla> el= new ElementoLECasillas<>(c);
        ElementoLECasillas<Casilla> el3= new ElementoLECasillas<>(c2);
        ElementoLECasillas<Casilla> el2= new ElementoLECasillas<>(el,c3);
        assertEquals(el, el2.getSiguiente());
        el2.setSiguiente(el3);
        assertEquals(el3, el2.getSiguiente());
    }

    @Test
    void getSiguiente() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        ElementoLECasillas<Casilla> el= new ElementoLECasillas<>(c);
        ElementoLECasillas<Casilla> el3= new ElementoLECasillas<>(c2);
        ElementoLECasillas<Casilla> el2= new ElementoLECasillas<>(el,c3);
        assertEquals(el, el2.getSiguiente());
    }

    @Test
    void insertarmeEn() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        ElementoLECasillas<Casilla> el= new ElementoLECasillas<>(c);
        ElementoLECasillas<Casilla> el3= new ElementoLECasillas<>(el,c2);
        ElementoLECasillas<Casilla> el2= new ElementoLECasillas<>(el3,c3);
        el.insertarmeEn(el2);
        assertEquals(el3, el.getSiguiente());
    }

    @Test
    void getData() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        ElementoLECasillas<Casilla> el= new ElementoLECasillas<>(c);
        ElementoLECasillas<Casilla> el2= new ElementoLECasillas<>(el,c3);
        assertEquals(c, el.getData());
    }

    @Test
    void setData() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(1,2);
        Casilla c3 = new Casilla(1,3);
        ElementoLECasillas<Casilla> el= new ElementoLECasillas<>(c);
        ElementoLECasillas<Casilla> el2= new ElementoLECasillas<>(el,c3);
        assertEquals(c, el.getData());
        el.setData(c3);
        assertEquals(c3, el.getData());
    }
}