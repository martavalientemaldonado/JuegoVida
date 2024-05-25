package com.example.juegovida.App.Tab.GrafoCasillas;


public class AristasGrafoCasillas<TipodeDato> {
    public NodoGrafoCasillas<TipodeDato> origen;
    public NodoGrafoCasillas<TipodeDato> destino;
    public Double peso;

    public AristasGrafoCasillas(NodoGrafoCasillas<TipodeDato> origen, NodoGrafoCasillas<TipodeDato> destino, Double peso){
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public NodoGrafoCasillas<TipodeDato> getOrigen() {
        return origen;
    }

    public void setOrigen(NodoGrafoCasillas<TipodeDato> origen) {
        this.origen = origen;
    }

    public NodoGrafoCasillas<TipodeDato> getDestino() {
        return destino;
    }

    public void setDestino(NodoGrafoCasillas<TipodeDato> destino) {
        this.destino = destino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
