package com.example.juegovida.App.Tab.Grafo;

public class Camino <TipodeDato>{
    ListaEnlazada<NodoGrafo<TipodeDato>> lista;
    double peso;
    public Camino(ListaEnlazada<NodoGrafo<TipodeDato>> l, double peso){
        this.lista = l;
        this.peso = peso;
    }

    public Camino() {
    }
    public void EliminarPrimero(){
        lista.EliminarPrimero();
    }
}
