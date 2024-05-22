package com.example.juegovida.App.Tab.GrafoCasillas;

import com.example.juegovida.Errores.ElNoEncontradoError;
import com.example.juegovida.Errores.ElRepetidoError;

public class GrafoTablero<TipodeDato> {
    public ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> listaVertices;
    ListaEnlazadaCasillas<AristasGrafoCasillas<TipodeDato>> listaAristas;
    public GrafoTablero(ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> ListaVertices, ListaEnlazadaCasillas<AristasGrafoCasillas<TipodeDato>> listaAristas){
        this.listaVertices = ListaVertices;
        this.listaAristas = listaAristas;
    }
    public boolean grafoVacio(){
        return listaAristas.isVacia() && listaVertices.isVacia();
    }
    public void addNodo (NodoGrafoCasillas<TipodeDato> nodo) throws ElRepetidoError {
        if(listaVertices.isVacia()){
            listaVertices.add(nodo);
        }else{
            int contador = 0;
            while (contador<= listaVertices.getNumeroElementos()-1 && !listaVertices.getElemento(contador).getData().equals(nodo.getDato())){
                contador ++;
            }if(contador >= listaVertices.getNumeroElementos()-1 && !listaVertices.getUltimo().getData().equals(nodo.getDato())){
                listaVertices.add(nodo);
            }else{ throw new ElRepetidoError("Error, no se puede añadir un elemento ya existente.");}
        }
    }
    public void addAristas(AristasGrafoCasillas<TipodeDato> aristas) throws ElRepetidoError{
        if(listaAristas.isVacia()){
            listaAristas.add(aristas);
        }else{
            int contador = 0;
            while (contador<= listaAristas.getNumeroElementos()-1 && !listaAristas.getElemento(contador).getData().equals(aristas)){
                contador ++;
            }if(contador >= listaAristas.getNumeroElementos()-1 && !listaAristas.getUltimo().getData().equals(aristas)){
                listaAristas.add(aristas);
            }else{ throw new ElRepetidoError("Error, no se puede añadir un elemento ya existente.");}
        }if(listaVertices.isVacia()|| listaVertices.getPosicion(aristas.getOrigen())==null){
            listaVertices.add(aristas.getOrigen());
        }if (listaVertices.isVacia() || listaVertices.getPosicion(aristas.getDestino())==null){
            listaVertices.add(aristas.getDestino());
        }
        aristas.getOrigen().getSalida().add(aristas);
        aristas.getDestino().getEntrada().add(aristas);
    }
    public void borrarArista(AristasGrafoCasillas<TipodeDato> aristas) throws ElNoEncontradoError {
        if(listaAristas.isVacia() || listaAristas.getPosicion(aristas)== null){
            throw new ElNoEncontradoError("No se ha encontrado dicha arista.");
        }else{
            aristas.getOrigen().getSalida().del(aristas.getOrigen().getSalida().getPosicion(aristas));
            aristas.getDestino().getEntrada().del(aristas.getDestino().getEntrada().getPosicion(aristas));
        }
    }
    public void borrarNodo (NodoGrafoCasillas<TipodeDato> nodo) throws ElNoEncontradoError{
        if(listaVertices.isVacia() || listaVertices.getPosicion(nodo)== null){
            throw new ElNoEncontradoError("No se ha encontrado dicho vertice.");
        }else{
            while ((!nodo.getSalida().isVacia())){
                AristasGrafoCasillas<TipodeDato> aristaElim = nodo.getSalida().getElemento(0).getData();
                aristaElim.getDestino().getEntrada().del(aristaElim.getDestino().getEntrada().getPosicion(aristaElim));
                listaAristas.del(listaAristas.getPosicion(aristaElim));
                nodo.getSalida().del(nodo.getSalida().getPosicion(aristaElim));
            }
            listaVertices.del(listaVertices.getPosicion(nodo));
        }
    }

