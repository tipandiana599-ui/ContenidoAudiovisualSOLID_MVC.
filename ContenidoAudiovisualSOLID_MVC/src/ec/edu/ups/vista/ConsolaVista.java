package ec.edu.ups.vista;

import java.util.Scanner;

public class ConsolaVista {
    private final Scanner scanner;

    public ConsolaVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== SISTEMA DE CONTENIDO AUDIOVISUAL ===");
        System.out.println("1. Registrar Película");
        System.out.println("2. Registrar Serie de TV");
        System.out.println("3. Registrar Documental");
        System.out.println("4. Listar Contenidos");
        System.out.println("5. Guardar en Archivo CSV");
        System.out.println("6. Cargar desde Archivo CSV");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine(); // Limpiar buffer
        return scanner.nextLine();
    }

    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
}