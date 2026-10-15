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
}
