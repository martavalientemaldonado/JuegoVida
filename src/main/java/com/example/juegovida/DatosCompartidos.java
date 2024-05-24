package com.example.juegovida;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import javafx.beans.property.*;

public class DatosCompartidos {
    protected Agua Agua;
    protected Biblioteca Biblioteca;
    protected Comida Comida;
    protected Pozo Pozo;
    protected Tesoro Tesoro;
    protected Montaña Montaña;
    protected Individuo Individuo;
    protected Tablero Matriz;
    protected Recurso Recurso;
    public DoubleProperty TurnosPropCom = new SimpleDoubleProperty();
    public DoubleProperty TurnosPropMont = new SimpleDoubleProperty();
    public DoubleProperty TurnosPropAgua = new SimpleDoubleProperty();
    public DoubleProperty ProbReproPropTesoro = new SimpleDoubleProperty();
    public DoubleProperty ProbClonacPropBibli = new SimpleDoubleProperty();
    public DoubleProperty ProbAparicionAgua = new SimpleDoubleProperty();
    public DoubleProperty ProbAparicionComida = new SimpleDoubleProperty();
    public DoubleProperty ProbAparicionMontaña = new SimpleDoubleProperty();
    public DoubleProperty ProbAparicionTesoro = new SimpleDoubleProperty();
    public DoubleProperty ProbAparicionBiblioteca = new SimpleDoubleProperty();
    public DoubleProperty ProbAparicionPozo = new SimpleDoubleProperty();
    public DoubleProperty ProbNuevoRecurso = new SimpleDoubleProperty();
    public DoubleProperty ProbReproduccionIndiv = new SimpleDoubleProperty();
    public DoubleProperty ProbClonacionIndiv = new SimpleDoubleProperty();
    public DoubleProperty NumColumnas = new SimpleDoubleProperty();
    public DoubleProperty NumFilas = new SimpleDoubleProperty();
    public DoubleProperty TrunosVidaIndiv = new SimpleDoubleProperty();
    public DoubleProperty TurnosVidaRecursos = new SimpleDoubleProperty();

    ///QUE PROPORCIONAN LOS RECURSOS
    public void commitProporcionaRecursos(){
        Comida.setTurnosProporciona(TurnosPropCom.get());
        Montaña.setTurnosProporciona(TurnosPropMont.get());
        Agua.setTurnosProporciona(TurnosPropAgua.get());
        Tesoro.setProbReproduccionPropo(ProbReproPropTesoro.get());
        Biblioteca.setProbClonacionProp(ProbClonacPropBibli.get());
    }

    public void rollbackProporcionaRecursos(){
        TurnosPropCom.set(Comida.getTurnosProporciona());
        TurnosPropMont.set(Montaña.getTurnosProporciona());
        TurnosPropAgua.set(Agua.getTurnosProporciona());
        ProbReproPropTesoro.set(Tesoro.getProbReproduccionPropo());
        ProbClonacPropBibli.set(Biblioteca.getProbClonacionProp());
    }
    public Property<Number> TurnosPropComProperty() {
        return TurnosPropCom;
    }
    public Property<Number> TurnosPropMontProperty() {
        return TurnosPropMont;
    }
    public Property<Number> TurnosPropAguaProperty() {
        return TurnosPropAgua;
    }
    public Property<Number> ProbReproPropTesoroProperty() {
        return ProbReproPropTesoro;
    }
    public Property<Number> ProbClonacPropBibliProperty() {
        return ProbClonacPropBibli;
    }



    ///PROBABILIDAD DE APARICIÓN RECURSOS
    public void commitProbAparicionRecursos(){
        Comida.setProbAparicion(ProbAparicionAgua.get());
        Montaña.setProbAparicion(ProbAparicionMontaña.get());
        Agua.setProbAparicion(ProbAparicionAgua.get());
        Tesoro.setProbAparicion(ProbAparicionTesoro.get());
        Biblioteca.setProbAparicion(ProbAparicionBiblioteca.get());
        Pozo.setProbAparicion(ProbAparicionPozo.get());
        Recurso.setProbabilidadNuevoRE(ProbNuevoRecurso.get());
    }

    public void rollbackProbAparicionRecursos(){
        ProbAparicionComida.set(Comida.getProbAparicion());
        ProbAparicionMontaña.set(Montaña.getProbAparicion());
        ProbAparicionAgua.set(Agua.getProbAparicion());
        ProbAparicionTesoro.set(Tesoro.getProbAparicion());
        ProbAparicionBiblioteca.set(Biblioteca.getProbAparicion());
        ProbAparicionPozo.set(Pozo.getProbAparicion());
        ProbNuevoRecurso.set(Recurso.getProbabilidadNuevoRE());
    }
    public Property<Number> ProbAparicionComidaProperty() {
        return ProbAparicionComida;
    }
    public Property<Number> ProbAparicionMontañaProperty() {
        return ProbAparicionMontaña;
    }
    public Property<Number> ProbAparicionAguaProperty() {
        return ProbAparicionAgua;
    }
    public Property<Number> ProbAparicionTesoroProperty() {
        return ProbAparicionTesoro;
    }
    public Property<Number> ProbAparicionBibliotecaProperty() {
        return ProbAparicionBiblioteca;
    }
    public Property<Number> ProbAparicionPozoProperty() {
        return ProbAparicionPozo;
    }
    public Property<Number> ProbNuevoRecursoProperty() {
        return ProbNuevoRecurso;
    }


