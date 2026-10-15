package modelo;

public class Nodo<T> {

    private T dato;
    private Nodo<T> izquierdo;
    private Nodo<T> derecho;

    public Nodo(T dato) {

        if (dato == null) {
            throw new IllegalArgumentException("El dato del nodo no puede ser nulo.");
        }
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public T getDato() {

        return dato;
    }

    public void setDato(T dato) {

        if (dato == null) {
            throw new IllegalArgumentException("El dato del nodo no puede ser nulo.");
        }
        this.dato = dato;
    }

    public Nodo<T> getIzquierdo() {

        return izquierdo;
    }

    public void setIzquierdo(Nodo<T> izquierdo) {

        this.izquierdo = izquierdo;
    }

    public Nodo<T> getDerecho() {

        return derecho;
    }

    public void setDerecho(Nodo<T> derecho) {

        this.derecho = derecho;
    }

    @Override
    public String toString() {

        return String.valueOf(dato);
    }
}
