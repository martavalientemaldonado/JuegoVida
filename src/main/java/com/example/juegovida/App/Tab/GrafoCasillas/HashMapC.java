package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.App.Tab.Grafo.ElementoHashMap;
import com.example.juegovida.App.Tab.Grafo.ListaEnlazada;

public class HashMapC<T,E> {
    ElementoHashMapC<T,E> primero;

    public HashMapC() {
        this.primero = null;
    }
    public boolean isVacia(){
        return primero == null;
    }
    public void put(T indice, E dato){
        if(!this.isVacia()){
            ElementoHashMapC<T,E> actual = this.primero;
            while (actual.getSiguiente() != null){
                if(actual.getNodobuscamos() == indice){
                    actual.setCamino(dato);
                    return;
                }
                actual = actual.getSiguiente();
            }
            if(actual.getNodobuscamos() == indice){
                actual.setCamino(dato);
            }else{
                ElementoHashMapC<T,E> nuevo= new ElementoHashMapC<>(null, indice,dato);
                actual.setSiguiente(nuevo);
            }
        }else {
            ElementoHashMapC<T,E> nuevo = new ElementoHashMapC<>(null, indice,dato);
            this.primero = nuevo;
        }
    }
    public E get(T indice){
        ElementoHashMapC<T,E> bucle = this.primero;
        while(bucle.getSiguiente() != null && bucle.getNodobuscamos() != indice){
            bucle = bucle.siguiente;
        }
        if (bucle.getNodobuscamos() == indice){
            return bucle.getCamino();
        }else{
            return null;
        }
    }
    public ListaEnlazadaCasillas<T> KeySet(){
        ListaEnlazadaCasillas<T> listaClaves = new ListaEnlazadaCasillas<>();
        ElementoHashMapC<T,E> bucle = this.primero;
        while(bucle != null){
            listaClaves.add(bucle.getNodobuscamos());
            bucle = bucle.getSiguiente();
        }
        return listaClaves;
    }
}
