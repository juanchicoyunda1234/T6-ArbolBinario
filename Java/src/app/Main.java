package app;

import java.util.Scanner;

import modelo.Nodo;
import negocio.ArbolBinario;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static ArbolBinario<String> arbol = new ArbolBinario<>();

    public static void main(String[] args) {

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);
        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {

        System.out.println();
        System.out.println("===== ORGANIZACION DE DEPARTAMENTOS UNIVERSITARIOS =====");
        System.out.println("1. Crear el arbol inicial");
        System.out.println("2. Visualizar el arbol");
        System.out.println("3. Consultar el numero de nodos");
        System.out.println("4. Consultar el numero de hojas");
        System.out.println("5. Consultar la altura");
        System.out.println("6. Consultar el grado de un nodo");
        System.out.println("7. Verificar si un nodo es hoja");
        System.out.println("0. Salir");
    }

    private static void ejecutarOpcion(int opcion) {

        switch (opcion) {
            case 1:
                arbol = construirArbolInicial();
                System.out.println("Arbol inicial creado.");
                break;
            case 2:
                System.out.println();
                arbol.mostrarArbol();
                break;
            case 3:
                System.out.println("Numero de nodos: " + arbol.contarNodos());
                break;
            case 4:
                System.out.println("Numero de hojas: " + arbol.contarHojas());
                break;
            case 5:
                System.out.println("Altura (en aristas): " + arbol.altura());
                break;
            case 6:
                consultarGrado();
                break;
            case 7:
                consultarHoja();
                break;
            case 0:
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    private static ArbolBinario<String> construirArbolInicial() {

        ArbolBinario<String> nuevo = new ArbolBinario<>();

        Nodo<String> universidad = nuevo.crearRaiz("UNIVERSIDAD");
        Nodo<String> fisei = nuevo.agregarIzquierdo(universidad, "FISEI");
        Nodo<String> dide = nuevo.agregarDerecho(universidad, "DIDE");
        Nodo<String> software = nuevo.agregarIzquierdo(fisei, "SOFTWARE");
        nuevo.agregarDerecho(fisei, "TI");
        nuevo.agregarIzquierdo(dide, "INVEST.");
        nuevo.agregarDerecho(dide, "VINCULACION");
        nuevo.agregarIzquierdo(software, "NIVEL1");
        nuevo.agregarDerecho(software, "NIVEL3");

        return nuevo;
    }

    private static void consultarGrado() {

        Nodo<String> nodo = pedirNodo();
        if (nodo != null) {
            System.out.println("Grado de " + nodo + ": " + nodo.grado());
        }
    }

    private static void consultarHoja() {

        Nodo<String> nodo = pedirNodo();
        if (nodo != null) {
            System.out.println(nodo + (nodo.esHoja() ? " es una hoja." : " no es una hoja."));
        }
    }

    private static Nodo<String> pedirNodo() {

        if (arbol.esVacio()) {
            System.out.println("El arbol esta vacio. Cree primero el arbol inicial (opcion 1).");
            return null;
        }
        String nombre = leerTexto("Nombre del nodo: ").toUpperCase();
        Nodo<String> nodo = arbol.buscar(nombre);
        if (nodo == null) {
            System.out.println("No existe un nodo llamado \"" + nombre + "\".");
        }
        return nodo;
    }

    private static int leerEntero(String mensaje) {

        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String linea = sc.nextLine();
            try {
                valor = Integer.parseInt(linea.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
        return valor;
    }

    private static String leerTexto(String mensaje) {

        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacio.");
            }
        }
        return texto;
    }
}
