package com.example.juegovida.Clases.Individuos;

public abstract class Individuo {
    private Integer NumIdentificacion;
    private Integer Generacion;

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

    public abstract void Reproduccion();
    public abstract void Clonacion();
    public abstract void Muerte();
}
