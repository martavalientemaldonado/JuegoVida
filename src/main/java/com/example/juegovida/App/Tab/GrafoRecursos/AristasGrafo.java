package com.example.juegovida.App.Tab.GrafoRecursos;

public class AristasGrafo<TipodelDato> {
    NodoGrafo<TipodelDato> destino;
    double peso;
    NodoGrafo<TipodelDato> inicio;
    AristasGrafo<TipodelDato> siguiente;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public NodoGrafo<TipodelDato> getDestino() {
        return destino;
    }

    public AristasGrafo<TipodelDato> getSiguiente() {
        return siguiente;
    }

    public NodoGrafo<TipodelDato> getInicio() {
        return inicio;
    }

    public AristasGrafo(NodoGrafo<TipodelDato> inicio, NodoGrafo<TipodelDato> destino){
        this.destino = destino;
        this.inicio = inicio;
        this.siguiente = null;
    }

    public AristasGrafo(NodoGrafo<TipodelDato> inicio,NodoGrafo<TipodelDato> destino, double p){
        this.destino = destino;
        this.peso = p;
        this.inicio = inicio;
        this.siguiente = null;
    }
    public AristasGrafo(NodoGrafo<TipodelDato> inicio,NodoGrafo<TipodelDato> destino, double p, AristasGrafo<TipodelDato> siguiente){
        this.destino = destino;
        this.peso = p;
        this.inicio = inicio;
        this.siguiente = siguiente;
    }
}
