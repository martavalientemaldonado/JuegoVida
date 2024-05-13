package com.example.juegovida.App.Tab.GrafoRecursos;

public class ElementoHashMap<T,E> {
    T indice;
    E dato;
    ElementoHashMap<T,E> siguiente;

    public ElementoHashMap() {
        this.indice = null;
        this.dato = null;
        this.siguiente = null;
    }
    public ElementoHashMap(ElementoHashMap<T, E> siguiente, T ind, E dato) {
        this.siguiente = siguiente;
        this.dato = dato;
        this.indice = ind;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public ElementoHashMap<T, E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoHashMap<T, E> siguiente) {
        this.siguiente = siguiente;
    }

    public T getIndice() {
        return indice;
    }

    public void setIndice(T indice) {
        this.indice = indice;
    }
}
