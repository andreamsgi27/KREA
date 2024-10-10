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
                System.out.println("============");
                System.out.println("MENÚ TÉCNICO");
                System.out.println("============");
                System.out.println(
                        "1. Ver solicitudes \n2. Cambiar estado de Solicitud \n3. Actualizar Solicitud \n4. Eliminar Solicitud \n5. Salir");
                System.out.println("                                            ");
                System.out.println("> Elige una opción (1-5):          ");       
                opciones = scanner.nextInt();

                if (opciones == 1) {
                    System.out.println();
                    System.out.println("-----------------");
                    System.out.println("LISTA SOLICITUDES");
                    System.out.println("-----------------");
                    System.out.println();
                    solicitudCRUD.mostrarSolicitudes();

                } else if (opciones == 2) {
                    System.out.println();
                    System.out.println("------------------------");
                    System.out.println("CAMBIAR ESTADO SOLICITUD");
                    System.out.println("-------------------------");
                    System.out.println("> Ingrese el ID de la solicitud que desea modificar: ");
                    int solicitudId = scanner.nextInt();
                    solicitudCRUD.cambiarestadoSolicitud(solicitudId); // Call the method with the solicitudId

                } else if (opciones == 3) {
                    // Actualizar solicitud
                    System.out.println();
                    System.out.println("--------------------");
                    System.out.println("ACTUALIZAR SOLICITUD");
                    System.out.println("--------------------");
                    LocalDate fechaActualizar = LocalDate.now();
                    System.out.print("> Ingrese ID de la solicitud a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    if (solicitudCRUD.obtenerSolicitud(idActualizar) != null) {
                        System.out.print("> Ingrese nuevo nombre del solicitante: ");
                        String nombreActualizar = scanner.nextLine();
                        System.out.print("> Ingrese nuevo tema de la solicitud: ");
                        String temaActualizar = scanner.nextLine();
                        System.out.print("> Ingrese nueva descripción de la solicitud: ");
                        String descripcionActualizar = scanner.nextLine();
                        String estadoActualizar = "Modificado por Técnico";
                        SolicitudDatabase solicitudActualizar = new SolicitudDatabase(idActualizar, nombreActualizar,
                                fechaActualizar, temaActualizar, descripcionActualizar, estadoActualizar);
                        boolean actualizado = solicitudCRUD.actualizarSolicitudTecnico(solicitudActualizar);
                        String verde = "\033[0;32m";
                        String reset = "\033[0m";
                        System.out.println(verde + "\n Solicitud actualizada exitosamente." + reset);
                    } else {
                        String rojo = "\033[0;31m";
                        String reset = "\033[0m";
                        System.out.println(rojo + "\n ERROR: No existe una solicitud con ID " + idActualizar + reset);
                    }

                } else if (opciones == 4) {
                    System.out.println();
                    System.out.println("------------------");
                    System.out.println("ELIMINAR SOLICITUD");
                    System.out.println("------------------");
                    System.out.println("Por favor introduce el ID de la solicitud a eliminar:");
                    int solicitudId = scanner.nextInt();
                    if (solicitudCRUD.obtenerSolicitud(solicitudId) != null) {
                        solicitudCRUD.eliminarSolicitudTecnico(solicitudId);
                    }else{
                        String rojo = "\033[0;31m";
                        String reset = "\033[0m";
                        System.out.println(rojo + "\n ERROR: No existe una solicitud con ID " + solicitudId + reset);
                    }


                } else if (opciones == 5) {
                    String amarillo = "\033[0;33m";  
                    String reset = "\033[0m"; 
                    System.out.println(amarillo + "\nSALIENDO DE LA APLICACIÓN..." + reset);
                    break;

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
