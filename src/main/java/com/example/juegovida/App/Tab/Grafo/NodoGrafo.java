package com.example.juegovida.App.Tab.Grafo;

public class NodoGrafo<TipodelDato>{
    TipodelDato dato;
    ListaAdyacencia<TipodelDato> lista;
    NodoGrafo<TipodelDato> siguiente;

    public NodoGrafo(TipodelDato x) {
        this.dato = x;
        this.lista = new ListaAdyacencia<TipodelDato>();
        this.siguiente = null;
    }
    public NodoGrafo(TipodelDato x, NodoGrafo<TipodelDato> siguiente) {
        this.dato = x;
        this.lista = new ListaAdyacencia<TipodelDato>();
        this.siguiente = siguiente;
    }

    public TipodelDato getDato() {
        return dato;
    }

    public ListaAdyacencia<TipodelDato> getLista() {
        return lista;
    }

    public NodoGrafo<TipodelDato> getSiguiente() {
        return siguiente;
    }

    public void setDato(TipodelDato dato) {
        this.dato = dato;
    }
    public void setSiguiente(NodoGrafo<TipodelDato> siguiente) {
        this.siguiente = siguiente;
    }
}
