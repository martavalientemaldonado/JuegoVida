package com.example.juegovida.App.Tab.Grafo;

import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Errores.ElRepetidoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoTest {

    @Test
    void grafoVacio() {
        try {
            Grafo<Individuo> g = new Grafo<>();
            Individuo r = new Individuo();
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.nuevoNodo(r);
            assertFalse(g.grafoVacio(), "No se ha obtenido el resultado esperado");
        }catch (ElRepetidoError ex){
            ex.printStackTrace();
        }
    }

    @Test
    void existeVertice() {
        try {
            Grafo<String> g = new Grafo<String>();
            Individuo r = new Individuo();
            Individuo r2 = new Individuo();
            Individuo r3 = new Individuo();
            Individuo r4 = new Individuo();
            g.nuevoNodo(r);
            g.nuevoNodo(r2);
            g.nuevoNodo(r3);
            assertFalse(g.existeVertice(r4));
            assertTrue(g.existeVertice(r2));
        }catch (ElRepetidoError ex){
            ex.printStackTrace();
        }
    }

    @Test
    void nuevaArista() {
        try{
            Grafo<String> g = new Grafo<String>();
            Individuo r = new Individuo();
            Individuo r2 = new Individuo();
            Individuo r3 = new Individuo();
            Individuo r4 = new Individuo();
            g.nuevoNodo(r);
            g.nuevoNodo(r2);
            g.nuevoNodo(r3);
            g.nuevoNodo(r4);
            NodoGrafo<Individuo> n1 = new NodoGrafo<>(r);
            NodoGrafo<Individuo> n2 = new NodoGrafo<>(r2);
            NodoGrafo<Individuo> n3 = new NodoGrafo<>(r3);
            g.NuevaArista(n1, n2);
            g.NuevaArista(n1,n3);
        }catch (ElRepetidoError ex){
            ex.printStackTrace();
        }
    }

    @Test
    void testNuevaArista() {
        try{
            Grafo<String> g = new Grafo<String>();
            Individuo r = new Individuo();
            Individuo r2 = new Individuo();
            Individuo r3 = new Individuo();
            Individuo r4 = new Individuo();
            g.nuevoNodo(r);
            g.nuevoNodo(r2);
            g.nuevoNodo(r3);
            g.nuevoNodo(r4);
            NodoGrafo<Individuo> n1 = new NodoGrafo<>(r);
            NodoGrafo<Individuo> n2 = new NodoGrafo<>(r2);
            NodoGrafo<Individuo> n3 = new NodoGrafo<>(r3);
            g.NuevaArista(n1, n2,3);
            g.NuevaArista(n1,n3,4);
        }catch (ElRepetidoError ex) {
            ex.printStackTrace();
        }
    }

    @Test
    void nuevoNodo() {
        try {
            Grafo<String> g = new Grafo<>();
            Individuo r = new Individuo();
            Individuo r2 = new Individuo();
            Individuo r3 = new Individuo();
            Individuo r4 = new Individuo();
            g.nuevoNodo(r);
            g.nuevoNodo(r2);
            g.nuevoNodo(r3);
            g.nuevoNodo(r4);
        }catch (ElRepetidoError ex){
            ex.printStackTrace();
        }
    }

    @Test
    void getDijkstra() {
        try {
            Grafo<String> g = new Grafo<String>();
            Individuo r = new Individuo();
            Individuo r2 = new Individuo();
            Individuo r3 = new Individuo();
            Individuo r4 = new Individuo();
            Individuo r5 = new Individuo();
            g.nuevoNodo(r);
            g.nuevoNodo(r2);
            g.nuevoNodo(r3);
            g.nuevoNodo(r4);
            g.nuevoNodo(r5);
            NodoGrafo<Individuo> n1 = new NodoGrafo<>(r);
            NodoGrafo<Individuo> n2 = new NodoGrafo<>(r2);
            NodoGrafo<Individuo> n3 = new NodoGrafo<>(r3);
            NodoGrafo<Individuo> n4 = new NodoGrafo<>(r4);
            NodoGrafo<Individuo> n5 = new NodoGrafo<>(r5);
            g.NuevaArista(n1, n2, 4);
            g.NuevaArista(n1, n3, 2);
            g.NuevaArista(n1, n4, 1);
            g.NuevaArista(n2, n5, -1);
            g.NuevaArista(n3, n4, 3);
            g.NuevaArista(n3, n5, 3);
            g.getDijkstra(g.primero);
        }catch (ElRepetidoError ex) {
            ex.printStackTrace();
        }
    }


}