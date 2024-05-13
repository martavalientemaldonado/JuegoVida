package com.example.juegovida.App.Tab.GrafoRecursos;

public class ElementoLE<TipoDelDato> { // Para introducir valor de cualquier tipo.
    protected ElementoLE siguiente;
    private TipoDelDato data;
    public ElementoLE(TipoDelDato data){
        this.data=data;
    }
    public ElementoLE(ElementoLE siguiente, TipoDelDato data) {
        this.siguiente = siguiente;
        this.data = data;
    }

    protected ElementoLE getSiguiente() {
        return siguiente;
    }

    protected void insertarmeEn(ElementoLE el) {
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


