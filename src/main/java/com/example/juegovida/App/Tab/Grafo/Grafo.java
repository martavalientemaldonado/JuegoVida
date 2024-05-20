package com.example.juegovida.App.Tab.Grafo;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Errores.ElNoEncontradoError;
import com.example.juegovida.Errores.ElRepetidoError;

public class Grafo<TipodeDato> {
    public NodoGrafo<Individuo> primero;
    public NodoGrafo<Individuo> ultimo;

    public Grafo() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean grafoVacio() {
        return primero == null;
    }

    public boolean existeVertice(Individuo dato) {
        boolean existe = false;
        if (!grafoVacio()) {
            NodoGrafo<Individuo> temporal = primero;
            while (temporal != null && !existe) {
                if (temporal.dato.equals((dato))) {
                    existe = true;
                }
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }

    public void NuevaArista(NodoGrafo<Individuo> origen, NodoGrafo<Individuo> destino) throws ElRepetidoError {
        if (existeVertice(origen.dato) && existeVertice(destino.dato)) {
            origen.lista.nuevaAdyacencia(origen, destino);
        } else {
            throw new ElRepetidoError("La arista ya se encuentra en el grafo.");
        }
    }

    public void NuevaArista(NodoGrafo<Individuo> origen, NodoGrafo<Individuo> destino, double peso) throws ElRepetidoError {
        if (existeVertice(origen.dato) && existeVertice(destino.dato)) {
            origen.lista.nuevaAdyacencia(origen, destino, peso);
        } else {
            throw new ElRepetidoError("La arista ya se encuentra en el grafo.");
        }
    }

    public void nuevoNodo(Individuo dato) throws ElRepetidoError {
        if (!existeVertice(dato)) {
            NodoGrafo<Individuo> nodo = new NodoGrafo<>(dato);
            if (grafoVacio()) {
                primero = nodo;
                ultimo = nodo;
            } else {
                ultimo.siguiente = nodo;
                ultimo = nodo;
            }
        } else throw new ElRepetidoError("Ya existe.");
    }
    public HashMap<NodoGrafo<Individuo>, Camino<Individuo>> getDijkstra(NodoGrafo<Individuo> v) throws ElNoEncontradoError{
        HashMap<NodoGrafo<Individuo>, Double> distancias = new HashMap<NodoGrafo<Individuo>, Double>();
        ListaEnlazada<NodoGrafo<Individuo>> colaPendientes = new ListaEnlazada<NodoGrafo<Individuo>>();
        HashMap<NodoGrafo<Individuo>, NodoGrafo<Individuo>> verticesAnteriores = new HashMap<NodoGrafo<Individuo>, NodoGrafo<Individuo>>();

        this.dijkstra_init(v, distancias,colaPendientes, verticesAnteriores);
        this.dijkstra_calcula(distancias,colaPendientes, verticesAnteriores);
        return this.dijkstra_procesaResultados(distancias, verticesAnteriores);
    }
    private void dijkstra_init(NodoGrafo<Individuo> origen, HashMap<NodoGrafo<Individuo>, Double> distancias, ListaEnlazada<NodoGrafo<Individuo>> colaPendientes, HashMap<NodoGrafo<Individuo>, NodoGrafo<Individuo>> verticesAnteriores){
        NodoGrafo<Individuo> elem = primero;
        while (elem.siguiente != null) {
            distancias.put(elem, Double.MAX_VALUE);
            elem = elem.siguiente;
        }
        if(ultimo!= null){
            distancias.put(ultimo, Double.MAX_VALUE);
        }
        distancias.put(origen, 0.0);
        colaPendientes.add(origen);
    }
    private void dijkstra_calcula(HashMap<NodoGrafo<Individuo>, Double> distancias, ListaEnlazada<NodoGrafo<Individuo>> colaPendientes, HashMap<NodoGrafo<Individuo>, NodoGrafo<Individuo>> verticesAnteriores){
        while (!colaPendientes.isVacia()) {
            NodoGrafo<Individuo> verticeActual = colaPendientes.getUltimo().getData();  // Sacamos un vértice de la cola
            colaPendientes.del(colaPendientes.getNumeroElementos()-1);
            ListaAdyacencia<Individuo> l = verticeActual.getLista();
            AristasGrafo<Individuo> a = l.primero;
            while (a != null) {
                NodoGrafo<Individuo> verticedestino = a.getDestino();
                double nuevoCalculoDeDistancia1 = distancias.get(verticeActual) + a.getPeso();
                if (nuevoCalculoDeDistancia1 < distancias.get(verticedestino)) {
                    distancias.put(verticedestino, nuevoCalculoDeDistancia1);
                    verticesAnteriores.put(verticedestino, verticeActual);
                    colaPendientes.add(verticedestino);
                }
                a = a.siguiente;
            }
        }
    }
    private HashMap<NodoGrafo<Individuo>, Camino<Individuo>> dijkstra_procesaResultados(HashMap<NodoGrafo<Individuo>, Double> distancias, HashMap<NodoGrafo<Individuo>, NodoGrafo<Individuo>> verticesAnteriores){
        HashMap<NodoGrafo<Individuo>, Camino<Individuo>> caminos = new HashMap<NodoGrafo<Individuo>, Camino<Individuo>>();
        ListaEnlazada<NodoGrafo<Individuo>> listaVertices = verticesAnteriores.KeySet();
        for (int i = 0; listaVertices.getElemento(i) != null; i++){
            NodoGrafo<Individuo> verticeDestino = listaVertices.getElemento(i).getData();
            ListaEnlazada<NodoGrafo<Individuo>> caminoCalculado = new ListaEnlazada<NodoGrafo<Individuo>>();
            NodoGrafo<Individuo> v = verticeDestino;
            while (v != null) {
                caminoCalculado.add(v);
                v = verticesAnteriores.get(v);
            }
            ListaEnlazada<NodoGrafo<Individuo>> listaordenada = caminoCalculado.reverse(caminoCalculado);
            caminos.put(verticeDestino,new Camino<Individuo>(listaordenada,distancias.get(verticeDestino)));
        }
        return caminos;
    }
}
