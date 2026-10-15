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
}
