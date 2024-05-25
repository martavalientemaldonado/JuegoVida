package com.example.juegovida.App.Tab;
import com.example.juegovida.Clases.Individuo;
public class NodoInd {
    protected Individuo dato;//Protected para utilizar el dato fuera
    protected NodoInd izdo;
    protected NodoInd dcho;
    public NodoInd(Individuo valor){
        dato = valor;
        izdo = dcho = null;
    }
    public NodoInd(NodoInd ramaIzdo, Individuo dato, NodoInd ramaDcho){
        this.dato=dato;
        this.izdo = ramaIzdo;
        this.dcho = ramaDcho;
    }
    public NodoInd(){
    }
    public void copia(NodoInd n){
        this.dcho= n.dcho;
        this.izdo= n.izdo;
        this.dato= n.dato;
    }
    public Individuo getDato() {
        return dato;
    }

    public NodoInd getIzdo() {
        return izdo;
    }

    public NodoInd getDcho() {
        return dcho;
    }

    public void setDato(Individuo dato) {
        this.dato = dato;
    }

    public void setIzdo(NodoInd izdo) {
        this.izdo = izdo;
    }

    public void setDcho(NodoInd dcho) {
        this.dcho = dcho;
    }
    public int getGradoNodo() {
        int grado=0;
        if (izdo!=null) {
            grado++;
        }
        if (dcho!=null){
            grado++;
        }
        return grado;
    }
    public void añadirNodo(NodoInd el){
        Comparable c= (Comparable) this.dato.getNumIdentificacion();
        if (c.compareTo(el.dato.getNumIdentificacion())>0){
            if (this.izdo==null){
                this.izdo=el;
            }else{
                this.izdo.añadirNodo(el);
            }
        }
        if (c.compareTo(el.dato.getNumIdentificacion())<0){
            if (this.dcho==null){
                this.dcho=el;
            }else{
                this.dcho.añadirNodo(el);
            }
        }
    }

    public NodoInd borrado(Individuo valor, NodoInd n) {
        Comparable c = (Comparable) n.getDato().getNumIdentificacion();
        int result = c.compareTo(valor.getNumIdentificacion());
        if (result > 0) {
            NodoInd iz = borrado(valor, n.izdo);
            n.setIzdo(iz);
        } else if (result < 0) {
            NodoInd dec = borrado(valor, n.dcho);
            n.setDcho(dec);
        } else {
            NodoInd p = n;
            if (p.getDcho() == null) {
                n = p.getIzdo();
            } else if (p.getIzdo() == null) {
                n = p.getDcho();
            } else {
                n = cambiar(p);
            }
            p = null;
        }
        return n;
    }

    protected  NodoInd cambiar(NodoInd n){
        NodoInd p = n;
        NodoInd a = n.getIzdo();
        while (a.getDcho() != null){
            p = a;
            a = a.getDcho();
        }
        n.setDato(a.getDato());
        if (p == n){
            p.setIzdo(a.getIzdo());
        }else{
            p.setDcho((a.getIzdo()));
        }
        return a;
    }

    public NodoInd NodoPadreIzq(NodoInd nodoactual){
        NodoInd n= new NodoInd();
        if (nodoactual.izdo.izdo==null){
            n=nodoactual;
        }else{
            NodoPadreIzq(nodoactual.izdo);
        }
        return n;
    }
}
