package com.example.juegovida.Clases.Recursos;

public class Recurso {
    public static double ProbabilidadNuevoRE;
    public double TurnosVidaRecursos;

    public Recurso() {
    }
    public Recurso(double ProbNuevo, double TurnVida) {
        ProbabilidadNuevoRE = ProbNuevo;
        TurnosVidaRecursos = TurnVida;
    }

    public static double getProbabilidadNuevoRE() {
        return ProbabilidadNuevoRE;
    }

    public static void setProbabilidadNuevoRE(double probabilidadNuevoRE) {
        ProbabilidadNuevoRE = probabilidadNuevoRE;
    }

    public double getTurnosVidaRecursos() {
        return TurnosVidaRecursos;
    }

    public void setTurnosVidaRecursos(double turnosVidaRecursos) {
        TurnosVidaRecursos = turnosVidaRecursos;
    }
}
