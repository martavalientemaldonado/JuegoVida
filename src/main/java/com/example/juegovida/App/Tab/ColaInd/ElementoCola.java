package com.example.juegovida.App.Tab.ColaInd;

public class ElementoCola<T> {
    T data;
    ElementoCola<T> anterior;
    ElementoCola<T> siguiente;
    public ElementoCola(T data){this.data = data;}
    public ElementoCola(T data, ElementoCola<T> anterior, ElementoCola<T> siguiente){
        this.data = data;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    public ElementoCola<T> getSiguiente() {
        return siguiente;
    }

    public void setAnterior(ElementoCola<T> anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(ElementoCola<T> siguiente) {
        this.siguiente = siguiente;
    }

    public ElementoCola<T> getAnterior() {
        return anterior;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
