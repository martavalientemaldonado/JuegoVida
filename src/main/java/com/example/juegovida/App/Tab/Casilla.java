package com.example.juegovida.App.Tab;

import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.Recurso;
import com.example.juegovida.Errores.Mas3Indiv;

public class Casilla{
    public ListaSimple<Individuo> lIndiv;
    public ListaSimple<Recurso> lRec;
    public double fila;
    public double columna;


    public Casilla(double i, double j) {
        ListaSimple<Individuo> lIndiv= new ListaSimple<>();
        ListaSimple<Recurso> lRec= new ListaSimple<>();
        this.lIndiv=lIndiv;
        this.lRec=lRec;
        this.fila = i;
        this.columna = j;
    }


    public Casilla(ListaSimple<Individuo> lIndiv, ListaSimple<Recurso> lRec) {
        this.lIndiv = lIndiv;
        this.lRec = lRec;
    }

    public Casilla(ListaSimple<Individuo> lIndiv, ListaSimple<Recurso> lRec, int fila, int columna) {
        this.lIndiv = lIndiv;
        this.lRec = lRec;
        this.fila = fila;
        this.columna = columna;
    }

    public ListaSimple<Individuo> getlIndiv() {
        return lIndiv;
    }

    public ListaSimple<Recurso> getlRec() {
        return lRec;
    }

    public void setlIndiv(ListaSimple<Individuo> lIndiv) {
        this.lIndiv = lIndiv;
    }

    public void setlRec(ListaSimple<Recurso> lRec) {
        this.lRec = lRec;
    }

    public void delRec(Recurso rec){
        ElementoLS<Recurso> re = new ElementoLS<>(rec);
        int pos=lRec.getPosicion(re);
        lRec.del(pos);

    }
    public void delInd(Individuo ind){
        ElementoLS<Individuo> in = new ElementoLS<>(ind);
        int pos=lIndiv.getPosicion(in);
        lIndiv.del(pos);

    }
    public void addIndiv(Individuo indiv) throws Mas3Indiv {
        lIndiv.add(indiv);
        if(lIndiv.getNumElementos()>3){
            int c1=0;
            int c2=0;
            while (c2<lIndiv.getNumElementos()){
                double elemento=lIndiv.getElemento(c2).getData().getTurnosVidaInd();
                if (elemento<lIndiv.getElemento(c1).getData().getTurnosVidaInd()){
                    c1=c2;
                }
                c2 ++;
            }
            lIndiv.del(c1);
        }
    }
    public void addRec(Recurso rec) {
        lRec.add(rec);
        if (lRec.getNumElementos() > 3) {
            int c1 = 0;
            int c2 = 0;
            while (c2 < lRec.getNumElementos()) {
                double elemento = lRec.getElemento(c2).getData().getTurnosVidaRecursos();
                if (elemento < lRec.getElemento(c1).getData().getTurnosVidaRecursos()) {
                    c1 = c2;
                }
                c2++;
            }
            lRec.del(c1);
        }


    }

    public double getFila() {
        return fila;
    }

    public double getColumna() {
        return columna;
    }

    public void setFila(double fila) {
        this.fila = fila;
    }

    public void setColumna(double columna) {
        this.columna = columna;
    }
}
