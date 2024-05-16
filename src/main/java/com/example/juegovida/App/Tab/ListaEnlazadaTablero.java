package com.example.juegovida.App.Tab;


public class ListaEnlazadaTablero<TipodeDato>{
    private ElementoLETablero<TipodeDato> primero;
    public ListaEnlazadaTablero() {
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

    protected void add(ElementoLETablero<TipodeDato> el) {
        if (isVacia()) {
            this.primero = el;
        } else {
            ElementoLETablero<TipodeDato> nuevoprimero = new ElementoLETablero<TipodeDato>(this.primero, el.getData());
            this.primero = nuevoprimero;
        }

    }

    public void add(TipodeDato s) throws NullPointerException{
        if (s != null) {
            ElementoLETablero<TipodeDato> nuevoPrimero = new ElementoLETablero<TipodeDato>(this.primero, s);
            add(nuevoPrimero);
        }else throw new NullPointerException("Es nulo");
    }

    public void insert(TipodeDato s, int posicion) {
        if (posicion == 0) {
            this.add(s);
        } else {
            ElementoLETablero<TipodeDato> e2= new ElementoLETablero<>(this.getElemento(posicion),s);
            this.getElemento(posicion - 1).siguiente = e2;


        }

    }
    public void del(int posicion){
        ElementoLETablero<TipodeDato> el = this.primero;
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
        ElementoLETablero<TipodeDato> el = this.primero;
        while(el!=null){
            contador++;
            el=el.getSiguiente();
        }
        return contador;
    }
    public int getPosicion(ElementoLETablero<TipodeDato> el){
        int contador=0;
        while(el.siguiente!=null){
            el=el.siguiente;
            contador++;
        }
        return contador;
    }
    public ElementoLETablero<TipodeDato> getPrimero(){
        ElementoLETablero<TipodeDato> el = this.primero;
        return el;
    }
    public ElementoLETablero<TipodeDato> getUltimo(){
        int posicion= getNumeroElementos();
        return this.getElemento(posicion-1);
    }
    public ElementoLETablero<TipodeDato> getElemento(int pos){
        ElementoLETablero<TipodeDato> e= this.primero;
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
    public ListaEnlazadaTablero<TipodeDato> reverse(ListaEnlazadaTablero<TipodeDato> lis){
        ListaEnlazadaTablero<TipodeDato> l = new ListaEnlazadaTablero<>();
        for(int i = 0; lis.getElemento(i)!= null; i++){
            l.add(this.getElemento(i));
        }
        return l;
    }
}