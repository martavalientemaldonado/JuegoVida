package com.example.juegovida.App.Tab.Grafo;

public class ElementoHashMap<T,E> {
    T nodobuscamos;
    E camino;
    ElementoHashMap<T,E> siguiente;

    public ElementoHashMap() {
        this.nodobuscamos = null;
        this.camino = null;
        this.siguiente = null;
    }
    public ElementoHashMap(ElementoHashMap<T, E> siguiente, T ind, E dato) {
        this.siguiente = siguiente;
        this.camino = dato;
        this.nodobuscamos = ind;
    }

    public E getCamino() {
        return camino;
    }

    public void setCamino(E camino) {
        this.camino = camino;
    }

    public ElementoHashMap<T, E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoHashMap<T, E> siguiente) {
        this.siguiente = siguiente;
    }

    public T getNodobuscamos() {
        return nodobuscamos;
    }

    public void setNodobuscamos(T nodobuscamos) {
        this.nodobuscamos = nodobuscamos;
    }
}
