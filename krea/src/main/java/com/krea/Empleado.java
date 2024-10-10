package com.krea;

import java.time.LocalDate;
import java.util.Scanner;

public class Empleado {
    public static void main(String[] args) {
        SolicitudCRUD solicitudCRUD = new SolicitudCRUD();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        LocalDate fecha = null;
        // boolean fechaValida = false;
        LocalDate fechaActual = LocalDate.now();

        while (running) {
            System.out.println("                                           ");
            System.out.println("                                           ");
            System.out.println("=============");
            System.out.println("MENÚ EMPLEADO");
            System.out.println("=============");
            System.out.println("1. Crear solicitud            ");
            System.out.println("2. Obtener solicitud          ");
            System.out.println("3. Actualizar solicitud       ");
            System.out.println("4. Eliminar solicitud         ");
            System.out.println("5. Listar solicitudes         ");
            System.out.println("6. Salir                      ");
            System.out.println("                                            ");
            System.out.println("Elige una opción (1-6):          ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    fecha = fechaActual;
                    System.out.println();
                    System.out.println("---------------");
                    System.out.println("CREAR SOLICITUD");
                    System.out.println("---------------");
                    System.out.print("> Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("> Ingrese tema: ");
                    String tema = scanner.nextLine();
                    System.out.print("> Ingrese descripción: ");
                    String descripcion = scanner.nextLine();
                    String estado = ("Pendiente");
                    solicitudCRUD.crearSolicitud(nombre, fecha, tema, descripcion, estado);
                    break;

                case 2:
                    // Obtener solicitud
                    System.out.println();
                    System.out.println("------------------");
                    System.out.println("OBTENER SOLICITUD");
                    System.out.println("------------------");
                    System.out.print("> Ingrese ID de la solicitud a obtener: ");
                    int idObtener = scanner.nextInt();
                    SolicitudDatabase solicitudObtenida = solicitudCRUD.obtenerSolicitud(idObtener);
                    if (solicitudObtenida != null) {
                        System.out.println("\n");
                        System.out.println(solicitudObtenida);
                        String verde = "\033[0;32m";
                        String reset = "\033[0m";
                        System.out.println(verde + "\n Solicitud obtenida exitosamente." + reset);
                    } else {
                        String rojo = "\033[0;31m";
                        String reset = "\033[0m";    
                        System.out.println(rojo + "ERROR: No se encontró la solicitud con ID: " + idObtener + reset);
                    }
                    break;

                case 3:
                    // Actualizar solicitud
                    System.out.println();
                    System.out.println("------------------");
                    System.out.println("ACTUALIZAR SOLICITUD");
                    System.out.println("------------------");
                    System.out.print("> Ingrese ID de la solicitud a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("> Ingrese nuevo nombre del solicitante: ");
                    String nombreActualizar = scanner.nextLine();
                    LocalDate fechaActualizar = LocalDate.now();
                    System.out.print("> Ingrese nuevo tema de la solicitud: ");
                    String temaActualizar = scanner.nextLine();
                    System.out.print("> Ingrese nueva descripción de la solicitud: ");
                    String descripcionActualizar = scanner.nextLine();

                    String estadoActualizar = "Cambio en Solicitud";

                    SolicitudDatabase solicitudActualizar = new SolicitudDatabase(idActualizar, nombreActualizar,
                            fechaActualizar, temaActualizar, descripcionActualizar, estadoActualizar);

                    boolean actualizado = solicitudCRUD.actualizarSolicitud(solicitudActualizar);
                    if (actualizado) {   
                        String verde = "\033[0;32m";
                        String reset = "\033[0m";
                        System.out.println(verde + "\n Solicitud actualizada exitosamente." + reset);
                    } else {
                        String rojo = "\033[0;31m";
                        String reset = "\033[0m";    
                        System.out.println(rojo + "ERROR: No se encontró la solicitud con ID: " + idActualizar + reset);
                    }
                    break;

                case 4:
                    // Eliminar solicitud
                    System.out.println();
                    System.out.println("------------------");
                    System.out.println("ELIMINAR SOLICITUD");
                    System.out.println("------------------");
                    System.out.print("> Ingrese ID de la solicitud a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    boolean eliminado = solicitudCRUD.eliminarSolicitud(idEliminar);
                    if (eliminado) {   
                        String verde = "\033[0;32m";
                        String reset = "\033[0m";
                        System.out.println(verde + "Solicitud eliminada exitosamente." + reset);
                    } else {
                        String rojo = "\033[0;31m";
                        String reset = "\033[0m";    
                        System.out.println(rojo + "ERROR: No se encontró la solicitud con ID " + idEliminar + reset);
                    }
                    break;

                case 5:
                    // Listar solicitudes
                    System.out.println();
                    System.out.println("----------------");
                    System.out.println("LISTAR SOLICITUD");
                    System.out.println("----------------");
                    solicitudCRUD.mostrarSolicitudes();
                    break;

                case 6:
                    solicitudCRUD.guardarSolicitudes(); // Guardar antes de salir
                    running = false;
                    String amarillo = "\033[0;33m";  
                    String reset = "\033[0m"; 
                    System.out.println(amarillo + "\nSALIENDO DE LA APLICACIÓN..." + reset);
                    break;

                default:
                String rojo = "\033[0;31m";
                String reset1 = "\033[0m";    
                    System.out.println(rojo + "ERROR: Opción no válida. Intente de nuevo." + reset1);
            }
        }
        scanner.close();
    }
}
