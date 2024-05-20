package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Grafo.ListaEnlazada;
import com.example.juegovida.App.Tab.ListaSimple;

public class NodoGrafoCasillas<Tipo> {
    Tipo dato;
    ListaEnlazadaCasillas<AristasGrafoCasillas<Tipo>> entrada;
    ListaEnlazadaCasillas<AristasGrafoCasillas<Tipo>> salida;
    public NodoGrafoCasillas(Tipo dato){
        this.dato = dato;
        this.entrada = new ListaEnlazadaCasillas<>();
        this.salida = new ListaEnlazadaCasillas<>();
    }
    public Tipo getDato(){
        return dato;
    }

    public ListaEnlazadaCasillas<AristasGrafoCasillas<Tipo>> getEntrada() {
        return entrada;
    }

    public ListaEnlazadaCasillas<AristasGrafoCasillas<Tipo>> getSalida() {
        return salida;
    }
}
