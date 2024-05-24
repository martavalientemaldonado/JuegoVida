package com.example.juegovida.Clases.Recursos;

public class Agua extends Recurso{
    public static double ProbAparicion;
    public static double TurnosProporciona;

    public Agua() {
    }
    public Agua(double ProApari, double TurnProp){
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
