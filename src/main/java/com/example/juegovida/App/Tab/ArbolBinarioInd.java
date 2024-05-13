package com.example.juegovida.App.Tab;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Errores.ElNoEncontradoError;
import com.example.juegovida.Errores.ElRepetidoError;
public class ArbolBinarioInd {
    protected NodoInd raiz;

    public ArbolBinarioInd() {
        raiz = null;
    }

    public ArbolBinarioInd(NodoInd raiz) {
        this.raiz = raiz;
    }

    public NodoInd getRaiz() {
        return raiz; // Elemento inicial (5 Ejemplo clase)
    }

    boolean esVacio() {
        return raiz == null;
    }

    public int getGrado(){
        return getGradoRe(raiz, raiz.getGradoNodo());
    }
    protected int getGradoRe(NodoInd n, int r) {
        if (n == null) return 0;
        if (n.dcho != null || n.izdo != null) {
            if (n.getIzdo() != null) {
                if (r == n.izdo.getGradoNodo() || r > n.izdo.getGradoNodo()) {
                    getGradoRe(n.izdo, r);
                } else {
                    getGradoRe(n.izdo, n.izdo.getGradoNodo());
                }
            }
            if (n.getDcho() != null) {
                if (r == n.dcho.getGradoNodo() || r > n.dcho.getGradoNodo()) {
                    getGradoRe(n.dcho, r);
                } else {
                    getGradoRe(n.dcho, n.dcho.getGradoNodo());
                }
            }
        }
        return r;
    }

    protected int getAltura(NodoInd n, int numero) {
        int n1=0;
        int n2=0;
        if (n.getDcho() !=null){
            n2=getAltura(n.getDcho(), numero+1);

        }
        if (n.getIzdo() !=null){
            n1=getAltura(n.getIzdo(), numero +1);
        }
        if (n1>=n2&& n1>numero){
            return n1;
        } else if (n2>=n1&& n2>numero){
            return n2;
        }
        return numero;
    }

    public int getAltura() {
        return 1+ getAltura(this.raiz, 0);
    }
    public ListaEnlazadaInd getListaDatosNivel(Integer nivel){
        ListaEnlazadaInd lista2 = new ListaEnlazadaInd();
        return getListaDatosNivelRe(raiz, nivel, lista2);
    }
    protected ListaEnlazadaInd getListaDatosNivelRe(NodoInd raiz, int nivel, ListaEnlazadaInd list) {
        if (raiz == null)
            return null;
        if (nivel == 1) {
            list.add(raiz.getDato());
        } else {
            getListaDatosNivelRe(raiz.dcho, nivel - 1, list);
            getListaDatosNivelRe(raiz.izdo, nivel - 1, list);
        }
        return list;
    }
    public boolean isArbolHomogeneo(){
        boolean b = true;
        b = isArbolHomogeneoRe(raiz, b, getGrado());
        return b;
    }

    protected boolean isArbolHomogeneoRe(NodoInd ra, boolean b, Integer gra) {
        if (ra != null && b) {
            if (ra.getGradoNodo() != gra && ra.getGradoNodo() !=0) {
                if (ra.dcho!= null) {
                    return isArbolHomogeneoRe(ra.dcho, false, gra);
                }
                if (ra.izdo!= null) {
                    return isArbolHomogeneoRe(ra.izdo, false, gra);
                }
            }else {
                if (ra.dcho!= null) {
                    return isArbolHomogeneoRe(ra.dcho, true, gra);
                }
                if (ra.izdo!= null) {
                    return isArbolHomogeneoRe(ra.izdo, true, gra);
                }
            }
        } else {
            if (ra.dcho!= null) isArbolHomogeneoRe(ra.dcho, false, gra);
            if (ra.izdo!= null) isArbolHomogeneoRe(ra.izdo, false, gra);
        }
        return b;
    }

    public boolean isArbolCompleto(){
        if (raiz != null){
            if (raiz.izdo == null && raiz.dcho == null){
                return true;
            } else {
                if (getAltura(raiz.izdo, 0) == getAltura(raiz.dcho, 0)) return true;
            }
        }
        return false;
    }

    boolean aux = true;
    boolean aux2 = true;

    public boolean isArbolCasiCompleto(NodoInd n, int numero) {
        ListaEnlazadaInd lista = new ListaEnlazadaInd();

        if (n.getIzdo() == null && n.getDcho() == null) {
            lista = getCamino(n.getDato());
            int num = lista.getNumeroElementos();
            if (num == numero - 1) {
                aux = false;
            } else if (num <= numero - 1) {
                aux2 = false;
            }
            if (!aux) {
                if (num != numero - 1) {
                    aux2 = false;
                }
            }
        }
        if (n.getIzdo() != null) {
            isArbolCasiCompleto(n.getIzdo(), numero);
        }
        if (n.getDcho() != null) {
            isArbolCasiCompleto(n.getDcho(), numero);
        }
        return aux2;
    }


