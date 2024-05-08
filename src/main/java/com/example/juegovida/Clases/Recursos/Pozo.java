package com.example.juegovida.Clases.Recursos;

public class Pozo extends Recurso{
    public static double ProbAparicion;
    public static double ProbMuerteProp;
    public Pozo() {
    }

    public double getProbAparicion() {
        return ProbAparicion;
    }

    public static double getProbMuerteProp() {
        return ProbMuerteProp;
    }

    public static void setProbAparicion(double probAparicion) {
        ProbAparicion = probAparicion;
    }

    public static void setProbMuerteProp(double probMuerteProp) {
        ProbMuerteProp = probMuerteProp;
    }
}
