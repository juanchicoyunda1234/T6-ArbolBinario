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
        System.out.println("0. Salir");
    }

    private static void ejecutarOpcion(int opcion) {

        switch (opcion) {
            case 1:
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
            case 0:
                break;
            default:
                System.out.println("Opcion invalida.");
        }
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
