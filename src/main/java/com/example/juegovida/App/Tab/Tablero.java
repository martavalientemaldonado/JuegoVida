package com.example.juegovida.App.Tab;

import com.example.juegovida.App.Tab.GrafoCasillas.GrafoTablero;
import com.example.juegovida.App.Tab.GrafoCasillas.ListaEnlazadaCasillas;

public class Tablero {
    public static double fila;
    public static double columna;
    public static ListaEnlazadaCasillas<ListaEnlazadaCasillas<Casilla>> matiz;
    protected static GrafoTablero<Casilla> grafo;
    public Casilla tab[][];

    public static ListaEnlazadaCasillas<ListaEnlazadaCasillas<Casilla>> getMatiz() {
        return matiz;
    }

    public static GrafoTablero<Casilla> getGrafo() {
        return grafo;
    }

    public Tablero(int fila, int columna) {
        this.tab = new Casilla[fila][columna];
        for (int i = 0; i < fila; i++) {
            ListaEnlazadaCasillas<Casilla> l = new ListaEnlazadaCasillas<>();
            for (int j = 0; j < columna; j++) {
                Casilla a = new Casilla(i,j);
                l.add(a);
                this.tab[i][j] =a;
            }
            //matiz.add(l);
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