    ///PROBABILIDADES DE LOS INDIVIDUOS

    public void commitProbIndividuos(){
        Individuo.setProbClonacion(ProbClonacionIndiv.get());
        Individuo.setProbReproduccion(ProbReproduccionIndiv.get());
    }

    public void rollbackProbIndividuos(){
        ProbClonacionIndiv.set(Individuo.getProbClonacion());
        ProbReproduccionIndiv.set(Individuo.getProbReproduccion());
    }

    public Property<Number> ProbClonacionIndivProperty() {
        return ProbClonacionIndiv;
    }

    public Property<Number> ProbReproduccionIndivProperty() {
        return ProbReproduccionIndiv;
    }



    /// DIMENSIONES Y TURNOS DE VIDA DE RECURSOS Y INDIVIDUOS
    public void commitDimyVida(){
        Matriz.setColumna(NumColumnas.get());
        Matriz.setFila(NumFilas.get());
        Individuo.setTurnosVidaInd(TrunosVidaIndiv.get());
        Recurso.setTurnosVidaRecursos(TurnosVidaRecursos.get());
    }

    public void rollbackDimyVida(){
        NumColumnas.set(Matriz.getColumna());
        NumFilas.set(Matriz.getFila());
        TrunosVidaIndiv.set(Individuo.getTurnosVidaInd());
        TurnosVidaRecursos.set(Recurso.getTurnosVidaRecursos());
    }
    public Property<Number> NumColumnasProperty() {
        return NumColumnas;
    }

    public Property<Number> NumFilasProperty() {
        return NumFilas;
    }

    public Property<Number> TrunosVidaIndivProperty() {
        return TrunosVidaIndiv;
    }
    public Property<Number> TurnosVidaRecursosProperty() {
        return TurnosVidaRecursos;
    }

    public void commitTabParamCasilla(){
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

    public void rollbackTabParamCasilla(){
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
    public Agua getAgua(){
        return Agua;
    }
    public Biblioteca getBiblioteca(){
        return Biblioteca;
    }
    public Comida getComida(){
        return Comida;
    }
    public Pozo getPozo(){
        return Pozo;
    }
    public Tesoro getTesoro(){
        return Tesoro;
    }
    public Montaña getMontaña(){return Montaña;}
    public Individuo getIndividuo(){return Individuo;}
    public Recurso getRecurso(){return Recurso;}
    public Tablero getMatriz(){
        return Matriz;
    }
    public void setAgua(Agua agua){
        this.Agua = agua;
        ProbAparicionAgua.set(Agua.getProbAparicion());
        TurnosPropAgua.set(Agua.getTurnosProporciona());
    }
    public void setComida(Comida comida){
        this.Comida = comida;
        TurnosPropCom.set((int) Comida.getTurnosProporciona());
        ProbAparicionComida.set(Comida.getProbAparicion());
    }
    public void setBiblioteca(Biblioteca biblioteca){
        this.Biblioteca = biblioteca;
        ProbAparicionBiblioteca.set(Biblioteca.getProbAparicion());
        ProbClonacPropBibli.set(Biblioteca.getProbClonacionProp());
    }
    public void setPozo(Pozo pozo){
        this.Pozo = pozo;
    }
    public void setTesoro(Tesoro tesoro){
        this.Tesoro = tesoro;
        ProbReproPropTesoro.set(Tesoro.getProbReproduccionPropo());
        ProbAparicionTesoro.set(Tesoro.getProbAparicion());
    }
    public void setMontaña(Montaña montaña){
        this.Montaña= montaña;
        TurnosPropMont.set(Montaña.getTurnosProporciona());
        ProbAparicionMontaña.set(Montaña.getProbAparicion());
    }
    public void setIndividuo(Individuo individuo){
        this.Individuo = individuo;
        rollbackProbIndividuos(); //Se inicializan los properties.
    }
    public void setRecurso(Recurso recurso){
        this.Recurso = recurso;
        ProbNuevoRecurso.set(Recurso.getProbabilidadNuevoRE());
        TurnosVidaRecursos.set(Recurso.getTurnosVidaRecursos());
    }
    public void setMatriz(Tablero matriz){
        this.Matriz = matriz;
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