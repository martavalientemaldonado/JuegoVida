package com.example.juegovida.App.Tab;

import com.example.juegovida.Clases.Individuo;

public class ListaEnlazadaInd{
    private ElementoLEIndividuo primero;
    public ListaEnlazadaInd() {
        this.primero = null;

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

    protected void add(ElementoLEIndividuo el) {
        if (isVacia()) {
            this.primero = el;
        } else {
            ElementoLEIndividuo nuevoprimero = new ElementoLEIndividuo(this.primero, el.getData());
            this.primero = nuevoprimero;
        }

    }

    public void add(Individuo s) {
        ElementoLEIndividuo nuevoPrimero = new ElementoLEIndividuo(this.primero, s);
        add(nuevoPrimero);
    }

    public void insert(Individuo s, int posicion) {
        if (posicion == 0) {
            this.add(s);
        } else {
            ElementoLEIndividuo e2= new ElementoLEIndividuo(this.getElemento(posicion),s);
            this.getElemento(posicion - 1).siguiente = e2;


        }

    }
    public void del(int posicion){
        ElementoLEIndividuo el = this.primero;
        int contador=0;
        if (posicion==0){
            this.primero=el.siguiente;
        }
        while(contador<posicion-1){
            el=el.siguiente;
            contador++;
        }
        if(el!= null && el.getSiguiente()!=null) {
            el.siguiente=el.siguiente.siguiente;
        }


    }

    public int getNumeroElementos(){
        int contador=0;
        ElementoLEIndividuo el = this.primero;
        while(el!=null){
            contador++;
            el=el.getSiguiente();
        }
        return contador;
    }
    public int getPosicion(ElementoLEIndividuo el){
        int contador=0;
        while(el.siguiente!=null){
            el=el.siguiente;
            contador++;
        }
        return contador;
    }
    public ElementoLEIndividuo getPrimero(){
        ElementoLEIndividuo el = this.primero;
        return el;
    }
    public ElementoLEIndividuo getUltimo(){
        int posicion= getNumeroElementos();
        return this.getElemento(posicion-1);
    }
    public ElementoLEIndividuo getElemento(int pos){
        ElementoLEIndividuo e= this.primero;
        int contador=0;
        while(contador<pos){
            e= e.siguiente;
            contador++;
        }
        return e;
    }
    public void imprimir() {
        int c = 0;
        while (c < this.getNumeroElementos()) {
            System.out.println(this.getElemento(c));
            c++;
        }
    }
    public ListaEnlazadaInd reverse(ListaEnlazadaInd lis){
        ListaEnlazadaInd l = new ListaEnlazadaInd();
        for(int i = 0; lis.getElemento(i)!= null; i++){
            l.add(this.getElemento(i));
        }
        return l;
    }
}
