package com.example.juegovida.Clases;

public class Matriz<TipodeDato> {
    private static double Columnas;
    private static double Filas;
    ListaEnlazada<ListaEnlazada<TipodeDato>> casillas;

    public static double getColumnas() {
        return Columnas;
    }

    public static void setColumnas(double columnas) {
        Columnas = columnas;
    }

    public static double getFilas() {
        return Filas;
    }

    public static void setFilas(double filas) {
        Filas = filas;
    }
}
