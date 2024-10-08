package com.krea;

import java.time.LocalDate;
import java.util.Scanner;

public class Empleado {
    public static void main(String[] args) {
        SolicitudCRUD solicitudCRUD = new SolicitudCRUD();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("---- Menú ----");
            System.out.println("1. Crear solicitud");
            System.out.println("2. Obtener solicitud");
            System.out.println("3. Actualizar solicitud");
            System.out.println("4. Eliminar solicitud");
            System.out.println("5. Listar solicitudes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese fecha (YYYY-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());
                    System.out.print("Ingrese tema: ");
                    String tema = scanner.nextLine();
                    System.out.print("Ingrese descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese estado: ");
                    String estado = scanner.nextLine();
                    
                    solicitudCRUD.crearSolicitud(nombre, fecha, tema, descripcion, estado);
                    System.out.println("Solicitud creada exitosamente.");
                    break;
            

                case 2:
                    // Obtener solicitud
                    System.out.print("Ingrese ID de la solicitud a obtener: ");
                    int idObtener = scanner.nextInt();
                    SolicitudDatabase solicitudObtenida = solicitudCRUD.obtenerSolicitud(idObtener);
                    if (solicitudObtenida != null) {
                        System.out.println("Solicitud encontrada: " + solicitudObtenida);
                    } else {
                        System.out.println("No se encontró la solicitud con ID: " + idObtener);
                    }
                    break;

                case 3:
                    // Actualizar solicitud
                    System.out.print("Ingrese ID de la solicitud a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo nombre del solicitante: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Ingrese nueva fecha de la solicitud (YYYY-MM-DD): ");
                    LocalDate fechaActualizar = LocalDate.parse(scanner.nextLine());
                    System.out.print("Ingrese nuevo tema de la solicitud: ");
                    String temaActualizar = scanner.nextLine();
                    System.out.print("Ingrese nueva descripción de la solicitud: ");
                    String descripcionActualizar = scanner.nextLine();
                    System.out.print("Ingrese nuevo estado de la solicitud: ");
                    String estadoActualizar = scanner.nextLine();

                    SolicitudDatabase solicitudActualizar = new SolicitudDatabase(idActualizar, nombreActualizar, fechaActualizar, temaActualizar, descripcionActualizar, estadoActualizar);
                    boolean actualizado = solicitudCRUD.actualizarSolicitud(solicitudActualizar);
                    if (actualizado) {
                        System.out.println("Solicitud actualizada exitosamente.");
                    } else {
                        System.out.println("No se encontró la solicitud con ID: " + idActualizar);
                    }
                    break;

                case 4:
                    // Eliminar solicitud
                    System.out.print("Ingrese ID de la solicitud a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    boolean eliminado = solicitudCRUD.eliminarSolicitud(idEliminar);
                    if (eliminado) {
                        System.out.println("Solicitud eliminada exitosamente.");
                    } else {
                        System.out.println("No se encontró la solicitud con ID: " + idEliminar);
                    }
                    break;

                case 5:
                    // Listar solicitudes
                    solicitudCRUD.mostrarSolicitudes();
                    break;

                case 6:
                    solicitudCRUD.guardarSolicitudes(); // Guardar antes de salir
                    running = false;
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
