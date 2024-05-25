package com.example.juegovida;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import javafx.beans.property.*;

public class DatosCompartidos {
    protected static Agua Agua;
    protected static Biblioteca Biblioteca;
    protected static Comida Comida;
    protected static Pozo Pozo;
    protected static Tesoro Tesoro;
    protected static Montaña Montaña;
    protected static Individuo Individuo;
    protected static Tablero Matriz;
    protected static Recurso Recurso;
    public static DoubleProperty TurnosPropCom = new SimpleDoubleProperty();
    public static DoubleProperty TurnosPropMont = new SimpleDoubleProperty();
    public static DoubleProperty TurnosPropAgua = new SimpleDoubleProperty();
    public static DoubleProperty ProbReproPropTesoro = new SimpleDoubleProperty();
    public static DoubleProperty ProbClonacPropBibli = new SimpleDoubleProperty();
    public static DoubleProperty ProbAparicionAgua = new SimpleDoubleProperty();
    public static DoubleProperty ProbAparicionComida = new SimpleDoubleProperty();
    public static  DoubleProperty ProbAparicionMontaña = new SimpleDoubleProperty();
    public static DoubleProperty ProbAparicionTesoro = new SimpleDoubleProperty();
    public static DoubleProperty ProbAparicionBiblioteca = new SimpleDoubleProperty();
    public static DoubleProperty ProbAparicionPozo = new SimpleDoubleProperty();
    public static DoubleProperty ProbNuevoRecurso = new SimpleDoubleProperty();
    public static DoubleProperty ProbReproduccionIndiv = new SimpleDoubleProperty();
    public static DoubleProperty ProbClonacionIndiv = new SimpleDoubleProperty();
    public static DoubleProperty NumColumnas = new SimpleDoubleProperty();
    public static DoubleProperty NumFilas = new SimpleDoubleProperty();
    public static DoubleProperty TrunosVidaIndiv = new SimpleDoubleProperty();
    public static DoubleProperty TurnosVidaRecursos = new SimpleDoubleProperty();

    ///QUE PROPORCIONAN LOS RECURSOS
    public static void commitProporcionaRecursos(){
        Comida.setTurnosProporciona(TurnosPropCom.get());
        Montaña.setTurnosProporciona(TurnosPropMont.get());
        Agua.setTurnosProporciona(TurnosPropAgua.get());
        Tesoro.setProbReproduccionPropo(ProbReproPropTesoro.get());
        Biblioteca.setProbClonacionProp(ProbClonacPropBibli.get());
    }

    public static void rollbackProporcionaRecursos(){
        TurnosPropCom.set(Comida.getTurnosProporciona());
        TurnosPropMont.set(Montaña.getTurnosProporciona());
        TurnosPropAgua.set(Agua.getTurnosProporciona());
        ProbReproPropTesoro.set(Tesoro.getProbReproduccionPropo());
        ProbClonacPropBibli.set(Biblioteca.getProbClonacionProp());
    }
    public static Property<Number> TurnosPropComProperty() {
        return TurnosPropCom;
    }
    public static Property<Number> TurnosPropMontProperty() {
        return TurnosPropMont;
    }
    public static Property<Number> TurnosPropAguaProperty() {
        return TurnosPropAgua;
    }
    public static Property<Number> ProbReproPropTesoroProperty() {
        return ProbReproPropTesoro;
    }
    public static Property<Number> ProbClonacPropBibliProperty() {
        return ProbClonacPropBibli;
    }



    ///PROBABILIDAD DE APARICIÓN RECURSOS
    public static void commitProbAparicionRecursos(){
        Comida.setProbAparicion(ProbAparicionAgua.get());
        Montaña.setProbAparicion(ProbAparicionMontaña.get());
        Agua.setProbAparicion(ProbAparicionAgua.get());
        Tesoro.setProbAparicion(ProbAparicionTesoro.get());
        Biblioteca.setProbAparicion(ProbAparicionBiblioteca.get());
        Pozo.setProbAparicion(ProbAparicionPozo.get());
        Recurso.setProbabilidadNuevoRE(ProbNuevoRecurso.get());
    }

