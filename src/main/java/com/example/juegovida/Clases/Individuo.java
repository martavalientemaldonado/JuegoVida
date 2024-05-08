package com.example.juegovida.Clases;

public abstract class Individuo {
    private Integer NumIdentificacion;
    private Integer Generacion;
    private static double TurnosVidaInd;
    double ProbClonacion;
    double ProbReproduccion;
    double ProbMuerte;
    //0 Basico, 1 Normal, 2 Avanzado
    protected int Tipo;

    public Individuo() {
    }
    public Individuo(Integer NumIdentificacion, Integer Generacion){
        this.NumIdentificacion = NumIdentificacion;
        this.Generacion = Generacion;
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

    public static void setTurnosVidaInd(double turnosVidaInd) {
        TurnosVidaInd = turnosVidaInd;
    }
    public static double getTurnosVidaInd() {
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
    //public ParamRecursosRecurso seleccionarRrecursoTAvanzado(){
    // }
    // private Recurso recursoCercanoTAvanzado(){}
    public void rutarecursoTAvanzado(){

    }

    //Normal
    public void recursoaleatorioTNormal(){

    }
    private void rutalinearectaTNormal(){}
}
