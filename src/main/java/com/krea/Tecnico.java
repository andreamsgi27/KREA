package com.krea;

import java.time.LocalDate;
import java.util.Scanner;

public class Tecnico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SolicitudCRUD solicitudCRUD = new SolicitudCRUD();
        int opciones;
        boolean check = true;

        while (check) {
            try {
                String azul = "\033[1;36m";
                String naranja = "\033[0;33m";
                String rojo = "\033[0;31m";
                String verde = "\033[0;32m";
                String amarillo = "\033[0;33m";
                String reset = "\033[0m";
                System.err.println("");
                System.out.println("============");
                System.out.println(azul + "MENÚ TÉCNICO" + reset);
                System.out.println("============\n");
                System.out.println(
                        "1. Ver solicitudes \n2. Cambiar estado de Solicitud \n3. Actualizar Solicitud \n4. Eliminar Solicitud \n5. Salir");
                System.out.println("                                            ");
                System.out.println("> Elige una opción (1-5):          ");
                opciones = scanner.nextInt();

                if (opciones == 1) {
                    System.out.println();
                    System.out.println("-----------------");
                    System.out.println(azul + "LISTA SOLICITUDES" + reset);
                    System.out.println("-----------------");
                    System.out.println();
                    solicitudCRUD.mostrarSolicitudes();
                    System.out.println(naranja + "Pulsa [Enter] para volver al menú de técnico..." + reset);
                    scanner.nextLine(); 
                    scanner.nextLine(); 

                } else if (opciones == 2) {
                    System.out.println();
                    System.out.println("------------------------");
                    System.out.println(azul + "CAMBIAR ESTADO SOLICITUD" + reset);
                    System.out.println("-------------------------");
                    System.out.println("> Ingrese el ID de la solicitud que desea modificar: ");
                    int solicitudId = scanner.nextInt();
                    solicitudCRUD.cambiarestadoSolicitud(solicitudId);
                    scanner.nextLine(); 
                    System.out.println(naranja + "\nPulsa [Enter] para volver al menú de técnico..." + reset);
                    scanner.nextLine(); 

                } else if (opciones == 3) {
                    System.out.println();
                    System.out.println("--------------------");
                    System.out.println(azul + "ACTUALIZAR SOLICITUD"+ reset);
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
                        System.out.println(verde + "\nSolicitud actualizada exitosamente." + reset);
                    } else {
                        System.out.println(rojo + "\nERROR: No existe una solicitud con ID " + idActualizar + reset);
                    }
                    System.out.println(naranja + "\nPulsa [Enter] para volver al menú de técnico..." + reset);
                    scanner.nextLine(); 

                } else if (opciones == 4) {
                    System.out.println();
                    System.out.println("------------------");
                    System.out.println(azul + "ELIMINAR SOLICITUD" + reset);
                    System.out.println("------------------");
                    System.out.println("Por favor introduce el ID de la solicitud a eliminar:");
                    int solicitudId = scanner.nextInt();
                    if (solicitudCRUD.obtenerSolicitud(solicitudId) != null) {
                        solicitudCRUD.eliminarSolicitudTecnico(solicitudId);
                    }else{
                        System.out.println(rojo + "\nERROR: No existe una solicitud con ID " + solicitudId + reset);
                    }
                    System.out.println(naranja + "\nPulsa [Enter] para volver al menú de técnico..." + reset);
                    scanner.nextLine(); 
                    scanner.nextLine();
                } else if (opciones == 5) {
                    System.out.println(amarillo + "\nSALIENDO DE LA APLICACIÓN..." + reset);
                    break;

                } else {
                    System.out.println(rojo + "ERROR: No has escrito bien el número" + reset);
                    scanner.nextLine();
                    scanner.nextLine();
                }
            } catch (Exception e) {
                String rojo = "\033[0;31m";
                String reset = "\033[0m";
                System.out.println(rojo + "ERROR: Entrada no válida." + reset);
                scanner.next();
            }
        }

        scanner.close();
    }
}