    public static void rollbackProbAparicionRecursos(){
        ProbAparicionComida.set(Comida.getProbAparicion());
        ProbAparicionMontaña.set(Montaña.getProbAparicion());
        ProbAparicionAgua.set(Agua.getProbAparicion());
        ProbAparicionTesoro.set(Tesoro.getProbAparicion());
        ProbAparicionBiblioteca.set(Biblioteca.getProbAparicion());
        ProbAparicionPozo.set(Pozo.getProbAparicion());
        ProbNuevoRecurso.set(Recurso.getProbabilidadNuevoRE());
    }
    public static Property<Number> ProbAparicionComidaProperty() {
        return ProbAparicionComida;
    }
    public static Property<Number> ProbAparicionMontañaProperty() {
        return ProbAparicionMontaña;
    }
    public static Property<Number> ProbAparicionAguaProperty() {
        return ProbAparicionAgua;
    }
    public static Property<Number> ProbAparicionTesoroProperty() {
        return ProbAparicionTesoro;
    }
    public static Property<Number> ProbAparicionBibliotecaProperty() {
        return ProbAparicionBiblioteca;
    }
    public static Property<Number> ProbAparicionPozoProperty() {
        return ProbAparicionPozo;
    }
    public static Property<Number> ProbNuevoRecursoProperty() {
        return ProbNuevoRecurso;
    }


    ///PROBABILIDADES DE LOS INDIVIDUOS

    public static void commitProbIndividuos(){
        Individuo.setProbClonacion(ProbClonacionIndiv.get());
        Individuo.setProbReproduccion(ProbReproduccionIndiv.get());
    }

    public static void rollbackProbIndividuos(){
        ProbClonacionIndiv.set(Individuo.getProbClonacion());
        ProbReproduccionIndiv.set(Individuo.getProbReproduccion());
    }

    public static Property<Number> ProbClonacionIndivProperty() {
        return ProbClonacionIndiv;
    }

    public static Property<Number> ProbReproduccionIndivProperty() {
        return ProbReproduccionIndiv;
    }



    /// DIMENSIONES Y TURNOS DE VIDA DE RECURSOS Y INDIVIDUOS
    public static void commitDimyVida(){
        Matriz.setColumna(NumColumnas.get());
        Matriz.setFila(NumFilas.get());
        Individuo.setTurnosVidaInd(TrunosVidaIndiv.get());
        Recurso.setTurnosVidaRecursos(TurnosVidaRecursos.get());
    }

    public static void rollbackDimyVida(){
        NumColumnas.set(Matriz.getColumna());
        NumFilas.set(Matriz.getFila());
        TrunosVidaIndiv.set(Individuo.getTurnosVidaInd());
        TurnosVidaRecursos.set(Recurso.getTurnosVidaRecursos());
    }
    public static Property<Number> NumColumnasProperty() {
        return NumColumnas;
    }

    public static Property<Number> NumFilasProperty() {
        return NumFilas;
    }

    public static Property<Number> TrunosVidaIndivProperty() {
        return TrunosVidaIndiv;
    }
    public static Property<Number> TurnosVidaRecursosProperty() {
        return TurnosVidaRecursos;
    }

    public static void commitTabParamCasilla(){
        Comida.setProbAparicion(ProbAparicionAgua.get());
        Montaña.setProbAparicion(ProbAparicionMontaña.get());
        Agua.setProbAparicion(ProbAparicionAgua.get());
        Tesoro.setProbAparicion(ProbAparicionTesoro.get());
        Biblioteca.setProbAparicion(ProbAparicionBiblioteca.get());
        Pozo.setProbAparicion(ProbAparicionPozo.get());
        Recurso.setProbabilidadNuevoRE(ProbNuevoRecurso.get());
        Comida.setTurnosProporciona(TurnosPropCom.get());
        Montaña.setTurnosProporciona(TurnosPropMont.get());
        Agua.setTurnosProporciona(TurnosPropAgua.get());
        Tesoro.setProbReproduccionPropo(ProbReproPropTesoro.get());
        Biblioteca.setProbClonacionProp(ProbClonacPropBibli.get());
        Individuo.setProbClonacion(ProbClonacionIndiv.get());
        Individuo.setProbReproduccion(ProbReproduccionIndiv.get());
        Matriz.setColumna(NumColumnas.get());
        Matriz.setFila(NumFilas.get());
        Individuo.setTurnosVidaInd(TrunosVidaIndiv.get());
        Recurso.setTurnosVidaRecursos(TurnosVidaRecursos.get());
    }

