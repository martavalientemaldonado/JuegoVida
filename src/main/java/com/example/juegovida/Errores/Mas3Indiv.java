package com.example.juegovida.Errores;

import com.example.juegovida.App.Tab.ListaSimple;
import com.example.juegovida.Clases.Individuo;

public class Mas3Indiv extends Exception {
    public Mas3Indiv (ListaSimple<Individuo> lIndiv){
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
