package com.example.juegovida.App.Tab;

import com.example.juegovida.App.Tab.GrafoCasillas.GrafoTablero;
import com.example.juegovida.App.Tab.GrafoCasillas.ListaEnlazadaCasillas;
import com.example.juegovida.App.gson;

public class Tablero extends gson {

    public static double fila;
    public static double columna;
    public static ListaEnlazadaCasillas<ListaEnlazadaCasillas<Casilla>> matiz;
    protected static GrafoTablero<Casilla> grafo;
    public Casilla tab[][];

    public  ListaEnlazadaCasillas<ListaEnlazadaCasillas<Casilla>> getMatiz() {
        return matiz;
    }

    public static GrafoTablero<Casilla> getGrafo() {
        return grafo;
    }
    public  void guardar(Tablero t){

            String rutaArchivo = "Partida.json";
            guardarObjetoEnArchivo(rutaArchivo, t);

    }
    public Tablero cargar(){
        return cargarObjetoDesdeArchivo("Partida.json", Tablero.class);

    }
    public Tablero(){

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
    public Casilla getCasilla(int fila, int columna){
        return tab[fila][columna];
    }

    public static void setMatiz(ListaEnlazadaCasillas<ListaEnlazadaCasillas<Casilla>> matiz) {
        Tablero.matiz = matiz;
    }

    public static void setGrafo(GrafoTablero<Casilla> grafo) {
        Tablero.grafo = grafo;
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
