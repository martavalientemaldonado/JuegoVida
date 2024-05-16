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
    private double fila;
    private double columna;
    private ListaEnlazadaTablero<ListaEnlazadaTablero<Casilla>> matiz;
    private  Casilla tab[][];


    public Tablero(int fila,int columna) {
        this.tab = new Casilla[fila][columna];
        for (int i = 0; i < fila; i++) {
            ListaEnlazadaTablero<Casilla> l = new ListaEnlazadaTablero<>();
            for (int j = 0; j < columna; j++) {
                Casilla a = new Casilla(i,j);
                l.add(a);
                this.tab[i][j] =a;
            }
            matiz.add(l);
        }
    }

    public double getFila() {
        return fila;
    }

    public double getColumna() {
        return columna;
    }

    public Casilla[][] getTab() {
        return tab;
    }

    public void setFila(double fila) {
        this.fila = fila;
    }

    public void setColumna(double columna) {
        this.columna = columna;
    }

    public void setTab(Casilla[][] tab) {
        this.tab = tab;
    }
}
