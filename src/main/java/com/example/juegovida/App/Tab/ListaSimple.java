package com.example.juegovida.App.Tab;

public class ListaSimple<T> {
    protected T[] list;
    protected Integer Max = 3;

    public ListaSimple() {
        //this.list = T[Max];
    }

    public boolean IsVacia() {
        if (getNumElementos() == 0) {
            System.out.println("Lista vacia");
            return true;
        }
        return false;
    }

    public void vaciar() {
        int contador = 0;
        if (getNumElementos() == 0) {
            System.out.println("La lista esta vacia.");
        } else {
            while (contador <= getNumElementos()) {
                list[contador] = null;
                contador++;
            }
        }
    }

    private int add(T el) {
        if (getNumElementos() < Max) {
            list[getNumElementos()] = el;
        } else {
            return -1;
        }
        return 0;
    }



    public int del(int position) {
        if (list[position] != null) {
            list[position] = null;
            int contador = position + 1;
            while (Max - 1 > contador) {
                list[contador - 1] = list[contador];
                contador++;
            }
            list[getNumElementos()] = null;
        }
        return getNumElementos();
    }

    public int getNumElementos() {
        int contador = 0;
        while (list[contador] != null)  {
            if (contador<Max-1){contador++;}
            else {return contador+1;}
        }
        return contador;
    }

    public int getPosicion(T el) {
        int contador = 0;
        int posicion=-1;
        while (contador < getNumElementos()) {
            if (list[contador] == el) {
                posicion=contador;
                break;
            }else{
                contador++;
            }
        }

        return posicion;
    }

    public T getPrimero() {
        return list[0];
    }

    public T getUltimo() {
        return list[getNumElementos()-1];
    }

    private T getSiguiente(T el) {
        int posicion = getPosicion(el);
        if (posicion < Max) {
            return list[posicion + 1];
        } else {
            return null;
        }
    }

    public T getElemento(int posicion) {
        if (posicion <= getNumElementos()) {
            return list[posicion];
        } else {
            return null;
        }
    }
}
