package com.example.juegovida.App.Tab.GrafoCasillas;


public class ElementoHashMapC<T,E> {
    T nodobuscamos;
    E camino;
    ElementoHashMapC<T,E> siguiente;

    public ElementoHashMapC() {
        this.nodobuscamos = null;
        this.camino = null;
        this.siguiente = null;
    }
    public ElementoHashMapC(ElementoHashMapC<T, E> siguiente, T ind, E dato) {
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

    public ElementoHashMapC<T, E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoHashMapC<T, E> siguiente) {
        this.siguiente = siguiente;
    }

    public T getNodobuscamos() {
        return nodobuscamos;
    }

    public void setNodobuscamos(T nodobuscamos) {
        this.nodobuscamos = nodobuscamos;
    }
}
