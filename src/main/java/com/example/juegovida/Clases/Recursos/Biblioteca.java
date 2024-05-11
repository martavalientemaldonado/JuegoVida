package com.example.juegovida.Clases.Recursos;

public class Biblioteca extends Recurso{
    public static double ProbAparicion;
    public static double ProbClonacionProp;

    public Biblioteca() {
    }
    public Biblioteca(double ProApari, double ProbClon){
        ProbAparicion = ProApari;
        ProbClonacionProp = ProbClon;
    }

    public double getProbAparicion() {
        return ProbAparicion;
    }
    public double getProbClonacionProp() {
        return ProbClonacionProp;
    }

    public static void setProbAparicion(double probAparicion) {
        ProbAparicion = probAparicion;
    }

    public static void setProbClonacionProp(double probClonacionProp) {
        ProbClonacionProp = probClonacionProp;
    }
}
