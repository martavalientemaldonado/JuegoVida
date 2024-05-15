package com.example.juegovida.Errores;

import com.example.juegovida.App.Tab.ListaSimple;
import com.example.juegovida.Clases.Recursos.Recurso;

public class Mas3Recs extends Exception{
    public Mas3Recs(ListaSimple<Recurso>lRec){

        int c1=0;
        int c2=0;
        while (c2<lRec.getNumElementos()){
            double elemento=lRec.getElemento(c2).getTurnosVidaRecursos();
            if (elemento<lRec.getElemento(c1).getTurnosVidaRecursos()){
                c1=c2;
            }
            c2 ++;
        }
        lRec.del(c1);
    }
}
