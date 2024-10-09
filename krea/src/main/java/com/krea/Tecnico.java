package com.krea;

import java.util.Scanner;

public class Tecnico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SolicitudCRUD solicitudCRUD = new SolicitudCRUD();
        int opciones;
        boolean check = true;

        while (check) {
            try {
                System.err.println("");
                System.out.println("[1 - Ver solicitudes] [2 - Cambiar estado de Solicitud] [3 - Editar Solicitud] [4 - Eliminar Solicitud] [5 - Salir]");
                opciones = scanner.nextInt();

                if (opciones == 1) {
                    solicitudCRUD.mostrarSolicitudes();
                } else if (opciones == 2) {
                    System.out.println("Ingrese el ID de la solicitud que desea modificar: ");
                    int solicitudId = scanner.nextInt();
                    solicitudCRUD.cambiarestadoSolicitud(solicitudId); // Call the method with the solicitudId
                } else if (opciones == 3) {
                    System.out.println("Opción 3 seleccionada: Editar Solicitud");
                    // Call actualizarSolicitud method if needed
                } else if (opciones == 4) {
                    System.out.println("Opción 4 seleccionada: Eliminar Solicitud");
                    // Call eliminarSolicitud method if needed
                } else if (opciones == 5) {
                    check = false; // Exit the loop
                } else {
                    System.out.println("No has escrito bien el número");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close(); // Close the scanner when done
    }
}
