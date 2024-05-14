package com.example.juegovida.App.Tab.GrafoRecursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AristasGrafoTest {

    @Test
    void getPeso() {
        NodoGrafo<String> nod1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nod2 = new NodoGrafo<String>("Adios");
        AristasGrafo<String> ars= new AristasGrafo<String>(nod1, nod2, 2);
        assertEquals(2,ars.getPeso(), "El peso esperado no es el obtenido");
    }

    @Test
    void setPeso() {
        NodoGrafo<String> nod1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nod2 = new NodoGrafo<String>("Adios");
        AristasGrafo<String> ars= new AristasGrafo<String>(nod1, nod2, 2);
        ars.setPeso(3);
        assertEquals(3,ars.getPeso(), "El peso no ha cambiado.");

    }

    @Test
    void getDestino() {
        NodoGrafo<String> nod1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nod2 = new NodoGrafo<String>("Adios");
        AristasGrafo<String> ars= new AristasGrafo<String>(nod1, nod2);
        assertEquals(nod2,ars.getDestino(), "El destino esperado no es el obtenido");
    }

    @Test
    void getSiguiente() {
        NodoGrafo<String> nod1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nod2 = new NodoGrafo<String>("Adios");
        AristasGrafo<String> ars= new AristasGrafo<String>(nod1, nod2, 2);
        AristasGrafo<String> ars2= new AristasGrafo<String>(nod1, nod2,3, ars);
        assertEquals(ars, ars2.getSiguiente(), "La siguiente arista esperada no es la obtenida");
    }

    @Test
    void getInicio() {
        NodoGrafo<String> nod1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nod2 = new NodoGrafo<String>("Adios");
        AristasGrafo<String> ars= new AristasGrafo<String>(nod1, nod2);
        assertEquals(nod1,ars.getInicio(), "El origen esperado no es el obtenido");
    }
}
