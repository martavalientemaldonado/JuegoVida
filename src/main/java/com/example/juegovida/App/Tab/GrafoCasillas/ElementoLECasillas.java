package com.example.juegovida.App.Tab.GrafoCasillas;

public class ElementoLECasillas<TipoDelDato> {
    protected ElementoLECasillas<TipoDelDato> siguiente;
    private TipoDelDato data;
    public ElementoLECasillas(){

    }
    public ElementoLECasillas(ElementoLECasillas<TipoDelDato> siguiente, TipoDelDato data) {
        this.siguiente = siguiente;
        this.data = data;
    }

    public ElementoLECasillas(TipoDelDato data) {
        this.data = data;
    }

    public void setSiguiente(ElementoLECasillas<TipoDelDato> siguiente) {
        this.siguiente = siguiente;
    }


    public ElementoLECasillas<TipoDelDato> getSiguiente() {
        return siguiente;
    }

    public void insertarmeEn(ElementoLECasillas<TipoDelDato> el) {
        this.siguiente = el.siguiente;
        el.siguiente = this;
    }

    public TipoDelDato getData() {
        return data;
    }

    public void setData(TipoDelDato data) {
        this.data = data;
    }


}