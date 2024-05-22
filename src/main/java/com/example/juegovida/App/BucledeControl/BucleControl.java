package com.example.juegovida.App.BucledeControl;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.ColaInd.ColaEventosIndividuo;
import com.example.juegovida.App.Tab.ColaInd.ElementoCola;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.Recurso;
import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.Errores.Mas3Indiv;
import com.example.juegovida.Errores.Mas3Recs;

public class BucleControl {
    //private ListaSimple<Individuo> lIndiv;
    private Casilla tab[][];

    private Casilla c;
    private ColaEventosIndividuo<String> colaEventosIndividuo;
    public double fila;
    public double columna;

    public BucleControl(Casilla[][] tab) {
        this.tab = tab;
    }

    public void nuevoRecurso(Tablero t)throws Mas3Recs {
        for (int i = 0; i < t.getColumna(); i++) {
            for (int j = 0; j < t.getFila(); j++) {
                if (tab[j][i].getlRec().getNumElementos() < 3) {
                    Recurso recurso = new Recurso();
                    double r=Math.random()*100;
                    if (r> recurso.getProbabilidadNuevoRE()) {
                        Agua agua = new Agua();
                        Comida comida = new Comida();
                        Biblioteca biblioteca = new Biblioteca();
                        Tesoro tesoro = new Tesoro();
                        Montaña montaña = new Montaña();
                        Pozo pozo = new Pozo();
                        if (r < agua.getProbAparicion()){
                                tab[j][i].addRec(agua);
                        } else if (r < comida.getProbAparicion() + agua.getProbAparicion()) {
                                tab[j][i].addRec(comida);
                        } else if (r < biblioteca.getProbAparicion() + comida.getProbAparicion() + agua.getProbAparicion()) {
                                tab[j][i].addRec(biblioteca);

                        } else if (r < biblioteca.getProbAparicion() + comida.getProbAparicion() + agua.getProbAparicion() + tesoro.getProbAparicion()) {
                                tab[j][i].addRec(tesoro);

                        } else if (r < biblioteca.getProbAparicion() + comida.getProbAparicion() + agua.getProbAparicion() + tesoro.getProbAparicion()+montaña.getProbAparicion()){
                                tab[j][i].addRec(montaña);
                        } else if(r< pozo.getProbAparicion()){
                                tab[j][i].addRec(pozo);

                        }
                    }
                }
            }
        }
    }
    public void eliminarRec(Tablero t){
        for (int i=0; i<t.getColumna();i++){
            for (int j=0; j< t.getFila(); j++){
                for (int k=0; k<=tab[j][i].getlRec().getNumElementos()-1;){
                    if (tab[j][i].getlRec().getElemento(k).getData().getTurnosVidaRecursos()==0){
                        Recurso relim= tab[j][i].getlRec().getElemento(k).getData();
                        tab[j][i].delRec(relim);
                        k++;
                    }
                    else{
                        k++;
                    }

                }
            }
        }
    }
    public void eliminarIndTiempo(Tablero t){
        for (int i=0; i<t.getColumna();i++){
            for (int j=0; j< t.getFila(); j++){
                for (int k=0; k<=tab[j][i].getlIndiv().getNumElementos()-1;){
                    if (tab[j][i].getlIndiv().getElemento(k).getData().getTurnosVidaInd()==0){
                        Individuo relim= tab[j][i].getlIndiv().getElemento(k).getData();
                        tab[j][i].delInd(relim);
                        k++;
                    }
                    else{
                        k++;
                    }

                }
            }
        }
    }
    public void eliminarInd(Tablero t){
        for (int i=0; i<t.getColumna();i++){
            for (int j=0; j< t.getFila(); j++){
                for (int k=0; k<=tab[j][i].getlIndiv().getNumElementos()-1;){
                    if (tab[j][i].getlIndiv().getElemento(k).getData().getTurnosVidaInd()==0){
                        Individuo ieliminar= tab[j][i].getlIndiv().getElemento(k).getData();
                        tab[j][i].delInd(ieliminar);
                        tab[j][i].getlIndiv().getElemento(k).getData().getCola().push(new ElementoCola<>("Ha muerto"));
                            k++;
                    }
                    else{
                        k++;
                    }

                    }
                }
            }
        }


