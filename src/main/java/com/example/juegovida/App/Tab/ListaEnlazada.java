package com.example.juegovida.App.Tab;

import com.example.juegovida.App.Tab.Casilla;

public class ListaEnlazada<TipoDelDato> {
    private Casilla<TipoDelDato> primero;

    public ListaEnlazada(){

    }
    public ListaEnlazada(Casilla<TipoDelDato> primero) {
        this.primero = primero;

    }

    public boolean isVacia() {
        boolean vacio = false;
        if (this.primero == null) {
            vacio = true;
        }
        return vacio;
    }

    public void Vaciar() {
        this.primero = null;
    }

    protected void add(Casilla<TipoDelDato> el) {
        if (isVacia()) {
            this.primero = el;
        } else {
            Casilla<TipoDelDato> buc = new Casilla<>(this.primero, primero.dato);
            while (buc.siguiente != null){
                buc = buc.siguiente;
            }
            buc.siguiente = el;
        }

    }
    public void add(TipoDelDato o) {
        Casilla<TipoDelDato> nuevo = new Casilla<>(this.primero, o);
        if (isVacia()) {
            this.primero = nuevo;
        } else {
            add(nuevo);
        }
    }
    public void del(int posicion){
        Casilla<TipoDelDato> el = this.primero;
        int contador=0;
        if (posicion==0){
            this.primero=el.siguiente;
        }
        while(contador<posicion){
            el=el.siguiente;
            contador++;
        }
        if(el!= null && el.siguiente!=null) {
            if( el.siguiente.siguiente != null){
                el.siguiente=el.siguiente.siguiente;
            }else {
                el.siguiente = null;
            }
        }
    }


    public int getNumeroElementos(){
        int contador =0;
        Casilla<TipoDelDato> el=this.primero;
        while(el!=null){
            contador++;
            el=el.siguiente;
        }
        return contador;
    }
    public int getPosicion(Casilla<TipoDelDato> el){
        int contador=0;
        while(el.siguiente!=null){
            el=el.siguiente;
            contador++;
        }
        return contador;
    }
    public Casilla<TipoDelDato> getPrimero(){
        return this.primero;
    }
    public Casilla<TipoDelDato> getUltimo(){
        int posicion= getNumeroElementos();
        return this.getElemento(posicion-1);
    }
    public Casilla<TipoDelDato> getElemento(int pos){
        Casilla<TipoDelDato> e= this.primero;
        int contador=0;
        while(contador<pos){
            e=e.siguiente;
            contador++;
        }
        return e;
    }
}