package com.example.juegovida.App.Tab.GrafoRecursos;

public class Camino <TipodeDato>{
    ListaEnlazada<NodoGrafo<TipodeDato>> lista;
    double peso;
    public Camino(ListaEnlazada<NodoGrafo<TipodeDato>> l, double peso){
        this.lista = l;
        this.peso = peso;
    }

    public Camino() {
    }
}
