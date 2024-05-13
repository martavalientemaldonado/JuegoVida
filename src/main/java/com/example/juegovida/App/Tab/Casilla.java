package com.example.juegovida.App.Tab;

import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.Recurso;

public class Casilla{
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
                double elemento=lIndiv.getElemento(c2).getTurnosVidaInd();
            }
        }
    }
}
