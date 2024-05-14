package com.example.juegovida.App.Tab;

import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.Recurso;

public class Casilla<TipodeDato>{
    private ListaSimple<Individuo> lIndiv;
    private ListaSimple<Recurso> lRec;

    public Casilla() {
        ListaSimple<Individuo> lIndiv= new ListaSimple<>();
        ListaSimple<Recurso> lRec= new ListaSimple<>();
        this.lIndiv=lIndiv;
        this.lRec=lRec;

    }


    public Casilla(ListaSimple<Individuo> lIndiv, ListaSimple<Recurso> lRec) {
        this.lIndiv = lIndiv;
        this.lRec = lRec;
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
    public void addIndiv(Individuo indiv){
        lIndiv.add(indiv);
        if(lIndiv.getNumElementos()>3){
            int c1=0;
            int c2=0;
            while (c2<lIndiv.getNumElementos()){
                //int elemento=lIndiv.getElemento(c2).getTurnosQuedan();
                //if (elemento<lIndiv.getElemento(c1).getTurnosQuedan()){
                    //c1=c2;
                }
                c2 ++;
            }
            //lIndiv.del(c1);
        }
    //}
    public void addRec(Recurso rec){
        lRec.add(rec);
        if(lRec.getNumElementos()>3){
            int c1=0;
            int c2=0;
            while (c2<lRec.getNumElementos()){
                //int elemento=lRec.getElemento(c2).getData().getTurnosQuedan();
                //if (elemento<lRec.getElemento(c1).getData.getTurnosQuedan()){
                    c1=c2;
                }
                c2 ++;
            }
            //lRec.del(c1);
        }
    //}
}
