package com.example.juegovida.App.Tab;

public class Casilla<TipodeDato> {
    TipodeDato dato;
    Casilla<TipodeDato> siguiente;

    public Casilla(Casilla<TipodeDato> siguiente, TipodeDato dato) {
        this.siguiente = siguiente;
        this.dato = dato;
    }

    public TipodeDato getDato() {
        return dato;
    }

    public void setDato(TipodeDato dato) {
        this.dato = dato;
    }

    public Casilla<TipodeDato> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Casilla<TipodeDato> siguiente) {
        this.siguiente = siguiente;
    }
}
