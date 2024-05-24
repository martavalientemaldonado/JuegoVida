package com.example.juegovida.App.BucledeControl;

import com.example.juegovida.App.Tab.*;
import com.example.juegovida.App.Tab.ColaInd.ElementoCola;
import com.example.juegovida.App.Tab.GrafoCasillas.*;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.Errores.ElNoEncontradoError;
import com.example.juegovida.Errores.Mas3Indiv;
import com.example.juegovida.Errores.Mas3Recs;

import java.util.Objects;

public class BucleControl {
    ListaEnlazadaCasillas<Individuo> listaIndividuos;
    int NumeroIdIndUlt;
    private Casilla tab[][];
    private GrafoTablero<Casilla> grafo;
    private ListaEnlazadaCasillas<ListaEnlazadaCasillas<Casilla>> lista;
    private Casilla c;
    public double fila;
    public double columna;

    public BucleControl(Casilla[][] tab) {
        this.tab = tab;
    }

    public void nuevoRecurso(Tablero t)throws Mas3Recs {
        for (int i = 0; i < t.getFila(); i++) {
            for (int j = 0; j < t.getFila(); j++) {
                if (tab[j][i].getlRec().getNumElementos() < 3) {
                    Recurso recurso = new Recurso();
                    if (Math.random()*100 > recurso.getProbabilidadNuevoRE()) {
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
                    if(tab[j][i].getlRec().getElemento(k).getData().getTurnosVidaRecursos()==0){
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
        for (int i=0; i<t.getFila();i++){
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
        for (int i=0; i<t.getFila();i++){
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
        for (int i = 0; i < t.getFila(); i++) {
            for (int j = 0; j < t.getFila(); j++) {
                Individuo i1 = tab[j][i].getlIndiv().getElemento(0).getData();
                Individuo i2 = tab[j][i].getlIndiv().getElemento(1).getData();
                Individuo i3 = tab[j][i].getlIndiv().getElemento(2).getData();
                double r = Math.random() * 100;
                if (i1.getProbClonacion() > i2.getProbClonacion() && i1.getTurnosVidaInd() > i3.getTurnosVidaInd()) {
                    if (r < i1.getProbClonacion()) {
                        NumeroIdIndUlt = NumeroIdIndUlt+1;
                        Individuo in2 = new Individuo(i1.getTurnosVidaInd(), i1.getProbClonacion(),i1.getProbReproduccion(),NumeroIdIndUlt,i1.getTipo());
                        tab[j][i].addIndiv(in2);
                        listaIndividuos.add(in2);
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
                        NumeroIdIndUlt = NumeroIdIndUlt+1;
                        Individuo in2 = new Individuo(i2.getTurnosVidaInd(), i2.getProbClonacion(),i2.getProbReproduccion(),NumeroIdIndUlt, i2.getTipo());
                        tab[j][i].addIndiv(in2);
                        listaIndividuos.add(in2);
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
                        NumeroIdIndUlt = NumeroIdIndUlt+1;
                        Individuo in2 = new Individuo(i3.getTurnosVidaInd(), i3.getProbClonacion(),i3.getProbReproduccion(),NumeroIdIndUlt,i3.getTipo());
                        tab[j][i].addIndiv(in2);
                        listaIndividuos.add(in2);
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
    public void repro() throws Mas3Indiv {
        for (int i=0;i<columna;i++){
            for (int j=0; j<fila;j++){
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
                                NumeroIdIndUlt = NumeroIdIndUlt+1;
                                Individuo in2 = new Individuo(i1.getTurnosVidaInd(), i1.getProbClonacion(),i1.getProbReproduccion(),NumeroIdIndUlt, i1.getTipo());
                                tab[j][i].addIndiv(in2);
                                listaIndividuos.add(in2);
                            }
                            else{
                                i1.getCola().push(new ElementoCola<>("hijo"+ i2));
                                i2.getCola().push(new ElementoCola<>("hijo"+ i2));
                                NumeroIdIndUlt = NumeroIdIndUlt+1;
                                Individuo in2 = new Individuo(i2.getTurnosVidaInd(), i2.getProbClonacion(),i2.getProbReproduccion(),NumeroIdIndUlt, i2.getTipo());
                                tab[j][i].addIndiv(in2);
                                listaIndividuos.add(in2);
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
                                    NumeroIdIndUlt = NumeroIdIndUlt+1;
                                    Individuo in2 = new Individuo(i2.getTurnosVidaInd(), i2.getProbClonacion(),i2.getProbReproduccion(),NumeroIdIndUlt, i2.getTipo());
                                    tab[j][i].addIndiv(in2);
                                    listaIndividuos.add(in2);
                                }
                                else{
                                    i2.getCola().push(new ElementoCola<>("hijo"+ i3));
                                    i3.getCola().push(new ElementoCola<>("hijo"+ i3));
                                    NumeroIdIndUlt = NumeroIdIndUlt+1;
                                    Individuo in2 = new Individuo(i3.getTurnosVidaInd(), i3.getProbClonacion(),i3.getProbReproduccion(),NumeroIdIndUlt, i2.getTipo());
                                    tab[j][i].addIndiv(in2);
                                    listaIndividuos.add(in2);
                                }
                            }
                            else if(i2.getProbReproduccion()< i1.getProbReproduccion()&& i2.getProbReproduccion()< i3.getProbReproduccion()){
                                i1.getCola().push(new ElementoCola<>("reproducción"));
                                i1.getCola().push(new ElementoCola<>("Pareja"+i3));
                                i3.getCola().push(new ElementoCola<>("reproducción"));
                                i3.getCola().push(new ElementoCola<>("Pareja"+i1));
                                if(i3.getProbReproduccion()> i1.getProbReproduccion()) {
                                    i3.getCola().push(new ElementoCola<>("hijo"+ i3));
                                    i1.getCola().push(new ElementoCola<>("hijo"+ i3));NumeroIdIndUlt = NumeroIdIndUlt+1;
                                    Individuo in2 = new Individuo(i3.getTurnosVidaInd(), i3.getProbClonacion(),i3.getProbReproduccion(),NumeroIdIndUlt, i3.getTipo());
                                    tab[j][i].addIndiv(in2);
                                    listaIndividuos.add(in2);

                                }
                                else{
                                    i1.getCola().push(new ElementoCola<>("hijo"+ i1));
                                    i3.getCola().push(new ElementoCola<>("hijo"+ i1));
                                    NumeroIdIndUlt = NumeroIdIndUlt+1;
                                    Individuo in2 = new Individuo(i1.getTurnosVidaInd(), i1.getProbClonacion(),i1.getProbReproduccion(),NumeroIdIndUlt, i1.getTipo());
                                    tab[j][i].addIndiv(in2);
                                    listaIndividuos.add(in2);
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
                                    NumeroIdIndUlt = NumeroIdIndUlt+1;
                                    Individuo in2 = new Individuo(i2.getTurnosVidaInd(), i2.getProbClonacion(),i2.getProbReproduccion(),NumeroIdIndUlt, i2.getTipo());
                                    tab[j][i].addIndiv(in2);
                                    listaIndividuos.add(in2);
                                }
                                else{
                                    i1.getCola().push(new ElementoCola<>("hijo"+ i1));
                                    i2.getCola().push(new ElementoCola<>("hijo"+ i1));
                                    NumeroIdIndUlt = NumeroIdIndUlt+1;
                                    Individuo in2 = new Individuo(i1.getTurnosVidaInd(), i1.getProbClonacion(),i1.getProbReproduccion(),NumeroIdIndUlt, i1.getTipo());
                                    tab[j][i].addIndiv(in2);
                                    listaIndividuos.add(in2);
                                }
                            }
                        }


                    }
            }
        }
    }
    private void moverIndividuoBasico(Individuo in) throws Mas3Indiv {
        int numero = (int) (Math.random() * 4) + 1;
        if (numero == 1) {//mueve hacia abajo
            Casilla c;
            for (int i=0; i<lista.getPrimero().getData().getNumeroElementos();i++){
                ListaEnlazadaCasillas<Casilla> columna = lista.getElemento(i).getData();
                for (int j=0; j< lista.getNumeroElementos(); j++){
                    ListaSimple<Individuo> lind = tab[j][i].getlIndiv();
                    for (int k=0; k!=3; k++){
                        if(Objects.equals(lind.getElemento(k).getData().getNumIdentificacion(), in.getNumIdentificacion())){
                            c = tab[j][i];
                            c.getlIndiv().del(k);
                            tab[j+1][i].addIndiv(in);
                        }
                    }
                }
            }

        }if (numero == 2) {//mueve hacia arriba
            Casilla c;
            for (int i=0; i<lista.getPrimero().getData().getNumeroElementos();i++){
                ListaEnlazadaCasillas<Casilla> columna = lista.getElemento(i).getData();
                for (int j=0; j< lista.getNumeroElementos(); j++){
                    ListaSimple<Individuo> lind = tab[j][i].getlIndiv();
                    for (int k=0; k!=3; k++){
                        if(Objects.equals(lind.getElemento(k).getData().getNumIdentificacion(), in.getNumIdentificacion())){
                            c = tab[j][i];
                            c.getlIndiv().del(k);
                            tab[j-1][i].addIndiv(in);
                        }
                    }
                }
            }

        }if (numero == 3) {//mueve hacia derecha
            Casilla c;
            for (int i=0; i<lista.getPrimero().getData().getNumeroElementos();i++){
                ListaEnlazadaCasillas<Casilla> columna = lista.getElemento(i).getData();
                for (int j=0; j< lista.getNumeroElementos(); j++){
                    ListaSimple<Individuo> lind = tab[j][i].getlIndiv();
                    for (int k=0; k!=3; k++){
                        if(Objects.equals(lind.getElemento(k).getData().getNumIdentificacion(), in.getNumIdentificacion())){
                            c = tab[j][i];
                            c.getlIndiv().del(k);
                            tab[j][i+1].addIndiv(in);
                        }
                    }
                }
            }

        }if (numero == 4) {//mueve hacia izquierda
            Casilla c;
            for (int i=0; i<lista.getPrimero().getData().getNumeroElementos();i++){
                ListaEnlazadaCasillas<Casilla> columna = lista.getElemento(i).getData();
                for (int j=0; j< lista.getNumeroElementos(); j++){
                    ListaSimple<Individuo> lind = tab[j][i].getlIndiv();
                    for (int k=0; k!=3; k++){
                        if(Objects.equals(lind.getElemento(k).getData().getNumIdentificacion(), in.getNumIdentificacion())){
                            c = tab[j][i];
                            c.getlIndiv().del(k);
                            tab[j][i-1].addIndiv(in);
                        }
                    }
                }
            }
        }
    }

    private void CrearCaminoAvanzado(Individuo in) throws ElNoEncontradoError {
        ElementoLECasillas<NodoGrafoCasillas<Casilla>> i = grafo.listaVertices.getPrimero();
        while(i.getSiguiente()!= null){
            ListaSimple<Individuo> lind = i.getData().getDato().getlIndiv();
            for(int k=0; k!=3; k++){
                if(Objects.equals(lind.getElemento(k).getData().getNumIdentificacion(), in.getNumIdentificacion())){
                    break;
                }
            }
            i = i.getSiguiente();
        }
        HashMapC<NodoGrafoCasillas<Casilla>, CaminoC<Casilla>> Di = null;
        if(i == grafo.listaVertices.getUltimo()){
            ListaSimple<Individuo> lind = i.getData().getDato().getlIndiv();
            for(int k=0; k!=3; k++){
                if(Objects.equals(lind.getElemento(k).getData().getNumIdentificacion(), in.getNumIdentificacion())){
                    Di = grafo.getDijkstra(i.getData());
                }else{
                    throw new ElNoEncontradoError("No se ha encontrado el individuo");
                }
            }
        }else{
            Di = grafo.getDijkstra(i.getData());
        }
        if(Di!= null) {
            ElementoHashMapC<NodoGrafoCasillas<Casilla>, CaminoC<Casilla>> e = Di.getPrimero();
            ElementoHashMapC<NodoGrafoCasillas<Casilla>, CaminoC<Casilla>> aUsar = null;
            double d = -300000000;
            while (e.getSiguiente() != null) {
                if(e.getCamino().getPeso()>d){
                    d = e.getCamino().getPeso();
                    aUsar = e;
                } else if (e.getCamino().getPeso()==d) {
                    assert aUsar != null;
                    if(e.getCamino().getCamino().getNumeroElementos()< aUsar.getCamino().getCamino().getNumeroElementos()){
                        d = e.getCamino().getPeso();
                        aUsar = e;
                    }
                }
                e = e.getSiguiente();
            }
            ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> Camino= grafo.getCaminoVertices(i.getData(),aUsar.getNodobuscamos());
            in.setEnMovimiento(true);
            in.setCaminoMovimiento(Camino);
        }
    }
    private void moverIndividuoAvanzado(Individuo in) throws Mas3Indiv {
        if(!in.isEnMovimiento()){
            CrearCaminoAvanzado(in);
        }
        Casilla c;
        for (int i=0; i<lista.getNumeroElementos();i++){
            for (int j=0; j< lista.getPrimero().getData().getNumeroElementos(); j++){
                ListaSimple<Individuo> lind = tab[j][i].getlIndiv();
                for (int k=0; k!=3; k++){
                    if(Objects.equals(lind.getElemento(k).getData().getNumIdentificacion(), in.getNumIdentificacion())){
                        if(in.getCaminoMovimiento().getNumeroElementos() == 1){
                            in.setEnMovimiento(false);
                            c = tab[j][i];
                            c.getlIndiv().del(k);
                            in.getCaminoMovimiento().getPrimero().getData().getDato().addIndiv(in);
                            in.getCaminoMovimiento().EliminarPrimero();
                        }else if(in.getCaminoMovimiento().getNumeroElementos() >= 1){
                            c = tab[j][i];
                            c.getlIndiv().del(k);
                            in.getCaminoMovimiento().getPrimero().getData().getDato().addIndiv(in);
                            in.getCaminoMovimiento().EliminarPrimero();
                        }
                    }
                }
            }
        }
    }
    private ListaEnlazadaCasillas<Individuo> getListaIndividuosVivos(){
        ListaEnlazadaCasillas<Individuo> l = new ListaEnlazadaCasillas<>();
        for (int i=0; i<lista.getNumeroElementos();i++){
            for (int j=0; j< lista.getPrimero().getData().getNumeroElementos(); j++){
                ListaSimple<Individuo> lind = tab[j][i].getlIndiv();
                for (int k=0; k!=3; k++){
                    l.add(lind.getElemento(k).getData());
                }
            }
        }
        return l;
    }
    private void moverNormal(Individuo in){

    }
    public void moverIndividuo(Individuo in) throws Mas3Indiv {
        ListaEnlazadaCasillas<Individuo> l = getListaIndividuosVivos();
        ElementoLECasillas<Individuo> el = l.getPrimero();
        while (el.getSiguiente()!= null){
            if(el.getData().getTipo() == 0) moverIndividuoBasico(el.getData());
            if (el.getData().getTipo() == 1);
            if(el.getData().getTipo() == 2)moverIndividuoAvanzado(el.getData());
            el = el.getSiguiente();
        }
    }
}