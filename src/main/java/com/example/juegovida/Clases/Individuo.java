package com.example.juegovida.Clases;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.ColaInd.ColaEventosIndividuo;
import com.example.juegovida.App.Tab.GrafoCasillas.ListaEnlazadaCasillas;
import com.example.juegovida.App.Tab.GrafoCasillas.NodoGrafoCasillas;
import com.example.juegovida.App.Tab.ListaEnlazadaTablero;

public class Individuo {
    int vida;
    private Integer NumIdentificacion;
    private Integer Generacion;
    private double TurnosVidaInd;
    boolean EnMovimiento;
    ColaEventosIndividuo<String> cola;
    double ProbClonacion;
    double ProbReproduccion;
    double ProbMuerte = 1 - ProbReproduccion;
    //0 Basico, 1 Normal, 2 Avanzado
    protected int Tipo;
    ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> caminoMovimiento;

    public Individuo() {
    }

    public Individuo(double TurnosVida, double Probclonacion, double ProbRe, Integer NumIdentificacion, int tipo) {
        TurnosVidaInd = TurnosVida;
        ProbClonacion = Probclonacion;
        ProbReproduccion = ProbRe;
    }

    public Individuo(Integer NumIdentificacion, Integer Generacion) {
        this.NumIdentificacion = NumIdentificacion;
    }

    public Individuo(Integer NumIdentificacion, int tipo) {
        this.NumIdentificacion = NumIdentificacion;
    }

    public boolean isEnMovimiento() {
        return EnMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        EnMovimiento = enMovimiento;
    }

    public ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> getCaminoMovimiento() {
        return caminoMovimiento;
    }

    public void setCaminoMovimiento(ListaEnlazadaCasillas<NodoGrafoCasillas<Casilla>> caminoMovimiento) {
        this.caminoMovimiento = caminoMovimiento;
    }

    public ColaEventosIndividuo<String> getCola() {
        return this.cola;
    }

    public Integer getNumIdentificacion() {
        return NumIdentificacion;
    }

    public Integer getGeneracion() {
        return Generacion;
    }

    public void setNumIdentificacion(Integer numIdentificacion) {
        NumIdentificacion = numIdentificacion;
    }

    public void setGeneracion(Integer generacion) {
        Generacion = generacion;
    }

    public void setTurnosVidaInd(double turnosVidaInd) {
        TurnosVidaInd = turnosVidaInd;
    }

    public double getTurnosVidaInd() {
        return TurnosVidaInd;
    }

    public double getProbClonacion() {
        return ProbClonacion;
    }

    public void setProbClonacion(double probClonacion) {
        ProbClonacion = probClonacion;
    }

    public void setProbReproduccion(double probReproduccion) {
        ProbReproduccion = probReproduccion;
    }

    public double getProbReproduccion() {
        return ProbReproduccion;
    }

    public double getProbMuerte() {
        return ProbMuerte;
    }

    public void setProbMuerte(double probMuerte) {
        ProbMuerte = probMuerte;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        Tipo = tipo;
    }

    public void rutaAleatoriaTBasico() {
        int numero = (int) (Math.random() * 4) + 1;
        if (numero == 1) {}

    }
    // public ParamRecursosRecurso seleccionarRrecursoTAvanzado(){
    // }
    // private Recurso recursoCercanoTAvanzado(){}
    public void rutarecursoTAvanzado() {

    }
    //Normal
    public void recursoaleatorioTNormal() {

    }
    private void rutalinearectaTNormal() {
    }
}
