package com.example.juegovida.App.Tab.ColaInd;

public class ColaEventosIndividuo<T> {
    public ElementoCola<T> cabeza;
    public ElementoCola<T> cola;
    public int longitud;
    public ElementoCola<T> siguiente;
    public ColaEventosIndividuo(){
        cabeza=cola=null;
        longitud=0;
    }
    public boolean esVacia(){
        return (cabeza==null);
    }
    public ElementoCola<T> push(ElementoCola<T> ob){
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
    public ElementoCola<T> pop(){
        ElementoCola<T> auxiliar;
        auxiliar =cabeza;
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
    public ElementoCola<T> getCabeza(){
        return this.cabeza;
    }
    public ElementoCola<T> getCola(){
        return this.cola;
    }
    public ElementoCola<T> getElemento(int posicion){
        if (posicion==0){
            return cabeza;
        }else if(posicion ==longitud-1){
            return cola;
        }
        else {
            int pos = longitud-1;
            ElementoCola<T> obj = this.cola;
            while (pos > posicion) {
                obj = obj.siguiente;
                pos--;
            }
            return obj;
        }
    }
}