    protected ListaEnlazadaInd getCaminoRe(Individuo n,NodoInd raiz, ListaEnlazadaInd l) {
        Comparable c= (Comparable) n;
        l.add(raiz.getDato());
        if (c.compareTo(raiz.getDato())<0){
            getCaminoRe(n, raiz.getIzdo(), l);
        } else if (c.compareTo(raiz.getDato())>0){
            getCaminoRe(n,raiz.getDcho(),l);
        }
        return l;
    }

    public ListaEnlazadaInd getCamino(Individuo n) {
        ListaEnlazadaInd l = new ListaEnlazadaInd();
        ListaEnlazadaInd l1 = getCaminoRe(n, this.raiz,l);
        return l1;

    }


    // Recorrido de un árbol binario en preorden
    protected ListaEnlazadaInd preordenRe(NodoInd r, ListaEnlazadaInd l) {
        if (r != null) {
            l.add(raiz.getDato());
            preordenRe(r.izdo, l);
            preordenRe(r.dcho, l);
        }
        return l;
    }
    public ListaEnlazadaInd preorden(){
        ListaEnlazadaInd l = new ListaEnlazadaInd();
        ListaEnlazadaInd Lista = preordenRe(raiz, l);
        return Lista;
    }

    // Recorrido de un árbol binario en inorden
    protected ListaEnlazadaInd inordenRe(NodoInd r, ListaEnlazadaInd l) {
        if (r != null) {
            inordenRe(r.izdo, l);
            l.add(r.getDato());
            inordenRe(r.dcho, l);
        }
        return l;
    }
    public ListaEnlazadaInd inorden(){
        ListaEnlazadaInd l = new ListaEnlazadaInd();
        ListaEnlazadaInd Lista = inordenRe(raiz, l);
        return Lista;
    }

    // Recorrido de un árbol binario en postorden
    protected ListaEnlazadaInd postordenRe(NodoInd r,  ListaEnlazadaInd l) {
        if (r.izdo != null) {
            postordenRe(r.izdo, l);
        }
        if (r.dcho != null) {
            postordenRe(r.dcho,l);
        }
        l.add(r.getDato());

        return l;
    }
    public ListaEnlazadaInd postorden(){
        ListaEnlazadaInd l = new ListaEnlazadaInd();
        ListaEnlazadaInd Lista = postordenRe(raiz, l);
        return Lista;
    }

    public ArbolBinarioInd subarbolizq(){
        ArbolBinarioInd subizq= new ArbolBinarioInd(this.raiz.izdo);
        return subizq;
    }
    public ArbolBinarioInd subarboldecho(){
        ArbolBinarioInd subder= new ArbolBinarioInd(this.raiz.dcho);
        return subder;
    }
    public void añadir(Individuo o) throws ElRepetidoError {
        NodoInd el=new NodoInd(o);
        if (this.esVacio()){
            this.raiz=el;
        }else{
            raiz.añadirNodo(el);
        }
    }
    public NodoInd eliminar(Individuo valor) throws ElNoEncontradoError {
        return borrado(valor, this.raiz);
    }
    public NodoInd borrado(Individuo valor, NodoInd n) throws ElNoEncontradoError {
        if(getCamino(valor) != null){
            Comparable c = (Comparable) n.getDato();
            int result = c.compareTo(valor);
            if (result > 0) {
                NodoInd iz = borrado(valor, n.izdo);
                n.setIzdo(iz);
            } else if (result < 0) {
                NodoInd dec = borrado(valor, n.dcho);
                n.setDcho(dec);
            } else {
                NodoInd p = n;
                if (p.getDcho() == null) {
                    n = p.getIzdo();
                } else if (p.getIzdo() == null) {
                    n = p.getDcho();
                } else {
                    n = cambiar(p);
                }
                p = null;
            }
        }else{
            throw new ElNoEncontradoError("El NodoInd que se intenta borrar no se encuentra en el arbol.");
        }
        return n;
    }

    protected  NodoInd cambiar(NodoInd n){
        NodoInd p = n;
        NodoInd a = n.getIzdo();
        while (a.getDcho() != null){
            p = a;
            a = a.getDcho();
        }
        n.setDato(a.getDato());
        if (p == n){
            p.setIzdo(a.getIzdo());
        }else{
            p.setDcho((a.getIzdo()));
        }
        return a;
    }
    private NodoInd getAnterior(NodoInd raiz, NodoInd buscar) {
        if (raiz == null || buscar == null) return null;
        Comparable c= (Comparable) raiz.getDato();
        NodoInd prev = null;
        while (raiz != null && raiz.getDato()!= buscar.getDato()) {
            if (c.compareTo(buscar.dato)<0) {
                raiz = raiz.izdo;
            } else if (c.compareTo(buscar.dato)>0) {
                prev = raiz;
                raiz = raiz.dcho;
            } else {
                if (raiz.izdo != null) {
                    prev = raiz.izdo;
                    while (prev.dcho != null) {
                        prev = prev.dcho;
                    }
                }
                break;
            }
        }
        return prev;
    }