    public HashMapC<NodoGrafoCasillas<TipodeDato>, CaminoC<TipodeDato>> getDijkstra(NodoGrafoCasillas<TipodeDato> origen) throws ElNoEncontradoError{
        HashMapC<NodoGrafoCasillas<TipodeDato>,Double> distancias = new HashMapC<>();
        ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> colaPendientes = new ListaEnlazadaCasillas<>();
        HashMapC<NodoGrafoCasillas<TipodeDato>, NodoGrafoCasillas<TipodeDato>> nodosAnteriores = new HashMapC<>();

        this.dijkstra_init(origen, distancias, colaPendientes, nodosAnteriores);
        this.dijkstra_calcula(distancias,colaPendientes, nodosAnteriores);
        return this.dijkstra_procesaResultados(distancias, nodosAnteriores);
    }
    protected void dijkstra_init(NodoGrafoCasillas<TipodeDato> origen, HashMapC<NodoGrafoCasillas<TipodeDato>, Double> distancias, ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> colaPendientes, HashMapC<NodoGrafoCasillas<TipodeDato>, NodoGrafoCasillas<TipodeDato>> nodosAnteriores) {
        for (int i = 0; listaVertices.getElemento(i) != null; i ++ ){
            distancias.put(listaVertices.getElemento(i).getData(), Double.MAX_VALUE);
        }
        distancias.put(origen, 0.0);
        colaPendientes.add(origen);
    }
    protected void dijkstra_calcula(HashMapC<NodoGrafoCasillas<TipodeDato>, Double>distancias, ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> colaPendientes, HashMapC<NodoGrafoCasillas<TipodeDato>, NodoGrafoCasillas<TipodeDato>> verticesAnteriores){
        while (!colaPendientes.isVacia()) {
            NodoGrafoCasillas<TipodeDato> verticeActual = colaPendientes.getUltimo().getData();
            colaPendientes.del(colaPendientes.getNumeroElementos() -1);
            for (int i = 0; verticeActual.getSalida().getElemento(i) != null; i ++) {
                AristasGrafoCasillas<TipodeDato> arista = verticeActual.getSalida().getElemento(i).getData();
                NodoGrafoCasillas<TipodeDato> verticeVecino = arista.getDestino();
                double nuevoCalculoDistancia1 = distancias.get(verticeActual) + arista.getPeso();

                if (nuevoCalculoDistancia1 < distancias.get(verticeVecino)) {
                    distancias.put(verticeVecino, nuevoCalculoDistancia1);
                    verticesAnteriores.put(verticeVecino, verticeActual);
                    colaPendientes.insert(verticeVecino, 0);
                }
            }
        }
    }
    protected HashMapC<NodoGrafoCasillas<TipodeDato>,CaminoC<TipodeDato>> dijkstra_procesaResultados (HashMapC<NodoGrafoCasillas<TipodeDato>, Double> distancias, HashMapC<NodoGrafoCasillas<TipodeDato>, NodoGrafoCasillas<TipodeDato>> verticesAnteriores){
        HashMapC<NodoGrafoCasillas<TipodeDato>, CaminoC<TipodeDato>> caminos = new HashMapC<>();
        ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> listaVertices = verticesAnteriores.KeySet();

        for (int i =0; listaVertices.getElemento (i) != null; i++){
            NodoGrafoCasillas<TipodeDato> verticeDestino = listaVertices.getElemento(i).getData();
            ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> caminoCalculado =new ListaEnlazadaCasillas<>();
            NodoGrafoCasillas<TipodeDato> v = verticeDestino;
            while(v !=null){
                caminoCalculado.add(v);
                v = verticesAnteriores.get(v);
            }
            ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> listaOrdenada = caminoCalculado.reverse(caminoCalculado);
            caminos.put(verticeDestino, new CaminoC<>(listaOrdenada, distancias.get(verticeDestino)));
        }
        return caminos;
    }
    public ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> getCaminoVertices(NodoGrafoCasillas<TipodeDato> salida, NodoGrafoCasillas<TipodeDato> llegada) throws ElNoEncontradoError {
        if(listaVertices.getPosicion(salida) != null && listaVertices.getPosicion(llegada) != null){
            return this.getDijkstra(salida).get(llegada).getCamino();
        }
        else throw new ElNoEncontradoError("Error, algunno de los datos no están en el grafo");
    }
    public ListaEnlazadaCasillas<TipodeDato> getCamino(NodoGrafoCasillas<TipodeDato> salida, NodoGrafoCasillas<TipodeDato> llegada) throws ElNoEncontradoError{
        ListaEnlazadaCasillas<TipodeDato> camino = new ListaEnlazadaCasillas<>();
        ListaEnlazadaCasillas<NodoGrafoCasillas<TipodeDato>> caminoNodos = getCaminoVertices(salida,llegada);
        for (int i = 0; i<caminoNodos.getNumeroElementos() ;i++){
            camino.add(caminoNodos.getElemento(i).getData().getDato());
        }
        return camino;
    }
}