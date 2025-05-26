// Archivo: Main.java preentrega 1
package com.after;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Articulo> lista = new ArrayList<>();
    private static int contadorProductos = 1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Nombre del artículo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpia el buffer

            switch (opcion) {
                case 1:
                    crearArticulo();
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 3:
                    modificarArticulo();
                    break;
                case 4:
                    eliminarArticulo();
                    break;
                case 5:
                    devolverNombreArticulo();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void crearArticulo() {
        int id = contadorProductos++;
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // limpia buffer

        Articulo art = new Articulo(id, nombre, precio);
        lista.add(art);
        System.out.println("Artículo agregado con ID " + id + ".");
    }

    private static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            System.out.println("---- Lista de Artículos ----");
            for (Articulo a : lista) {
                a.mostrar();
            }
        }
    }

    private static void modificarArticulo() {
        System.out.print("ID del artículo a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Articulo a : lista) {
            if (a.getId() == id) {
                System.out.print("Nuevo nombre: ");
                a.setNombre(sc.nextLine());
                System.out.print("Nuevo precio: ");
                a.setPrecio(sc.nextDouble());
                sc.nextLine();
                System.out.println("Artículo actualizado.");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    private static void eliminarArticulo() {
        System.out.print("ID del artículo a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean removed = lista.removeIf(a -> a.getId() == id);
        System.out.println(removed ? "Artículo eliminado." : "Artículo no encontrado.");
    }

    private static void devolverNombreArticulo() {
        System.out.print("ID del artículo para consulta: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Articulo a : lista) {
            if (a.getId() == id) {
                System.out.println("Nombre: " + a.getNombre());
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }
}
