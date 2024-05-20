package com.example.juegovida.App.Tab.Grafo;

public class ElementoLE<TipoDelDato> { // Para introducir valor de cualquier tipo.
    protected ElementoLE<TipoDelDato> siguiente;
    private TipoDelDato data;
    public ElementoLE(TipoDelDato data){
        this.data=data;
    }
    public ElementoLE(ElementoLE<TipoDelDato> siguiente, TipoDelDato data) {
        this.siguiente = siguiente;
        this.data = data;
    }

    public void setSiguiente(ElementoLE<TipoDelDato> siguiente) {
        this.siguiente = siguiente;
    }


    protected ElementoLE<TipoDelDato> getSiguiente() {
        return siguiente;
    }

    protected void insertarmeEn(ElementoLE<TipoDelDato> el) {
        el.siguiente = this.siguiente;
        this.siguiente = el;
    }

    public TipoDelDato getData() {
        return data;
    }

    public void setData(TipoDelDato data) {
        this.data = data;
    }


    }


