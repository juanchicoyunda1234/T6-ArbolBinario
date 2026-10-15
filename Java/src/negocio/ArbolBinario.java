package negocio;

import modelo.Nodo;

public class ArbolBinario<T> {

    private Nodo<T> raiz;

    public ArbolBinario() {

        this.raiz = null;
    }

    public Nodo<T> getRaiz() {

        return raiz;
    }

    public boolean esVacio() {

        return raiz == null;
    }

    public Nodo<T> crearRaiz(T dato) {

        if (raiz != null) {
            throw new IllegalStateException("El arbol ya tiene raiz: " + raiz);
        }
        raiz = new Nodo<>(dato);
        return raiz;
    }

    public Nodo<T> agregarIzquierdo(Nodo<T> padre, T dato) {

        validarPadre(padre);
        if (padre.getIzquierdo() != null) {
            throw new IllegalStateException("La posicion izquierda de " + padre + " ya esta ocupada por " + padre.getIzquierdo() + ".");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setIzquierdo(nuevo);
        return nuevo;
    }

    public Nodo<T> agregarDerecho(Nodo<T> padre, T dato) {

        validarPadre(padre);
        if (padre.getDerecho() != null) {
            throw new IllegalStateException("La posicion derecha de " + padre + " ya esta ocupada por " + padre.getDerecho() + ".");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setDerecho(nuevo);
        return nuevo;
    }

    public int contarNodos() {

        return contarNodos(raiz);
    }

    public int contarHojas() {

        return contarHojas(raiz);
    }

    private void validarPadre(Nodo<T> padre) {

        if (esVacio()) {
            throw new IllegalStateException("El arbol esta vacio: cree primero la raiz.");
        }
        if (padre == null) {
            throw new IllegalArgumentException("El nodo padre no puede ser nulo.");
        }
        if (!contiene(raiz, padre)) {
            throw new IllegalArgumentException("El nodo " + padre + " no pertenece a este arbol.");
        }
    }

    private boolean contiene(Nodo<T> actual, Nodo<T> buscado) {

        if (actual == null) {
            return false;
        }
        if (actual == buscado) {
            return true;
        }
        return contiene(actual.getIzquierdo(), buscado) || contiene(actual.getDerecho(), buscado);
    }

    private int contarNodos(Nodo<T> actual) {

        if (actual == null) {
            return 0;
        }
        return 1 + contarNodos(actual.getIzquierdo()) + contarNodos(actual.getDerecho());
    }

    private int contarHojas(Nodo<T> actual) {

        if (actual == null) {
            return 0;
        }
        if (actual.esHoja()) {
            return 1;
        }
        return contarHojas(actual.getIzquierdo()) + contarHojas(actual.getDerecho());
    }
}
