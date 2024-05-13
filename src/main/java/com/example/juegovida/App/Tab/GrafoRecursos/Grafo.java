package com.example.juegovida.App.Tab.GrafoRecursos;
import com.example.juegovida.Clases.Recursos.Recurso;
import com.example.juegovida.Errores.ElNoEncontradoError;
import com.example.juegovida.Errores.ElRepetidoError;

public class Grafo<TipodeDato> {
    public NodoGrafo<Recurso> primero;
    public NodoGrafo<Recurso> ultimo;

    public Grafo() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean grafoVacio() {
        return primero == null;
    }

    public boolean existeVertice(Recurso dato) {
        boolean existe = false;
        if (!grafoVacio()) {
            NodoGrafo<Recurso> temporal = primero;
            while (temporal != null && !existe) {
                if (temporal.dato.equals((dato))) {
                    existe = true;
                }
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }

    public void NuevaArista(NodoGrafo<Recurso> origen, NodoGrafo<Recurso> destino) throws ElRepetidoError {
        if (existeVertice(origen.dato) && existeVertice(destino.dato)) {
            origen.lista.nuevaAdyacencia(origen, destino);
        } else {
            throw new ElRepetidoError("La arista ya se encuentra en el grafo.");
        }
    }

    public void NuevaArista(NodoGrafo<Recurso> origen, NodoGrafo<Recurso> destino, double peso) throws ElRepetidoError {
        if (existeVertice(origen.dato) && existeVertice(destino.dato)) {
            origen.lista.nuevaAdyacencia(origen, destino, peso);
        } else {
            throw new ElRepetidoError("La arista ya se encuentra en el grafo.");
        }
    }

    public void nuevoNodo(Recurso dato) throws ElRepetidoError {
        if (!existeVertice(dato)) {
            NodoGrafo<Recurso> nodo = new NodoGrafo<>(dato);
            if (grafoVacio()) {
                primero = nodo;
                ultimo = nodo;
            } else {
                ultimo.siguiente = nodo;
                ultimo = nodo;
            }
        } else throw new ElRepetidoError("Ya existe.");
    }
    public HashMap<NodoGrafo<Recurso>, Camino<Recurso>> getDijkstra(NodoGrafo<Recurso> v) throws ElNoEncontradoError{
        HashMap<NodoGrafo<Recurso>, Double> distancias = new HashMap<NodoGrafo<Recurso>, Double>();
        ListaEnlazada<NodoGrafo<Recurso>> colaPendientes = new ListaEnlazada<NodoGrafo<Recurso>>();
        HashMap<NodoGrafo<Recurso>, NodoGrafo<Recurso>> verticesAnteriores = new HashMap<NodoGrafo<Recurso>, NodoGrafo<Recurso>>();

        this.dijkstra_init(v, distancias,colaPendientes, verticesAnteriores);
        this.dijkstra_calcula(distancias,colaPendientes, verticesAnteriores);
        return this.dijkstra_procesaResultados(distancias, verticesAnteriores);
    }
    protected void dijkstra_init(NodoGrafo<Recurso> origen, HashMap<NodoGrafo<Recurso>, Double> distancias, ListaEnlazada<NodoGrafo<Recurso>> colaPendientes, HashMap<NodoGrafo<Recurso>, NodoGrafo<Recurso>> verticesAnteriores){
        NodoGrafo<Recurso> elem = primero;
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
    protected void dijkstra_calcula(HashMap<NodoGrafo<Recurso>, Double> distancias, ListaEnlazada<NodoGrafo<Recurso>> colaPendientes, HashMap<NodoGrafo<Recurso>, NodoGrafo<Recurso>> verticesAnteriores){
        while (!colaPendientes.isVacia()) {
            NodoGrafo<Recurso> verticeActual = colaPendientes.getUltimo().getData();  // Sacamos un vértice de la cola
            colaPendientes.del(colaPendientes.getNumeroElementos()-1);
            ListaAdyacencia<Recurso> l = verticeActual.getLista();
            AristasGrafo<Recurso> a = l.primero;
            while (a != null) {
                NodoGrafo<Recurso> verticedestino = a.getDestino();
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
    protected HashMap<NodoGrafo<Recurso>, Camino<Recurso>> dijkstra_procesaResultados(HashMap<NodoGrafo<Recurso>, Double> distancias, HashMap<NodoGrafo<Recurso>, NodoGrafo<Recurso>> verticesAnteriores){
        HashMap<NodoGrafo<Recurso>, Camino<Recurso>> caminos = new HashMap<NodoGrafo<Recurso>, Camino<Recurso>>();
        ListaEnlazada<NodoGrafo<Recurso>> listaVertices = verticesAnteriores.KeySet();
        for (int i = 0; listaVertices.getElemento(i) != null; i++){
            NodoGrafo<Recurso> verticeDestino = listaVertices.getElemento(i).getData();
            ListaEnlazada<NodoGrafo<Recurso>> caminoCalculado = new ListaEnlazada<NodoGrafo<Recurso>>();
            NodoGrafo<Recurso> v = verticeDestino;
            while (v != null) {
                caminoCalculado.add(v);
                v = verticesAnteriores.get(v);
            }
            ListaEnlazada<NodoGrafo<Recurso>> listaordenada = caminoCalculado.reverse(caminoCalculado);
            caminos.put(verticeDestino,new Camino<Recurso>(listaordenada,distancias.get(verticeDestino)));
        }
        return caminos;
    }
}
