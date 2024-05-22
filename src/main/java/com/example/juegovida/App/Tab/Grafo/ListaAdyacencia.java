package com.example.juegovida.App.Tab.Grafo;

import com.example.juegovida.Errores.ElRepetidoError;
public class ListaAdyacencia<TipodelDato> {
    AristasGrafo<TipodelDato> primero;
    AristasGrafo<TipodelDato> ultimo;

    public ListaAdyacencia(){
        this.primero = null;
        this.ultimo = null;
    }
    public boolean listaVacia(){
        return primero == null;
    }

    public void nuevaAdyacencia(NodoGrafo<TipodelDato> inicio,NodoGrafo<TipodelDato> destino) throws ElRepetidoError {
        if(!adyacente(destino)){
            AristasGrafo<TipodelDato> nodo = new AristasGrafo<TipodelDato>(inicio,destino);
            inserta(nodo);
        }else throw new ElRepetidoError("El nodo ya se encuentra en la lista de adyacencias.");
    }

    public void nuevaAdyacencia(NodoGrafo<TipodelDato> inicio,NodoGrafo<TipodelDato> destino, double peso) throws ElRepetidoError {
        if(!adyacente(destino)){
            AristasGrafo<TipodelDato> nodo = new AristasGrafo<TipodelDato>(inicio,destino,peso);
            inserta(nodo);
        }else throw new ElRepetidoError("El nodo ya se encuentra en la lista de adyacencias.");
    }

    public boolean adyacente(NodoGrafo<TipodelDato> dato){
        AristasGrafo<TipodelDato> actual = primero;
        boolean encontrado = false;
        while (actual != null && !dato.dato.equals(actual.destino.dato)){
            actual = actual.siguiente;
        }
        if (actual != null){
            encontrado = true;
        }
        return encontrado;
    }

    private void inserta(AristasGrafo<TipodelDato> arista){
        if(listaVacia()){
            this.primero = arista;
            this.ultimo = arista;
        } else{
            if(arista.destino.toString().compareTo(primero.destino.toString())<0){
                arista.siguiente = primero;
                primero = arista;
            }else{
                if(arista.destino.toString().compareTo((ultimo.destino.toString()))>0){
                    ultimo.siguiente = arista;
                    ultimo = arista;
                }else{
                    AristasGrafo<TipodelDato> posicion = primero;
                    while(arista.destino.toString().compareTo((posicion.destino.toString()))< 0){
                        posicion = posicion.siguiente;
                    }
                    arista.siguiente=posicion.siguiente;
                    posicion.siguiente = arista;
                }
            }
        }
    }
    private int getPosicion(AristasGrafo<TipodelDato> arista){
        int contador=0;
        AristasGrafo<TipodelDato> p = primero;
        while(p.siguiente!=null && p != arista){
            p=p.siguiente;
            contador++;
        }
        if (contador ==0){
            if(arista == primero){
                return contador+1;
            }else{
                return -1;
            }
        }
        return contador+1;
    }
    public void borrararista(AristasGrafo<TipodelDato> arista){
        int contador = 0;
        AristasGrafo<TipodelDato> a = primero;
        if(!listaVacia()){
            if(arista.destino == primero.destino && arista.inicio == primero.inicio){
                if(primero.siguiente != null){
                    primero= primero.siguiente;
                }
            }else{
                AristasGrafo<TipodelDato> posicion = primero;
                while(contador < getPosicion(arista)-2){
                    a = a.siguiente;
                    posicion = posicion.siguiente;
                    contador++;
                }
                if(a!= null && a.getSiguiente()!= null) a.siguiente = a.siguiente.siguiente;
                if (a.siguiente == ultimo){
                    ultimo = a;
                }
            }
        }
    }
    public void borrarprimero(){
        AristasGrafo<TipodelDato> p= primero;
        primero = primero.siguiente;
        p = null;
    }

    public AristasGrafo<TipodelDato> getArista(NodoGrafo<TipodelDato> des){
        if(ultimo.destino == des) return ultimo;
        if(des!= null) {
            AristasGrafo<TipodelDato> ar = primero;
            while (ar != ultimo && ar.destino!= des) {
                ar = ar.siguiente;
            }
            if(ar.destino == des) return ar;
            else return null;
        }
        return null;
    }
}
