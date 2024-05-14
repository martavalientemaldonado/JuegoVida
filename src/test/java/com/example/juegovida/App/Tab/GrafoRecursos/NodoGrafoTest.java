package com.example.juegovida.App.Tab.GrafoRecursos;

import com.example.juegovida.Errores.ElRepetidoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoGrafoTest {

    @Test
    void getDato() {
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        assertEquals("Hola", nodo1.getDato(), "El dato no es el esperado");
    }

    @Test
    void getLista() throws ElRepetidoError {
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("que");
        NodoGrafo<String> nodo3 = new NodoGrafo<String>("tal");
        if (!nodo1.lista.adyacente(nodo2) && !nodo1.lista.adyacente(nodo3)) {
            nodo1.lista.nuevaAdyacencia(nodo1, nodo2);
            nodo1.lista.nuevaAdyacencia(nodo1, nodo3);
            assertEquals(nodo1.lista, nodo1.getLista(), "El dato no es el esperado");
        }else{
            throw new ElRepetidoError("Ya existe la arista");
        }
    }

    @Test
    void getSiguiente() {
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("que", nodo1);
        assertEquals(nodo1, nodo2.getSiguiente(), "El siguiente nodo no es el esperado.");
    }

    @Test
    void setDato() {
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        nodo1.setDato("va bien");
        assertEquals("va bien", nodo1.getDato(),"El dato no a cambiado.");
    }

    @Test
    void setSiguiente(){
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("que", nodo1);
        NodoGrafo<String> nodo3 = new NodoGrafo<String>("que");
        nodo2.setSiguiente(nodo3);
        assertEquals(nodo3, nodo2.getSiguiente(), "El siguiente nodo no es el esperado.");

    }
}