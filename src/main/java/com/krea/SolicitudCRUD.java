package com.krea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SolicitudCRUD {
    private List<SolicitudDatabase> solicitudes;
    private final String FILE_NAME = "solicitudes.dat";

    public SolicitudCRUD() {
        this.solicitudes = new ArrayList<>();
        cargarSolicitudes();
    }

    private void cargarSolicitudes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            solicitudes = (List<SolicitudDatabase>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de solicitudes, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            String rojo = "\033[0;31m";
            String reset = "\033[0m";
            System.out.println(rojo + "\n ERROR: no se pueden cargar las solicitudes: " + e.getMessage() + reset);
        }
    }

    public void guardarSolicitudes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(solicitudes);
        } catch (IOException e) {
            String rojo = "\033[0;31m";
            String reset = "\033[0m";
            System.out.println(rojo + "\n ERROR: no se pudieron guardar las solicitudes: " + e.getMessage() + reset);
        }
    }

    public void crearSolicitud(String nombre, LocalDate fecha, String tema, String descripcion, String estado) {
        int nuevoId = obtenerNuevoId();
        SolicitudDatabase nuevaSolicitud = new SolicitudDatabase(nuevoId, nombre, fecha, tema, descripcion, estado);
        solicitudes.add(nuevaSolicitud);
        guardarSolicitudes();
        String verde = "\033[0;32m";
        String reset = "\033[0m";
        System.out.println(verde + "\nSolicitud creada exitosamente con ID " + nuevoId + reset);
    }

    private int obtenerNuevoId() {
        return solicitudes.isEmpty() ? 1 : solicitudes.get(solicitudes.size() - 1).getSolicitudId() + 1;
    }

    public SolicitudDatabase obtenerSolicitud(int id) {
        for (SolicitudDatabase solicitud : solicitudes) {
            if (solicitud.getSolicitudId() == id) {
                return solicitud;
            }
        }
        return null;
    }

    public boolean actualizarSolicitudTecnico(SolicitudDatabase solicitudActualizada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getSolicitudId() == solicitudActualizada.getSolicitudId()) {
                solicitudes.set(i, solicitudActualizada);
                guardarSolicitudes();
                return true;
            }
        }
        return false;
    }

    public boolean actualizarSolicitud(SolicitudDatabase solicitudActualizada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getSolicitudId() == solicitudActualizada.getSolicitudId()) {
                solicitudes.set(i, solicitudActualizada);
                guardarSolicitudes();
                return true;
            }
        }
        return false;
    }

    public boolean eliminarSolicitud(int id) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getSolicitudId() == id) {
                solicitudes.remove(i);
                guardarSolicitudes();
                return true;
            }
        }
        return false;
    }

    public void mostrarSolicitudes() {
        System.out.println();
        System.out.println();

        Collections.sort(solicitudes, new Comparator<SolicitudDatabase>() {
            @Override
            public int compare(SolicitudDatabase s1, SolicitudDatabase s2) {
                return s1.getFechaSolicitud().compareTo(s2.getFechaSolicitud());
            }
        });

        for (SolicitudDatabase solicitud : solicitudes) {
            System.out.println(solicitud);
        }
    }

    public void cambiarestadoSolicitud(int solicitudId) {
        Scanner scanner = new Scanner(System.in);
        SolicitudDatabase solicitud = obtenerSolicitud(solicitudId);
    
        if (solicitud != null) {
            System.out.println("\n>>> Estado actual de la solicitud " + solicitudId + ": " + "\n" + "   " + solicitud.getEstadoSolicitud());
            System.out.println(">>> Seleccione el nuevo estado de la solicitud " + solicitudId + ":");
            System.out.println("   [1] Atendida" + "   [2] En Curso" + "   [3] Finalizada");
    
            int opcion = scanner.nextInt();
            scanner.nextLine();
    
            String nuevoEstado = null;
            switch (opcion) {
                case 1:
                    nuevoEstado = "Atendida";
                    break;
                case 2:
                    nuevoEstado = "En Curso";
                    break;
                case 3:
                    nuevoEstado = "Finalizada";
                    break;
                default:
                    String rojo = "\033[0;31m";
                    String reset = "\033[0m";
                    System.out.println(rojo + "\n ERROR: Opción no válida. Intente de nuevo." + reset);
                    return;
            }
    
            solicitud.setEstadoSolicitud(nuevoEstado);
            actualizarSolicitud(solicitud);
            String verde = "\033[0;32m";
            String reset = "\033[0m";
            System.out.println(verde + "\nEl estado de la solicitud " + solicitudId + " ha sido actualizado a " + nuevoEstado + reset);
        } else {
            String rojo = "\033[0;31m";
            String reset = "\033[0m";
            System.out.println(rojo + "\n ERROR: No se encontró la solicitud con ID " + solicitudId + reset);
        }
    }
    

    public boolean eliminarSolicitudTecnico(int id) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getSolicitudId() == id
                    && solicitudes.get(i).getEstadoSolicitud().equals("Finalizada")) {
                solicitudes.remove(i);
                guardarSolicitudes();
                String verde = "\033[0;32m";
                String reset = "\033[0m";
                System.out.println(verde + "La solicitud " + id + " ha sido eliminada." + reset);
                return true;
            }
            if (solicitudes.get(i).getSolicitudId() == id
            && !solicitudes.get(i).getEstadoSolicitud().equals("Finalizada")) {
                System.out.println();
                String rojo = "\033[0;31m";
                String reset = "\033[0m";
                System.out.println(rojo + "ERROR: La solicitud no puede ser eliminada porque no está finalizada o no existe." + reset);
        }
    }
        return false;
    }

}
