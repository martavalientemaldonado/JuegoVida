package com.example.juegovida.Clases.Recursos;

public class Agua extends Recurso{
    public static double ProbAparicion;
    public static double TurnosProporciona;

    public Agua() {
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
