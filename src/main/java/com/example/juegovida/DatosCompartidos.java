package com.example.juegovida;

import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DatosCompartidos {
    protected Agua Agua;
    protected Biblioteca Biblioteca;
    protected Comida Comida;
    protected Pozo Pozo;
    protected Tesoro Tesoro;
    protected Montaña Montaña;
    protected Individuo Individuo;
    private IntegerProperty velocidad = new SimpleIntegerProperty();
    private IntegerProperty vida = new SimpleIntegerProperty();
    private StringProperty nombre = new SimpleStringProperty();

}
