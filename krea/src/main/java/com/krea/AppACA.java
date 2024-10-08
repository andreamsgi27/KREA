package com.krea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppACA {
    public static void main(String[] args) {
        List<SolicitudDatabase> solicitudes = new ArrayList<>();
        SolicitudCRUD solicitudCRUD = new SolicitudCRUD(solicitudes);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("---- Menú ----");
            System.out.println("1. Crear solicitud");
            System.out.println("2. Obtener solicitud");
            System.out.println("3. Actualizar solicitud");
            System.out.println("4. Eliminar solicitud");
            System.out.println("5. Listar solicitudes");
            System.out.println("6. Cambiar estado de solicitud");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID de la solicitud: ");
                    int idCrear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nombre del solicitante: ");
                    String nombreCrear = scanner.nextLine();
                    System.out.print("Ingrese fecha de la solicitud (YYYY-MM-DD): ");
                    LocalDate fechaCrear = LocalDate.parse(scanner.nextLine());
                    System.out.print("Ingrese tema de la solicitud: ");
                    String temaCrear = scanner.nextLine();
                    System.out.print("Ingrese descripción de la solicitud: ");
                    String descripcionCrear = scanner.nextLine();
                    System.out.print("Ingrese estado de la solicitud: ");
                    String estadoCrear = scanner.nextLine();

                    solicitudCRUD.crearSolicitud(idCrear, nombreCrear, fechaCrear, temaCrear, descripcionCrear,
                            estadoCrear);
                    System.out.println("Solicitud creada exitosamente.");
                    break;

                case 2:
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

                    SolicitudDatabase solicitudActualizar = new SolicitudDatabase(idActualizar, nombreActualizar,
                            fechaActualizar, temaActualizar, descripcionActualizar, estadoActualizar);
                    boolean actualizado = solicitudCRUD.actualizarSolicitud(solicitudActualizar);
                    if (actualizado) {
                        System.out.println("Solicitud actualizada exitosamente.");
                    } else {
                        System.out.println("No se encontró la solicitud con ID: " + idActualizar);
                    }
                    break;

                case 4:
                    System.out.print("Ingrese ID de la solicitud a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    boolean eliminado = solicitudCRUD.eliminarSolicitud(idEliminar);
                    if (eliminado) {
                        System.out.println("Solicitud eliminada exitosamente.");
                    } else {
                        System.out.println("No se encontró la solicitud o no estaba finalizada.");
                    }
                    break;

                case 5:
                    List<SolicitudDatabase> listaSolicitudes = solicitudCRUD.listarSolicitudesEnOrdenAsc();
                    System.out.println("---- Lista de Solicitudes ----");
                    for (SolicitudDatabase sol : listaSolicitudes) {
                        System.out.println(sol);
                    }
                    break;

                case 6:
                    System.out.print("Ingrese ID de la solicitud a cambiar estado: ");
                    int idCambiarEstado = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo estado: ");
                    String nuevoEstado = scanner.nextLine();
                    boolean estadoCambiado = solicitudCRUD.cambiarEstadoSolicitud(idCambiarEstado, nuevoEstado);
                    if (estadoCambiado) {
                        System.out.println("Estado de la solicitud cambiado exitosamente.");
                    } else {
                        System.out.println("No se encontró la solicitud con ID: " + idCambiarEstado);
                    }
                    break;

                case 7:
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
