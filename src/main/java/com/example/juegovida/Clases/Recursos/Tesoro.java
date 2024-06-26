package com.example.juegovida.Clases.Recursos;

public class Tesoro extends Recurso {
    public static double ProbAparicion;
    public static double ProbReproduccionPropo;

    public Tesoro() {
    }
    public Tesoro(double ProbA, double ProbRe) {
        ProbAparicion = ProbA;
        ProbReproduccionPropo = ProbRe;
    }

    public double getProbAparicion() {
        return ProbAparicion;
    }

    public static double getProbReproduccionPropo() {
        return ProbReproduccionPropo;
    }

    public static void setProbAparicion(double probAparicion) {
        ProbAparicion = probAparicion;
    }

    public static void setProbReproduccionPropo(double probReproduccionPropo) {
        ProbReproduccionPropo = probReproduccionPropo;
    }
}
