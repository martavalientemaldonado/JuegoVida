package com.example.juegovida.Clases;

public abstract class Individuo {
    private Integer NumIdentificacion;
    private Integer Generacion;
    double ProbClonacion;
    double PrpbReproduccion;
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
