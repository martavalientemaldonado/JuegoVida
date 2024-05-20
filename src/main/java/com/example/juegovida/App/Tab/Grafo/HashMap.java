package com.example.juegovida.App.Tab.Grafo;


public class HashMap<T,E> {
    ElementoHashMap<T,E> primero;

    public HashMap() {
        this.primero = null;
    }
    public boolean isVacia(){
        return primero == null;
    }
    public void put(T indice, E dato){
        if(!this.isVacia()){
            ElementoHashMap<T,E> actual = this.primero;
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
                ElementoHashMap<T,E> nuevo= new ElementoHashMap<>(null, indice,dato);
                actual.setSiguiente(nuevo);
            }
        }else {
            this.primero = new ElementoHashMap<>(null, indice,dato);
        }
    }
    public E get(T indice){
        ElementoHashMap<T,E> bucle = this.primero;
        while(bucle.getSiguiente() != null && bucle.getNodobuscamos() != indice){
            bucle = bucle.siguiente;
        }
        if (bucle.getNodobuscamos() == indice){
            return bucle.getCamino();
        }else{
            return null;
        }
    }
    public ListaEnlazada<T> KeySet(){
        ListaEnlazada<T> listaClaves = new ListaEnlazada<>();
        ElementoHashMap<T,E> bucle = this.primero;
        while(bucle != null){
            listaClaves.add(bucle.getNodobuscamos());
            bucle = bucle.getSiguiente();
        }
        return listaClaves;
    }
}
