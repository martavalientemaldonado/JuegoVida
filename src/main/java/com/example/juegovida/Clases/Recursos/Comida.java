package com.example.juegovida.Clases.Recursos;

public class Comida extends Recurso{
    public static double ProbAparicion;
    public static double TurnosProporciona;

    public Comida() {
    }
    public Comida(double ProApari, double TurnProp){
        ProbAparicion = ProApari;
        TurnosProporciona = TurnProp;
    }

    public double getProbAparicion() {
        return ProbAparicion;
    }

    public static double getTurnosProporciona() {
        return TurnosProporciona;
    }

    public static void setProbAparicion(double probAparicion) {
        ProbAparicion = probAparicion;
    }

    public static void setTurnosProporciona(double turnosProporciona) {
        TurnosProporciona = turnosProporciona;
    }
}
