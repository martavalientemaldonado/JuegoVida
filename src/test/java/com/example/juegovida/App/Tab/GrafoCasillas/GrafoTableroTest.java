package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Grafo.Camino;
import com.example.juegovida.App.Tab.Grafo.Grafo;
import com.example.juegovida.App.Tab.Grafo.HashMap;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Errores.ElRepetidoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoTableroTest {
    @Test
    void grafoVacio() {
        try {
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> lv = new ListaEnlazadaCasillas<>();
            ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> la = new ListaEnlazadaCasillas<>();
            GrafoTablero<Casilla> g = new GrafoTablero<>(lv,la);
            Casilla rc = new Casilla(1,1);
            NodoGrafoCasillas<Casilla> r = new NodoGrafoCasillas<>(rc);
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.addNodo(r);
            assertFalse(g.grafoVacio(), "No se ha obtenido el resultado esperado");
        }catch (ElRepetidoError ex){
            ex.printStackTrace();
        }
    }

    @Test
    void addNodo(){
        try {
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> lv = new ListaEnlazadaCasillas<>();
            ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> la = new ListaEnlazadaCasillas<>();
            GrafoTablero<Casilla> g = new GrafoTablero<>(lv, la);
            Casilla rc = new Casilla(1, 1);
            Casilla rc2 = new Casilla(1, 1);
            NodoGrafoCasillas<Casilla> r = new NodoGrafoCasillas<>(rc);
            NodoGrafoCasillas<Casilla> r2 = new NodoGrafoCasillas<>(rc2);
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.addNodo(r);
            g.addNodo(r2);
        }catch (ElRepetidoError ex){ex.printStackTrace();}
    }

    @Test
    void addAristas() throws ElRepetidoError{
        try {
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> lv = new ListaEnlazadaCasillas<>();
            ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> la = new ListaEnlazadaCasillas<>();
            GrafoTablero<Casilla> g = new GrafoTablero<>(lv, la);
            Casilla rc = new Casilla(1, 1);
            Casilla rc2 = new Casilla(1, 1);
            NodoGrafoCasillas<Casilla> r = new NodoGrafoCasillas<>(rc);
            NodoGrafoCasillas<Casilla> r2 = new NodoGrafoCasillas<>(rc2);
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.addNodo(r);
            g.addNodo(r2);
            AristasGrafoCasillas<Casilla> a = new AristasGrafoCasillas<Casilla>(r,r2, 3.0);
            g.addAristas(a);
        }catch (ElRepetidoError ex){ex.printStackTrace();}
    }

    @Test
    void borrarArista() {
        try {
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> lv = new ListaEnlazadaCasillas<>();
            ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> la = new ListaEnlazadaCasillas<>();
            GrafoTablero<Casilla> g = new GrafoTablero<>(lv, la);
            Casilla rc = new Casilla(1, 1);
            Casilla rc2 = new Casilla(1, 1);
            NodoGrafoCasillas<Casilla> r = new NodoGrafoCasillas<>(rc);
            NodoGrafoCasillas<Casilla> r2 = new NodoGrafoCasillas<>(rc2);
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.addNodo(r);
            g.addNodo(r2);
            AristasGrafoCasillas<Casilla> a = new AristasGrafoCasillas<Casilla>(r,r2, 3.0);
            AristasGrafoCasillas<Casilla> a2 = new AristasGrafoCasillas<Casilla>(r,r2, 3.0);
            g.addAristas(a);
            g.addAristas(a2);
            g.borrarArista(a);
        }catch (ElRepetidoError ex){ex.printStackTrace();}
    }

    @Test
    void borrarNodo() {
        try {
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> lv = new ListaEnlazadaCasillas<>();
            ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> la = new ListaEnlazadaCasillas<>();
            GrafoTablero<Casilla> g = new GrafoTablero<>(lv, la);
            Casilla rc = new Casilla(1, 1);
            Casilla rc2 = new Casilla(1, 1);
            NodoGrafoCasillas<Casilla> r = new NodoGrafoCasillas<>(rc);
            NodoGrafoCasillas<Casilla> r2 = new NodoGrafoCasillas<>(rc2);
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.addNodo(r);
            g.addNodo(r2);
            AristasGrafoCasillas<Casilla> a = new AristasGrafoCasillas<Casilla>(r,r2, 3.0);
            AristasGrafoCasillas<Casilla> a2 = new AristasGrafoCasillas<Casilla>(r,r2, 3.0);
            g.addAristas(a);
            g.addAristas(a2);
            g.borrarNodo(r);
        }catch (ElRepetidoError ex){ex.printStackTrace();}
    }

    @Test
    void getDijkstra() {

    }

    @Test
    void dijkstra_init() {
        try {
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> lv = new ListaEnlazadaCasillas<>();
            ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> la = new ListaEnlazadaCasillas<>();
            GrafoTablero<Casilla> g = new GrafoTablero<>(lv, la);
            Casilla rc = new Casilla(1, 1);
            Casilla rc2 = new Casilla(1, 2);
            NodoGrafoCasillas<Casilla> r = new NodoGrafoCasillas<>(rc);
            NodoGrafoCasillas<Casilla> r2 = new NodoGrafoCasillas<>(rc2);
            Casilla rc3 = new Casilla(1, 3);
            Casilla rc4 = new Casilla(1, 4);
            NodoGrafoCasillas<Casilla> r3 = new NodoGrafoCasillas<>(rc3);
            NodoGrafoCasillas<Casilla> r4 = new NodoGrafoCasillas<>(rc4);
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.addNodo(r);
            g.addNodo(r2);
            g.addNodo(r3);
            g.addNodo(r4);
            AristasGrafoCasillas<Casilla> a = new AristasGrafoCasillas<>(r,r2, 3.0);
            AristasGrafoCasillas<Casilla> a2 = new AristasGrafoCasillas<>(r,r3, 1.0);
            AristasGrafoCasillas<Casilla> a3 = new AristasGrafoCasillas<>(r2,r3, -1.0);
            AristasGrafoCasillas<Casilla> a4 = new AristasGrafoCasillas<>(r3,r4, 1.0);
            AristasGrafoCasillas<Casilla> a5 = new AristasGrafoCasillas<>(r3,r2, 2.0);
            AristasGrafoCasillas<Casilla> a6 = new AristasGrafoCasillas<>(r2,r4, -2.0);
            g.addAristas(a);
            g.addAristas(a2);
            g.addAristas(a3);
            g.addAristas(a4);
            g.addAristas(a5);
            g.addAristas(a6);
            HashMapC<NodoGrafoCasillas<Casilla>, CaminoC<Casilla>> Di = g.getDijkstra(r);
        }catch (ElRepetidoError ex){ex.printStackTrace();}
    }

    @Test
    void getCaminoVertices() {
        try {
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> lv = new ListaEnlazadaCasillas<>();
            ListaEnlazadaCasillas<AristasGrafoCasillas<Casilla>> la = new ListaEnlazadaCasillas<>();
            GrafoTablero<Casilla> g = new GrafoTablero<>(lv, la);
            Casilla rc = new Casilla(1, 1);
            Casilla rc2 = new Casilla(1, 2);
            NodoGrafoCasillas<Casilla> r = new NodoGrafoCasillas<>(rc);
            NodoGrafoCasillas<Casilla> r2 = new NodoGrafoCasillas<>(rc2);
            Casilla rc3 = new Casilla(1, 3);
            Casilla rc4 = new Casilla(1, 4);
            NodoGrafoCasillas<Casilla> r3 = new NodoGrafoCasillas<>(rc3);
            NodoGrafoCasillas<Casilla> r4 = new NodoGrafoCasillas<>(rc4);
            assertTrue(g.grafoVacio(), "No se ha obtenido el resultado esperado");
            g.addNodo(r);
            g.addNodo(r2);
            g.addNodo(r3);
            g.addNodo(r4);
            AristasGrafoCasillas<Casilla> a = new AristasGrafoCasillas<>(r,r2, 3.0);
            AristasGrafoCasillas<Casilla> a2 = new AristasGrafoCasillas<>(r,r3, 1.0);
            AristasGrafoCasillas<Casilla> a3 = new AristasGrafoCasillas<>(r2,r3, -1.0);
            AristasGrafoCasillas<Casilla> a4 = new AristasGrafoCasillas<>(r3,r4, 1.0);
            AristasGrafoCasillas<Casilla> a5 = new AristasGrafoCasillas<>(r3,r2, 2.0);
            AristasGrafoCasillas<Casilla> a6 = new AristasGrafoCasillas<>(r2,r4, -2.0);
            g.addAristas(a);
            g.addAristas(a2);
            g.addAristas(a3);
            g.addAristas(a4);
            g.addAristas(a5);
            g.addAristas(a6);
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> Di = g.getCaminoVertices(r,r4);
            NodoGrafoCasillas<Casilla> n = new NodoGrafoCasillas<>(rc);
        }catch (ElRepetidoError ex){ex.printStackTrace();}
    }

    @Test
    void getCamino() {
    }
}