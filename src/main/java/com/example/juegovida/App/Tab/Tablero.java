package com.example.juegovida.App.Tab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;

public class Tablero {
    private int fila;
    private int columna;
    private  Casilla tab[][];


    public Tablero(int fila,int columna) {
        this.tab = new Casilla[fila][columna];
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Casilla[][] getTab() {
        return tab;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setTab(Casilla[][] tab) {
        this.tab = tab;
    }
}
