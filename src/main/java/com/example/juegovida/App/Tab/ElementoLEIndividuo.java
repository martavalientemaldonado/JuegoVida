package com.example.juegovida.App.Tab;

import com.example.juegovida.Clases.Individuo;
public class ElementoLEIndividuo {
    protected ElementoLEIndividuo siguiente;
    private Individuo data;
    public ElementoLEIndividuo(Individuo data){
        this.data=data;
    }
    public ElementoLEIndividuo(ElementoLEIndividuo siguiente, Individuo data) {
        this.siguiente = siguiente;
        this.data = data;
    }

    protected ElementoLEIndividuo getSiguiente() {
        return siguiente;
    }

    protected void insertarmeEn(ElementoLEIndividuo el) {
        el.siguiente = this.siguiente;
        this.siguiente = el;
    }

    public Individuo getData() {
        return data;
    }

    public void setData(Individuo data) {
        this.data = data;
    }
}
