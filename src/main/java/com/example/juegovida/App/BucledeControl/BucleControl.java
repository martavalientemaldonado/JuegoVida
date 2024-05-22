package com.example.juegovida.App.BucledeControl;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.ColaInd.ColaEventosIndividuo;
import com.example.juegovida.App.Tab.ColaInd.ElementoCola;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.Errores.Mas3Indiv;
import com.example.juegovida.Errores.Mas3Recs;

public class BucleControl {
    //private ListaSimple<Individuo> lIndiv;
    private Casilla tab[][];

    private Casilla c;
    private ColaEventosIndividuo colaEventosIndividuo;
    public double fila;
    public double columna;
    public void nuevoRecurso(Tablero t)throws Mas3Recs {
        for (int i = 0; i < t.getFila(); i++) {
            for (int j = 0; j < t.getFila(); j++) {
                if (tab[j][i].getlRec().getNumElementos() < 3) {
                    Recurso recurso = new Recurso();
                    if (Math.random()*100> recurso.getProbabilidadNuevoRE()) {
                        Agua agua = new Agua();
                        Comida comida = new Comida();
                        Biblioteca biblioteca = new Biblioteca();
                        Tesoro tesoro = new Tesoro();
                        Montaña montaña = new Montaña();
                        Pozo pozo = new Pozo();
                        double r=Math.random()*100;
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
        for (int i=0; i<t.getFila();i++){
            for (int j=0; j< t.getFila(); j++){
                for (int k=0; k<=tab[j][i].getlRec().getNumElementos()-1;){
                    if (tab[j][i].getlRec().getElemento(k).getTurnosVidaRecursos()==0){
                        Recurso relim= tab[j][i].getlRec().getElemento(k);
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
        for (int i=0; i<t.getFila();i++){
            for (int j=0; j< t.getFila(); j++){
                for (int k=0; k<=tab[j][i].getlIndiv().getNumElementos()-1;){
                    if (tab[j][i].getlIndiv().getElemento(k).getTurnosVidaInd()==0){
                        Individuo relim= tab[j][i].getlIndiv().getElemento(k);
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
        for (int i=0; i<t.getFila();i++){
            for (int j=0; j< t.getFila(); j++){
                for (int k=0; k<=tab[j][i].getlIndiv().getNumElementos()-1;){
                    if (tab[j][i].getlIndiv().getElemento(k).getTurnosVidaInd()==0){
                        Individuo ieliminar= tab[j][i].getlIndiv().getElemento(k);
                        tab[j][i].delInd(ieliminar);
                        tab[j][i].getlIndiv().getElemento(k).getCola().push( new ElementoCola<String>("Ha muerto"));
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
        for (int i = 0; i < t.getFila(); i++) {
            for (int j = 0; j < t.getFila(); j++) {
                Individuo i1 = tab[j][i].getlIndiv().getElemento(0);
                Individuo i2 = tab[j][i].getlIndiv().getElemento(1);
                Individuo i3 = tab[j][i].getlIndiv().getElemento(2);
                double r = Math.random() * 100;
                if (i1.getProbClonacion() > i2.getProbClonacion() && i1.getTurnosVidaInd() < i3.getTurnosVidaInd()) {
                    if (r < i1.getProbClonacion()) {
                        Individuo hijo = i1;
                        tab[j][i].addIndiv(hijo);
                        if (tab[j][i].lIndiv.getNumElementos() > 3) {
                            eliminarInd(t);
                            if (tab[j][i].lIndiv.getElemento(2) == hijo) {
                                i1.getCola().push(new ElementoCola<String>("Padre clonación"));
                                i1.getCola().push(new ElementoCola<String>("Hijo" + hijo));

                            }
                        } else {
                            i1.getCola().push(new ElementoCola<String>("Padre clonación"));
                            i1.getCola().push(new ElementoCola<String>("Hijo" + hijo));

                        }
                    }


                } else if (i2.getProbClonacion() > i1.getProbClonacion() && i2.getTurnosVidaInd() < i3.getTurnosVidaInd()) {
                    if (r < i2.getProbClonacion()) {
                        Individuo hijo = i2;
                        tab[j][i].addIndiv(hijo);
                        if (tab[j][i].lIndiv.getNumElementos() > 3) {
                            eliminarInd(t);
                            if (tab[j][i].lIndiv.getElemento(2) == hijo) {
                                i2.getCola().push(new ElementoCola<String>("Padre clonación"));
                                i2.getCola().push(new ElementoCola<String>("Hijo" + hijo));

                            }
                        } else {
                            i2.getCola().push(new ElementoCola<String>("Padre clonación"));
                            i2.getCola().push(new ElementoCola<String>("Hijo" + hijo));

                        }
                    }

                } else {
                    if (r < i3.getProbClonacion()) {
                        Individuo hijo = i3;
                        tab[j][i].addIndiv(hijo);
                        if (tab[j][i].lIndiv.getNumElementos() > 3) {
                            eliminarInd(t);
                            if (tab[j][i].lIndiv.getElemento(2) == hijo) {
                                i3.getCola().push(new ElementoCola<String>("Padre clonación"));
                                i3.getCola().push(new ElementoCola<String>("Hijo" + hijo));

                            }
                        } else {
                            i3.getCola().push(new ElementoCola<String>("Padre clonación"));
                            i3.getCola().push(new ElementoCola<String>("Hijo" + hijo));

                        }
                    }
                }
            }
        }

    }
    public void repro(Tablero t){
        for (int i=0;i<columna;i++){
            for (int j=0; j<fila;j++){
                    Individuo i1=tab[j][i].getlIndiv().getElemento(0);
                    Individuo i2=tab[j][i].getlIndiv().getElemento(1);
                    Individuo i3=tab[j][i].getlIndiv().getElemento(2);
                    double r = Math.random() * 100;
                    if(tab[j][i].lIndiv.getNumElementos()==2){
                        if(r < i1.getProbReproduccion() && r<i2.getProbReproduccion()){
                            i1.getCola().push(new ElementoCola("reproducción"));
                            i1.getCola().push(new ElementoCola<>("Pareja"+i2));
                            i2.getCola().push(new ElementoCola("reproducción"));
                            i2.getCola().push(new ElementoCola<>("Pareja"+i1));
                            if(i1.getProbReproduccion()> i2.getProbReproduccion()) {
                                Individuo hijo = i1;
                                i1.getCola().push(new ElementoCola("hijo"+hijo));
                                i2.getCola().push(new ElementoCola("hijo"+hijo));
                            }
                            else{
                                Individuo hijo=i2;
                                i1.getCola().push(new ElementoCola("hijo"+hijo));
                                i2.getCola().push(new ElementoCola("hijo"+hijo));
                            }

                        }
                    }
                    else if (tab[j][i].lIndiv.getNumElementos()==3){
                        if (r < i1.getProbReproduccion() && r<i2.getProbReproduccion() && r<i3.getProbReproduccion()){
                            if(i1.getProbReproduccion()< i2.getProbReproduccion()&& i1.getProbReproduccion()< i3.getProbReproduccion()){
                                i2.getCola().push(new ElementoCola("reproducción"));
                                i2.getCola().push(new ElementoCola<>("Pareja"+i3));
                                i3.getCola().push(new ElementoCola("reproducción"));
                                i3.getCola().push(new ElementoCola<>("Pareja"+i2));
                                if(i2.getProbReproduccion()> i3.getProbReproduccion()) {
                                    Individuo hijo = i2;
                                    i2.getCola().push(new ElementoCola("hijo"+hijo));
                                    i3.getCola().push(new ElementoCola("hijo"+hijo));
                                }
                                else{
                                    Individuo hijo=i3;
                                    i2.getCola().push(new ElementoCola("hijo"+hijo));
                                    i3.getCola().push(new ElementoCola("hijo"+hijo));
                                }
                            }
                            else if(i2.getProbReproduccion()< i1.getProbReproduccion()&& i2.getProbReproduccion()< i3.getProbReproduccion()){
                                i1.getCola().push(new ElementoCola("reproducción"));
                                i1.getCola().push(new ElementoCola<>("Pareja"+i3));
                                i3.getCola().push(new ElementoCola("reproducción"));
                                i3.getCola().push(new ElementoCola<>("Pareja"+i1));
                                if(i3.getProbReproduccion()> i1.getProbReproduccion()) {
                                    Individuo hijo = i3;
                                    i3.getCola().push(new ElementoCola("hijo"+hijo));
                                    i1.getCola().push(new ElementoCola("hijo"+hijo));
                                }
                                else{
                                    Individuo hijo=i1;
                                    i1.getCola().push(new ElementoCola("hijo"+hijo));
                                    i3.getCola().push(new ElementoCola("hijo"+hijo));
                                }
                            }
                            else if(i3.getProbReproduccion()< i1.getProbReproduccion()&& i3.getProbReproduccion()< i2.getProbReproduccion()){
                                i1.getCola().push(new ElementoCola("reproducción"));
                                i1.getCola().push(new ElementoCola<>("Pareja"+i2));
                                i2.getCola().push(new ElementoCola("reproducción"));
                                i2.getCola().push(new ElementoCola<>("Pareja"+i1));
                                if(i2.getProbReproduccion()> i1.getProbReproduccion()) {
                                    Individuo hijo = i2;
                                    i2.getCola().push(new ElementoCola("hijo"+hijo));
                                    i1.getCola().push(new ElementoCola("hijo"+hijo));
                                }
                                else{
                                    Individuo hijo=i1;
                                    i1.getCola().push(new ElementoCola("hijo"+hijo));
                                    i2.getCola().push(new ElementoCola("hijo"+hijo));
                                }
                            }
                        }


                    }
                }
            }
        }
    }


