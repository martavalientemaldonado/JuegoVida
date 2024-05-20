package com.example.juegovida.App.Tab.Grafo;

public class ListaEnlazada<TipodeDato>{
    private ElementoLE<TipodeDato> primero;
    public ListaEnlazada() {
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

    protected void add(ElementoLE<TipodeDato> el) {
        if (isVacia()) {
            this.primero = el;
        } else {
            this.primero = new ElementoLE<>(this.primero, el.getData());
        }

    }

    public void add(TipodeDato s) {
        ElementoLE<TipodeDato> nuevoPrimero = new ElementoLE<TipodeDato>(this.primero, s);
        add(nuevoPrimero);
    }
    public void del(int posicion){
        ElementoLE<TipodeDato> el = this.primero;
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
        ElementoLE<TipodeDato> el = this.primero;
        while(el!=null){
            contador++;
            el=el.getSiguiente();
        }
        return contador;
    }
    public int getPosicion(ElementoLE<TipodeDato> el){
        int contador=0;
        while(el.siguiente!=null){
            el=el.siguiente;
            contador++;
        }
        return contador;
    }
    public ElementoLE<TipodeDato> getPrimero(){
        ElementoLE<TipodeDato> el = this.primero;
        return el;
    }
    public ElementoLE<TipodeDato> getUltimo(){
        int posicion= getNumeroElementos();
        return this.getElemento(posicion-1);
    }
    public ElementoLE<TipodeDato> getElemento(int pos){
        ElementoLE<TipodeDato> e= this.primero;
        int contador=0;
        while(contador<pos){
            e= e.siguiente;
            contador++;
        }
        return e;
    }
    public ListaEnlazada<TipodeDato> reverse(ListaEnlazada<TipodeDato> lis){
        ListaEnlazada<TipodeDato> l = new ListaEnlazada<TipodeDato>();
        for(int i = 0; lis.getElemento(i)!= null; i++){
            l.add(this.getElemento(i));
        }
        return l;
    }
    public void EliminarPrimero(){
        this.primero = primero.siguiente;
    }
}
