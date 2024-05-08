package com.example.juegovida.Clases.Recursos;

public class Montaña extends Recurso{
    public static double ProbAparicion;
    public static double TurnosProporciona;

    public Montaña() {
    }

    public double getProbAparicion() {
        return ProbAparicion;
    }

    public double getTurnosProporciona() {
        return TurnosProporciona;
    }

    public static void setProbAparicion(double probAparicion) {
        ProbAparicion = probAparicion;
    }

    public static void setTurnosProporciona(double turnosProporciona) {
        TurnosProporciona = turnosProporciona;
    }
}
