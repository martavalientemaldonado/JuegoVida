package com.example.juegovida.App.Tab.GrafoCasillas;

public class Cola<T> {
    private ElementoLDE<T> cabeza;
    private ElementoLDE<T> cola;
    private int longitud;
    private ElementoLDE<T> siguiente;
    public Cola(){
        cabeza=cola=null;
        longitud=0;
    }
    public boolean esVacia(){
        return (cabeza==null);
    }
    public ElementoLDE<T> encolar(ElementoLDE<T> ob){
        if (longitud==0){
            cola=cabeza=ob; //Para que en el setSiguiente no de null
            longitud = longitud+1;
        }else{
            ob.siguiente=cola;
            cola.anterior = ob;
            cola = ob;
            longitud = longitud+1;
        }
        return cola;
    }
    public ElementoLDE<T> desencolar(){
        ElementoLDE<T> auxiliar;
        auxiliar = cabeza;
        if (esVacia())
            return null;
        else{
            if(cabeza.anterior != null) {
                cabeza = cabeza.anterior;
                cabeza.siguiente = null;
            }else cabeza = null;
        }
        longitud = longitud-1;
        return auxiliar;
    }
    public ElementoLDE<T> getCabeza(){
        return this.cabeza;
    }
    public ElementoLDE<T> getCola(){
        return this.cola;
    }
    public ElementoLDE<T> getElemento(int posicion){
        if (posicion==0){
            return cabeza;
        }else if(posicion ==longitud-1){
            return cola;
        }
        else {
            int pos = longitud-1;
            ElementoLDE<T> obj = this.cola;
            while (pos > posicion) {
                obj = obj.siguiente;
                pos--;
            }
            return obj;
        }
    }
}
