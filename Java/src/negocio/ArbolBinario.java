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

        if (padre.getIzquierdo() != null) {
            throw new IllegalStateException("La posicion izquierda de " + padre + " ya esta ocupada por " + padre.getIzquierdo() + ".");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setIzquierdo(nuevo);
        return nuevo;
    }

    public Nodo<T> agregarDerecho(Nodo<T> padre, T dato) {

        if (padre.getDerecho() != null) {
            throw new IllegalStateException("La posicion derecha de " + padre + " ya esta ocupada por " + padre.getDerecho() + ".");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setDerecho(nuevo);
        return nuevo;
    }
}
