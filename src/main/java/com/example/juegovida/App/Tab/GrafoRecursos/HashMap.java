package com.example.juegovida.App.Tab.GrafoRecursos;

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
                if(actual.getIndice() == indice){
                    actual.setDato(dato);
                    return;
                }
                actual = actual.getSiguiente();
            }
            if(actual.getIndice() == indice){
                actual.setDato(dato);
            }else{
                ElementoHashMap<T,E> nuevo= new ElementoHashMap<>(null, indice,dato);
                actual.setSiguiente(nuevo);
            }
        }else {
            ElementoHashMap<T,E> nuevo = new ElementoHashMap<>(null, indice,dato);
            this.primero = nuevo;
        }
    }
    public E get(T indice){
        ElementoHashMap<T,E> bucle = this.primero;
        while(bucle.getSiguiente() != null && bucle.getIndice() != indice){
            bucle = bucle.siguiente;
        }
        if (bucle.getIndice() == indice){
            return bucle.getDato();
        }else{
            return null;
        }
    }
    public ListaEnlazada KeySet(){
        ListaEnlazada listaClaves = new ListaEnlazada();
        ElementoHashMap<T,E> bucle = this.primero;
        while(bucle != null){
            listaClaves.add(bucle.getIndice());
            bucle = bucle.getSiguiente();
        }
        return listaClaves;
    }
}