    public void clonado(Tablero t)throws Mas3Indiv{
        for (int i = 0; i < t.getColumna(); i++) {
            for (int j = 0; j < t.getFila(); j++) {
                Individuo i1 = tab[j][i].getlIndiv().getElemento(0).getData();
                Individuo i2 = tab[j][i].getlIndiv().getElemento(1).getData();
                Individuo i3 = tab[j][i].getlIndiv().getElemento(2).getData();
                double r = Math.random() * 100;
                if (i1.getProbClonacion() > i2.getProbClonacion() && i1.getTurnosVidaInd() < i3.getTurnosVidaInd()) {
                    if (r < i1.getProbClonacion()) {
                        tab[j][i].addIndiv(i1);
                        if (tab[j][i].lIndiv.getNumElementos() > 3) {
                            eliminarInd(t);
                            if (tab[j][i].lIndiv.getElemento(2).getData() == i1) {
                                i1.getCola().push(new ElementoCola<>("Padre clonación"));
                                i1.getCola().push(new ElementoCola<>("Hijo" + i1));

                            }
                        } else {
                            i1.getCola().push(new ElementoCola<>("Padre clonación"));
                            i1.getCola().push(new ElementoCola<>("Hijo" + i1));

                        }
                    }


                } else if (i2.getProbClonacion() > i1.getProbClonacion() && i2.getTurnosVidaInd() < i3.getTurnosVidaInd()) {
                    if (r < i2.getProbClonacion()) {
                        tab[j][i].addIndiv(i2);
                        if (tab[j][i].lIndiv.getNumElementos() > 3) {
                            eliminarInd(t);
                            if (tab[j][i].lIndiv.getElemento(2).getData() == i2) {
                                i2.getCola().push(new ElementoCola<String>("Padre clonación"));
                                i2.getCola().push(new ElementoCola<String>("Hijo" + i2));

                            }
                        } else {
                            i2.getCola().push(new ElementoCola<String>("Padre clonación"));
                            i2.getCola().push(new ElementoCola<String>("Hijo" + i2));

                        }
                    }

                } else {
                    if (r < i3.getProbClonacion()) {
                        tab[j][i].addIndiv(i3);
                        if (tab[j][i].lIndiv.getNumElementos() > 3) {
                            eliminarInd(t);
                            if (tab[j][i].lIndiv.getElemento(2).getData() == i3) {
                                i3.getCola().push(new ElementoCola<String>("Padre clonación"));
                                i3.getCola().push(new ElementoCola<String>("Hijo" + i3));

                            }
                        } else {
                            i3.getCola().push(new ElementoCola<String>("Padre clonación"));
                            i3.getCola().push(new ElementoCola<String>("Hijo" + i3));

                        }
                    }
                }
            }
        }

    }
    public void repro(Tablero t){
        for (int i=0;i<t.getColumna();i++){
            for (int j=0; j< t.fila;j++){
                    Individuo i1=tab[j][i].getlIndiv().getElemento(0).getData();
                    Individuo i2=tab[j][i].getlIndiv().getElemento(1).getData();
                    Individuo i3=tab[j][i].getlIndiv().getElemento(2).getData();
                    double r = Math.random() * 100;
                    if(tab[j][i].lIndiv.getNumElementos()==2){
                        if(r < i1.getProbReproduccion() && r<i2.getProbReproduccion()){
                            i1.getCola().push(new ElementoCola<>("reproducción"));
                            i1.getCola().push(new ElementoCola<>("Pareja"+i2));
                            i2.getCola().push(new ElementoCola<>("reproducción"));
                            i2.getCola().push(new ElementoCola<>("Pareja"+i1));
                            if(i1.getProbReproduccion()> i2.getProbReproduccion()) {
                                i1.getCola().push(new ElementoCola<>("hijo"+ i1));
                                i2.getCola().push(new ElementoCola<>("hijo"+ i1));
                            }
                            else{
                                i1.getCola().push(new ElementoCola<>("hijo"+ i2));
                                i2.getCola().push(new ElementoCola<>("hijo"+ i2));
                            }

                        }
                    }
                    else if (tab[j][i].lIndiv.getNumElementos()==3){
                        if (r < i1.getProbReproduccion() && r<i2.getProbReproduccion() && r<i3.getProbReproduccion()){
                            if(i1.getProbReproduccion()< i2.getProbReproduccion()&& i1.getProbReproduccion()< i3.getProbReproduccion()){
                                i2.getCola().push(new ElementoCola<>("reproducción"));
                                i2.getCola().push(new ElementoCola<>("Pareja"+i3));
                                i3.getCola().push(new ElementoCola<>("reproducción"));
                                i3.getCola().push(new ElementoCola<>("Pareja"+i2));
                                if(i2.getProbReproduccion()> i3.getProbReproduccion()) {
                                    i2.getCola().push(new ElementoCola<>("hijo"+ i2));
                                    i3.getCola().push(new ElementoCola<>("hijo"+ i2));
                                }
                                else{
                                    i2.getCola().push(new ElementoCola<>("hijo"+ i3));
                                    i3.getCola().push(new ElementoCola<>("hijo"+ i3));
                                }
                            }
                            else if(i2.getProbReproduccion()< i1.getProbReproduccion()&& i2.getProbReproduccion()< i3.getProbReproduccion()){
                                i1.getCola().push(new ElementoCola<>("reproducción"));
                                i1.getCola().push(new ElementoCola<>("Pareja"+i3));
                                i3.getCola().push(new ElementoCola<>("reproducción"));
                                i3.getCola().push(new ElementoCola<>("Pareja"+i1));
                                if(i3.getProbReproduccion()> i1.getProbReproduccion()) {
                                    i3.getCola().push(new ElementoCola<>("hijo"+ i3));
                                    i1.getCola().push(new ElementoCola<>("hijo"+ i3));
                                }
                                else{
                                    i1.getCola().push(new ElementoCola<>("hijo"+ i1));
                                    i3.getCola().push(new ElementoCola<>("hijo"+ i1));
                                }
                            }
                            else if(i3.getProbReproduccion()< i1.getProbReproduccion()&& i3.getProbReproduccion()< i2.getProbReproduccion()){
                                i1.getCola().push(new ElementoCola<>("reproducción"));
                                i1.getCola().push(new ElementoCola<>("Pareja"+i2));
                                i2.getCola().push(new ElementoCola<>("reproducción"));
                                i2.getCola().push(new ElementoCola<>("Pareja"+i1));
                                if(i2.getProbReproduccion()> i1.getProbReproduccion()) {
                                    i2.getCola().push(new ElementoCola<>("hijo"+ i2));
                                    i1.getCola().push(new ElementoCola<>("hijo"+ i2));
                                }
                                else{
                                    i1.getCola().push(new ElementoCola<>("hijo"+ i1));
                                    i2.getCola().push(new ElementoCola<>("hijo"+ i1));
                                }
                            }
                        }


                    }
                }
            }
        }
    }


