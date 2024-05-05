package Clases.Recursos;

public class Comida {
    double ProbAparicion;
    Integer TurnosProporciona;

    public Comida() {
    }

    public double getProbAparicion() {
        return ProbAparicion;
    }

    public void setProbAparicion(double probAparicion) {
        this.ProbAparicion = probAparicion;
    }

    public Integer getTurnosProporciona() {
        return TurnosProporciona;
    }

    public void setTurnosProporciona(Integer turnosProporciona) {
        this.TurnosProporciona = turnosProporciona;
    }
}
