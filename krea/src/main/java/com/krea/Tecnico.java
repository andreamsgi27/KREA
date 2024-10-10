package com.krea;

import java.time.LocalDate;
import java.util.Scanner;

public class Tecnico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SolicitudCRUD solicitudCRUD = new SolicitudCRUD();
        int opciones;
        boolean check = true;
        LocalDate fechaActual = LocalDate.now();

        while (check) {
            try {
                System.err.println("");
                System.out.println("===============================");
                System.out.println("          MENÚ TÉCNICO");
                System.out.println("===============================");
                System.out.println(
                        "1. Ver solicitudes \n2. Cambiar estado de Solicitud \n3. Editar Solicitud \n4. Eliminar Solicitud \n5. Salir");
                opciones = scanner.nextInt();

                if (opciones == 1) {
                    solicitudCRUD.mostrarSolicitudes();

                } else if (opciones == 2) {
                    System.out.println("Ingrese el ID de la solicitud que desea modificar: ");
                    int solicitudId = scanner.nextInt();
                    solicitudCRUD.cambiarestadoSolicitud(solicitudId); // Call the method with the solicitudId

                } else if (opciones == 3) {
                    // Actualizar solicitud
                    LocalDate fechaActualizar = LocalDate.now();
                    System.out.print("Ingrese ID de la solicitud a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo nombre del solicitante: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Ingrese nuevo tema de la solicitud: ");
                    String temaActualizar = scanner.nextLine();
                    System.out.print("Ingrese nueva descripción de la solicitud: ");
                    String descripcionActualizar = scanner.nextLine();
                    String estadoActualizar = "Modificado por Técnico";

                    SolicitudDatabase solicitudActualizar = new SolicitudDatabase(idActualizar, nombreActualizar,
                            fechaActualizar, temaActualizar, descripcionActualizar, estadoActualizar);
                    boolean actualizado = solicitudCRUD.actualizarSolicitudTecnico(solicitudActualizar);
                    if (actualizado) {
                        System.out.println("Solicitud actualizada exitosamente.");
                    } else {
                        System.out.println("No se encontró la solicitud con ID: " + idActualizar);
                    }

                } else if (opciones == 4) {
                    System.out.println("\nPor favor introduce el ID de la solicitud:");
                    int solicitudId = scanner.nextInt();
                    solicitudCRUD.eliminarSolicitudTecnico(solicitudId);

                    if (solicitudCRUD.eliminarSolicitudTecnico(solicitudId) == false) {
                        System.out.println();
                        System.out.println("La solicitud no puede ser eliminada porque no está finalizada.");
                    }

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