    public static void rollbackTabParamCasilla(){
        ProbAparicionComida.set(Comida.getProbAparicion());
        ProbAparicionMontaña.set(Montaña.getProbAparicion());
        ProbAparicionAgua.set(Agua.getProbAparicion());
        ProbAparicionTesoro.set(Tesoro.getProbAparicion());
        ProbAparicionBiblioteca.set(Biblioteca.getProbAparicion());
        ProbAparicionPozo.set(Pozo.getProbAparicion());
        ProbNuevoRecurso.set(Recurso.getProbabilidadNuevoRE());
        TurnosPropCom.set(Comida.getTurnosProporciona());
        TurnosPropMont.set(Montaña.getTurnosProporciona());
        TurnosPropAgua.set(Agua.getTurnosProporciona());
        ProbReproPropTesoro.set(Tesoro.getProbReproduccionPropo());
        ProbClonacPropBibli.set(Biblioteca.getProbClonacionProp());
        ProbClonacionIndiv.set(Individuo.getProbClonacion());
        ProbReproduccionIndiv.set(Individuo.getProbReproduccion());
        NumColumnas.set(Matriz.getColumna());
        NumFilas.set(Matriz.getFila());
        TrunosVidaIndiv.set(Individuo.getTurnosVidaInd());
        TurnosVidaRecursos.set(Recurso.getTurnosVidaRecursos());
    }
    public static Agua getAgua(){
        return Agua;
    }
    public static Biblioteca getBiblioteca(){
        return Biblioteca;
    }
    public static Comida getComida(){
        return Comida;
    }
    public static Pozo getPozo(){
        return Pozo;
    }
    public static Tesoro getTesoro(){
        return Tesoro;
    }
    public static Montaña getMontaña(){return Montaña;}
    public static Individuo getIndividuo(){return Individuo;}
    public static Recurso getRecurso(){return Recurso;}
    public static Tablero getMatriz(){
        return Matriz;
    }
    public static void setAgua(Agua agua){
        Agua = agua;
        ProbAparicionAgua.set(Agua.getProbAparicion());
        TurnosPropAgua.set(Agua.getTurnosProporciona());
    }
    public static void setComida(Comida comida){
        Comida = comida;
        TurnosPropCom.set((int) Comida.getTurnosProporciona());
        ProbAparicionComida.set(Comida.getProbAparicion());
    }
    public static void setBiblioteca(Biblioteca biblioteca){
        Biblioteca = biblioteca;
        ProbAparicionBiblioteca.set(Biblioteca.getProbAparicion());
        ProbClonacPropBibli.set(Biblioteca.getProbClonacionProp());
    }
    public static void setPozo(Pozo pozo){
        Pozo = pozo;
    }
    public static void setTesoro(Tesoro tesoro){
        Tesoro = tesoro;
        ProbReproPropTesoro.set(Tesoro.getProbReproduccionPropo());
        ProbAparicionTesoro.set(Tesoro.getProbAparicion());
    }
    public static void setMontaña(Montaña montaña){
        Montaña= montaña;
        TurnosPropMont.set(Montaña.getTurnosProporciona());
        ProbAparicionMontaña.set(Montaña.getProbAparicion());
    }
    public static void setIndividuo(Individuo individuo){
        Individuo = individuo;
        rollbackProbIndividuos(); //Se inicializan los properties.
    }
    public static void setRecurso(Recurso recurso){
        Recurso = recurso;
        ProbNuevoRecurso.set(Recurso.getProbabilidadNuevoRE());
        TurnosVidaRecursos.set(Recurso.getTurnosVidaRecursos());
    }
    public static void setMatriz(Tablero matriz){
        Matriz = matriz;
        NumColumnas.set(Matriz.getColumna());
        NumFilas.set(Matriz.getFila());
    }
    public DatosCompartidos(Agua a, Comida c, Biblioteca b, Tesoro t, Montaña m, Pozo p){
        setAgua(a);
        setTesoro(t);
        setBiblioteca(b);
        setComida(c);
        setMontaña(m);
        setPozo(p);
    }
    public DatosCompartidos(Agua a, Comida c, Biblioteca b, Tesoro t, Montaña m, Pozo p, Recurso r){
        setAgua(a);
        setTesoro(t);
        setBiblioteca(b);
        setComida(c);
        setMontaña(m);
        setPozo(p);
        setRecurso(r);
    }
    public DatosCompartidos(Individuo i){setIndividuo(i);}
    public DatosCompartidos(Tablero m, Individuo i, Recurso r){
        setMatriz(m);
        setIndividuo(i);
        setRecurso(r);
    }
    public DatosCompartidos(Agua a, Comida c, Biblioteca b, Tesoro t, Montaña m, Pozo p, Tablero tab, Individuo i, Recurso r){
        setAgua(a);
        setTesoro(t);
        setBiblioteca(b);
        setComida(c);
        setMontaña(m);
        setPozo(p);
        setMatriz(tab);
        setIndividuo(i);
        setRecurso(r);
    }
}