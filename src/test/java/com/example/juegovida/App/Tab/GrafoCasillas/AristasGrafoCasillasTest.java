package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Grafo.AristasGrafo;
import com.example.juegovida.App.Tab.Grafo.NodoGrafo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AristasGrafoCasillasTest {

    @Test
    void getOrigen() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(2,2);
        NodoGrafoCasillas<Casilla> nod1 = new NodoGrafoCasillas<Casilla>(c);
        NodoGrafoCasillas<Casilla> nod2 = new NodoGrafoCasillas<Casilla>(c2);
        AristasGrafoCasillas<Casilla> ars= new AristasGrafoCasillas<Casilla>(nod1, nod2,1.0);
        assertEquals(nod1,ars.getOrigen(), "El origen esperado no es el obtenido");
    }

    @Test
    void setOrigen() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(2,2);
        NodoGrafoCasillas<Casilla> nod1 = new NodoGrafoCasillas<Casilla>(c);
        NodoGrafoCasillas<Casilla> nod2 = new NodoGrafoCasillas<Casilla>(c2);
        AristasGrafoCasillas<Casilla> ars= new AristasGrafoCasillas<Casilla>(nod1, nod2,1.0);
        assertEquals(nod1,ars.getOrigen(), "El origen esperado no es el obtenido");
        NodoGrafoCasillas<Casilla> nod3 = new NodoGrafoCasillas<Casilla>(c2);
        ars.setOrigen(nod3);
        assertEquals(nod3,ars.getOrigen(), "El origen esperado no es el obtenido");
    }

    @Test
    void getDestino() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(2,2);
        NodoGrafoCasillas<Casilla> nod1 = new NodoGrafoCasillas<Casilla>(c);
        NodoGrafoCasillas<Casilla> nod2 = new NodoGrafoCasillas<Casilla>(c2);
        AristasGrafoCasillas<Casilla> ars= new AristasGrafoCasillas<Casilla>(nod1, nod2,1.0);
        assertEquals(nod2,ars.getDestino(), "El origen esperado no es el obtenido");
    }

    @Test
    void setDestino() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(2,2);
        NodoGrafoCasillas<Casilla> nod1 = new NodoGrafoCasillas<Casilla>(c);
        NodoGrafoCasillas<Casilla> nod2 = new NodoGrafoCasillas<Casilla>(c2);
        AristasGrafoCasillas<Casilla> ars= new AristasGrafoCasillas<Casilla>(nod1, nod2,1.0);
        assertEquals(nod2,ars.getDestino(), "El origen esperado no es el obtenido");
        NodoGrafoCasillas<Casilla> nod3 = new NodoGrafoCasillas<Casilla>(c2);
        ars.setDestino(nod3);
        assertEquals(nod3,ars.getDestino(), "El origen esperado no es el obtenido");
    }

    @Test
    void getPeso() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(2,2);
        NodoGrafoCasillas<Casilla> nod1 = new NodoGrafoCasillas<Casilla>(c);
        NodoGrafoCasillas<Casilla> nod2 = new NodoGrafoCasillas<Casilla>(c2);
        AristasGrafoCasillas<Casilla> ars= new AristasGrafoCasillas<Casilla>(nod1, nod2,1.0);
        assertEquals(1.0,ars.getPeso(), "El origen esperado no es el obtenido");
    }

    @Test
    void setPeso() {
        Casilla c = new Casilla(1,1);
        Casilla c2 = new Casilla(2,2);
        NodoGrafoCasillas<Casilla> nod1 = new NodoGrafoCasillas<Casilla>(c);
        NodoGrafoCasillas<Casilla> nod2 = new NodoGrafoCasillas<Casilla>(c2);
        AristasGrafoCasillas<Casilla> ars= new AristasGrafoCasillas<Casilla>(nod1, nod2,1.0);
        assertEquals(1.0,ars.getPeso(), "El origen esperado no es el obtenido");
        NodoGrafoCasillas<Casilla> nod3 = new NodoGrafoCasillas<Casilla>(c2);
        ars.setPeso(3.0);
        assertEquals(3.0,ars.getPeso(), "El origen esperado no es el obtenido");
    }
}