    // Función pública para obtener el nodo anterior de un nodo específico
    public NodoInd getNodoPadre(NodoInd node) {
        return getAnterior(raiz, node);
    }
    public ListaEnlazadaInd getHojas(NodoInd raiz, ListaEnlazadaInd listaHojas){
        if (raiz.izdo == null && raiz.dcho==null){
            listaHojas.add(raiz.dato);
        }
        if (raiz.izdo!=null){
            getHojas(raiz.izdo, listaHojas);
        }
        if (raiz.dcho!=null){
            getHojas(raiz.dcho, listaHojas);
        }
        return listaHojas;
    }
    public ArbolBinarioInd subarbolizqpadre(NodoInd nodoactual){
        ArbolBinarioInd arbolizq = new ArbolBinarioInd(nodoactual.izdo);
        return arbolizq;
    }
    public boolean isVacio(){
        return raiz==null;
    }

    public void rotarderecha(NodoInd y) {
        NodoInd Temporal= new NodoInd();
        Temporal.copia(y);
        NodoInd NuevaRaiz= Temporal.izdo;
        Temporal.izdo=NuevaRaiz.dcho;
        NuevaRaiz.dcho= Temporal;
        y.copia(NuevaRaiz);
    }
    public void rotarizq (NodoInd y) {
        NodoInd Temporal= new NodoInd();
        Temporal.copia(y);
        NodoInd NuevaRaiz= Temporal.dcho;
        Temporal.dcho=NuevaRaiz.izdo;
        NuevaRaiz.izdo= Temporal;
        y.copia(NuevaRaiz);
    }
    public ArbolBinarioInd subarboldecho(NodoInd nodoactual){
        ArbolBinarioInd subder= new ArbolBinarioInd(nodoactual.dcho);
        return subder;
    }
    public ArbolBinarioInd subarbolizq(NodoInd nodoactual){
        ArbolBinarioInd subizq= new ArbolBinarioInd(nodoactual.izdo);
        return subizq;
    }
    public boolean desequilibrioDcho(NodoInd n){
        int x=0;
        if(n.dcho!=null){
            x+=this.subarboldecho(n).getAltura();
        }
        if (n.izdo!=null){
            x-=this.subarbolizq(n).getAltura();
        }
        return x>1;
    }
    public boolean desequilibrioizq(NodoInd n){
        int x=0;
        if(n.dcho!=null){
            x+=this.subarboldecho(n).getAltura();
        }
        if (n.izdo!=null){
            x-=this.subarbolizq(n).getAltura();
        }
        return x<-1;
    }


    public int getEquilibrio(NodoInd a) {
        int resta = 0;
        ArbolBinarioInd arbolA = new ArbolBinarioInd();
        ArbolBinarioInd subArbolIzq = new ArbolBinarioInd();
        ArbolBinarioInd subArbolDcho = new ArbolBinarioInd();
        if (a.dcho != null) {
            subArbolDcho = arbolA.subarboldecho();
            resta -= subArbolDcho.getAltura();
        }
        if (a.izdo != null) {
            subArbolIzq = arbolA.subarbolizq();
            resta += subArbolIzq.getAltura();
        }
        if (a.dcho == null && a.izdo == null) {
            return 0;
        }
        return resta;

    }
    public NodoInd getpadre(Individuo valor){
        NodoInd padre= new NodoInd();
        return getpadre(valor,this.raiz,padre);
    }
    private NodoInd getpadre(Individuo valor,NodoInd el, NodoInd padre){
        Comparable c = (Comparable) el.dato;
        int resultado= c.compareTo(valor);
        if (resultado > 0) {
            if (el.izdo != null) {
                padre=el;
                el= el.izdo;
            }
        }
        else  if (resultado < 0) {
            if (el.dcho != null) {
                padre=el;
                el=el.dcho;
            }
        }
        if(resultado==0){
            return padre;
        }
        else {
            return getpadre(valor,el, padre);
        }
    }
    public void equilibrio() {
        ListaEnlazadaInd hojas= new ListaEnlazadaInd();
        hojas= this.getHojas(this.raiz,hojas);
        equilibrado((new NodoInd(hojas.getElemento(0).getData())),hojas,0);
    }
    private void equilibrado(NodoInd n, ListaEnlazadaInd hojas, int contador){
        if(this.getpadre(n.dato)!=null){
            while(desequilibrioDcho(this.getpadre(n.dato)) || desequilibrioizq(this.getpadre(n.dato))) {
                if (desequilibrioizq(this.getpadre( n.dato))) {
                    this.rotarderecha(this.getpadre( n.dato));
                }
                if (desequilibrioDcho(this.getpadre(n.dato))) {
                    this.rotarizq(this.getpadre(n.dato));
                }
            }
            if(n.dato!=this.raiz.dato){
                equilibrado(this.getpadre(n.dato),hojas,contador);}
        }
        else if(contador+1<hojas.getNumeroElementos()){
            hojas.del(contador);
            contador++;
            equilibrado(new NodoInd(hojas.getElemento(contador).getData()),hojas,contador);
        }
    }
}
