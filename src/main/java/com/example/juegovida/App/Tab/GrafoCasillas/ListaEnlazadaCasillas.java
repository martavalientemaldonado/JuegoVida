package com.example.juegovida.App.Tab.GrafoCasillas;
public class ListaEnlazadaCasillas<TipodeDato> {
    private ElementoLECasillas<TipodeDato> primero;
    public ListaEnlazadaCasillas() {
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

    protected void add(ElementoLECasillas<TipodeDato> el) {
        if (isVacia()) {
            this.primero = el;
        } else {
            ElementoLECasillas<TipodeDato> e = this.primero;
            while (e.siguiente!=null){
                e = e.siguiente;
            }
            e.siguiente = el;
        }

    }

    public void add(TipodeDato s) {
        ElementoLECasillas<TipodeDato> nuevoPrimero = new ElementoLECasillas<TipodeDato>(this.primero, s);
        add(nuevoPrimero);
    }
    public void del(int posicion){
        ElementoLECasillas<TipodeDato> el = this.primero;
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
        ElementoLECasillas<TipodeDato> el = this.primero;
        while(el!=null){
            contador++;
            el=el.getSiguiente();
        }
        return contador;
    }
    public Integer getPosicion(TipodeDato el){
        if(isVacia()){
            return null;
        }
        int contador=0;
        ElementoLECasillas<TipodeDato> e = this.primero;
        for(int i = 0; (contador<getNumeroElementos()) &&(e.getData() != el); i++){
            e=e.siguiente;
            contador++;
        }
        if( (contador >= getNumeroElementos()) &&(el!= getUltimo().getData())){
            return null;
        }
        return contador;
    }
    public ElementoLECasillas<TipodeDato> getPrimero(){
        ElementoLECasillas<TipodeDato> el = this.primero;
        return el;
    }
    public ElementoLECasillas<TipodeDato> getUltimo(){
        return this.getElemento(getNumeroElementos()-1);
    }
    public ElementoLECasillas<TipodeDato> getElemento(int pos){
        ElementoLECasillas<TipodeDato> e= this.primero;
        int contador=0;
        while(contador<pos){
            e= e.siguiente;
            contador++;
        }
        return e;
    }
    public ListaEnlazadaCasillas<TipodeDato> reverse(ListaEnlazadaCasillas<TipodeDato> lis){
        ListaEnlazadaCasillas<TipodeDato> l = new ListaEnlazadaCasillas<>();
        for(int i = 0; lis.getElemento(i)!= null; i++){
            l.add(this.getElemento(i));
        }
        return l;
    }
    public void EliminarPrimero(){
        this.primero = primero.siguiente;
    }
    public void insert(TipodeDato el, int posicion){
        ElementoLECasillas<TipodeDato> elemento = new ElementoLECasillas<>();
        elemento.setData(el);
        if(posicion == 0){
            elemento.setSiguiente(primero);
            primero=elemento;
        }else{
            elemento.insertarmeEn(getElemento(posicion-1));
        }
    }
}
