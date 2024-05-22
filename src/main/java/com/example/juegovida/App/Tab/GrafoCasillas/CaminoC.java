package com.example.juegovida.App.Tab.GrafoCasillas;

public class CaminoC<TipodeDato> {
    ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> camino;
    double peso;
    public CaminoC(ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> l, double peso){
        this.camino = l;
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> getCamino(){return camino;}
    public void EliminarPrimero(){
        camino.EliminarPrimero();
    }
}
