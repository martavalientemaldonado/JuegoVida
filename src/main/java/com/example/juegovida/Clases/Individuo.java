package com.example.juegovida.Clases;

import com.example.juegovida.App.Tab.ColaInd.ColaEventosIndividuo;

public class Individuo {
    private Integer NumIdentificacion;
    private Integer Generacion;
    private double TurnosVidaInd;
    boolean EnMovimiento;
    ColaEventosIndividuo cola;
    double ProbClonacion;
    double ProbReproduccion;
    double ProbMuerte = 1-ProbReproduccion;
    //0 Basico, 1 Normal, 2 Avanzado
    protected int Tipo;
    public Individuo(){

    }

    public Individuo(double TurnosVida, double Probclonacion, double ProbRe) {
        TurnosVidaInd = TurnosVida;
        ProbClonacion = Probclonacion;
        ProbReproduccion = ProbRe;
    }
    public Individuo(Integer NumIdentificacion, Integer Generacion){
        this.NumIdentificacion = NumIdentificacion;
        this.Generacion = Generacion;
    }
    public ColaEventosIndividuo getCola(){
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



    public void Reproduccion(){

    }
    public void Clonacion(){

    }
    public void Muerte(){

    }
    //Basico
    public void rutaAleatoriaTBasico(){

    }

    //Avanzado
    // public ParamRecursosRecurso seleccionarRrecursoTAvanzado(){
    // }
    // private Recurso recursoCercanoTAvanzado(){}
    public void rutarecursoTAvanzado(){

    }

    //Normal
    public void recursoaleatorioTNormal(){

    }
    private void rutalinearectaTNormal(){}
}
