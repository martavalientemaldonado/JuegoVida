package com.example.juegovida.App.Tab.GrafoCasillas;

public class ElementoLDE<T> {
    T data;
    ElementoLDE<T> anterior;
    ElementoLDE<T> siguiente;
    public ElementoLDE(T data){this.data = data;}
    public ElementoLDE(T data, ElementoLDE<T> anterior, ElementoLDE<T> siguiente){
        this.data = data;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    public ElementoLDE<T> getSiguiente() {
        return siguiente;
    }

    public void setAnterior(ElementoLDE<T> anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(ElementoLDE<T> siguiente) {
        this.siguiente = siguiente;
    }

    public ElementoLDE<T> getAnterior() {
        return anterior;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
