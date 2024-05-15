package com.example.juegovida.App.Tab.GrafoRecursos;

import com.example.juegovida.Errores.ElRepetidoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaAdyacenciaTest {

    @Test
    void listaVacia() throws ElRepetidoError {
        ListaAdyacencia<String> l = new ListaAdyacencia<String>();
        assertTrue(l.listaVacia(), "No se ha obtenido el dato esperado.");
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("Adios");
        if (!l.adyacente(nodo2)){
            l.nuevaAdyacencia(nodo1, nodo2,2);
            assertFalse(l.listaVacia(), "No se ha obtenido el dato esperado.");
        }else throw new ElRepetidoError("Ya existe esa arista.");
    }

    @Test
    void nuevaAdyacencia() throws ElRepetidoError {
        ListaAdyacencia<String> l1 = new ListaAdyacencia<String>();
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo3 = new NodoGrafo<String>("la");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("Adios");
        NodoGrafo<String> nodo4 = new NodoGrafo<String>("lala");
        if (!l1.adyacente(nodo2) && !l1.adyacente(nodo4)){
            l1.nuevaAdyacencia(nodo1, nodo2, 4);
            l1.nuevaAdyacencia(nodo2, nodo4, 7);
        }else throw new ElRepetidoError("Ya existe esa arista.");
    }

    @Test
    void testNuevaAdyacencia() throws ElRepetidoError{
        ListaAdyacencia<String> l = new ListaAdyacencia<String>();
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("Adios");
        if (!l.adyacente(nodo2)){
            l.nuevaAdyacencia(nodo1, nodo2, 4);
            assertFalse(l.listaVacia(), "No se ha obtenido el dato esperado.");
        }else throw new ElRepetidoError("Ya existe esa arista.");
    }

    @Test
    void adyacente() throws ElRepetidoError{
        ListaAdyacencia<String> l1 = new ListaAdyacencia<String>();
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo3 = new NodoGrafo<String>("la");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("Adios");
        NodoGrafo<String> nodo4 = new NodoGrafo<String>("lala");
        if (!l1.adyacente(nodo2) && !l1.adyacente(nodo4)){
            l1.nuevaAdyacencia(nodo1, nodo2, 4);
            l1.nuevaAdyacencia(nodo2, nodo4, 7);
            assertFalse(l1.adyacente(nodo3), "No se ha obtenido el dato esperado.");
            assertTrue(l1.adyacente(nodo2), "No se ha obtenido el dato esperado.");
        }else throw new ElRepetidoError("Ya existe esa arista.");
    }

    @Test
    void borrararista() throws ElRepetidoError{
        ListaAdyacencia<String> l1 = new ListaAdyacencia<String>();
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("Adios");
        NodoGrafo<String> nodo3 = new NodoGrafo<String>("la");
        NodoGrafo<String> nodo4 = new NodoGrafo<String>("lala");
        if (!l1.adyacente(nodo2) && !l1.adyacente(nodo4)){
            l1.nuevaAdyacencia(nodo1, nodo2, 2);
            l1.nuevaAdyacencia(nodo1, nodo3, 3);
            l1.nuevaAdyacencia(nodo1, nodo4, 4);
            AristasGrafo<String> a = new AristasGrafo<String>(nodo1,nodo2,2);
            AristasGrafo<String> a2 = new AristasGrafo<String>(nodo1,nodo3,3);
            AristasGrafo<String> a3 = new AristasGrafo<String>(nodo1,nodo4,4);
            l1.borrararista(a);
            assertNotEquals(l1.primero.siguiente, a);
            l1.borrararista(a3);
            assertNotEquals(l1.ultimo, a3);
            l1.borrararista(a2);
            assertNotEquals(l1.primero, a2);
        }else throw new ElRepetidoError("Ya existe esa arista.");
    }

    @Test
    void borrarprimero() throws ElRepetidoError {
        ListaAdyacencia<String> l1 = new ListaAdyacencia<String>();
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("Hola");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("Adios");
        NodoGrafo<String> nodo4 = new NodoGrafo<String>("lala");
        if (!l1.adyacente(nodo2) && !l1.adyacente(nodo4)){
            l1.nuevaAdyacencia(nodo1, nodo2, 4);
            assertFalse(l1.listaVacia(), "No se ha obtenido el dato esperado.");
            l1.borrarprimero();
            assertTrue(l1.listaVacia(), "No se ha obtenido el dato esperado.");
        }else throw new ElRepetidoError("Ya existe esa arista.");
    }



}