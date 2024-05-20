package com.example.juegovida.App.Tab;

public class ElementoLETablero<TipoDelDato> {
    protected ElementoLETablero<TipoDelDato> siguiente;
    private TipoDelDato data;
    public ElementoLETablero(TipoDelDato data){
            this.data=data;
    }
    public ElementoLETablero(ElementoLETablero<TipoDelDato> siguiente, TipoDelDato data) {
        this.siguiente = siguiente;
        this.data = data;
    }
    protected ElementoLETablero<TipoDelDato> getSiguiente() {
            return siguiente;
    }
    protected void insertarmeEn(ElementoLETablero<TipoDelDato> el) {
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
