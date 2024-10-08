package com.krea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitudCRUD {
    private List<SolicitudDatabase> solicitudes;
    private final String FILE_NAME = "solicitudes.dat"; // Name of the file to save requests

    public SolicitudCRUD() {
        this.solicitudes = new ArrayList<>();
        cargarSolicitudes(); // Load requests at startup
        if (solicitudes.isEmpty()) {
            inicializarSolicitudes(); // Load initial data if the list is empty
        }
    }

    private void cargarSolicitudes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            solicitudes = (List<SolicitudDatabase>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de solicitudes, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las solicitudes: " + e.getMessage());
        }
    }

    private void inicializarSolicitudes() {
        // Add initial requests
        solicitudes.add(new SolicitudDatabase(1, "Juan Perez", LocalDate.parse("2024-09-15"), "Consulta Técnica",
                "Problema con acceso a la base de datos", "Atendida"));
        solicitudes.add(new SolicitudDatabase(2, "Maria Lopez", LocalDate.parse("2024-09-17"), "Revisión de Proyecto",
                "Revisión del proyecto de inteligencia artificial", "En curso"));
        solicitudes.add(new SolicitudDatabase(3, "Carlos Gomez", LocalDate.parse("2024-09-18"), "Asesoría Financiera",
                "Consulta sobre opciones de inversión", "Pendiente"));
        solicitudes.add(new SolicitudDatabase(4, "Ana Torres", LocalDate.parse("2024-09-19"), "Consulta Médica",
                "Síntomas de resfriado", "Atendida"));
        solicitudes.add(new SolicitudDatabase(5, "Luis Martinez", LocalDate.parse("2024-09-20"), "Soporte Técnico",
                "Problemas con la impresora", "En curso"));
        solicitudes.add(new SolicitudDatabase(6, "Laura Rodriguez", LocalDate.parse("2024-09-21"), "Consulta Legal",
                "Revisión de contrato", "Pendiente"));
        solicitudes.add(new SolicitudDatabase(7, "David Sanchez", LocalDate.parse("2024-09-22"),
                "Planificación de Eventos", "Organización de la próxima conferencia", "Atendida"));
        solicitudes.add(new SolicitudDatabase(8, "Sofia Ruiz", LocalDate.parse("2024-09-23"), "Revisión de CV",
                "Asesoría sobre CV", "En curso"));
        solicitudes.add(new SolicitudDatabase(9, "Pedro Ramirez", LocalDate.parse("2024-09-24"), "Consulta Técnica",
                "Actualización de software", "Pendiente"));
        solicitudes.add(new SolicitudDatabase(10, "Clara Jimenez", LocalDate.parse("2024-09-25"),
                "Soporte de Marketing", "Consulta sobre campaña publicitaria", "Atendida"));
        solicitudes.add(new SolicitudDatabase(11, "Miguel Ortega", LocalDate.parse("2024-09-26"), "Consulta Educativa",
                "Información sobre programas de máster", "En curso"));
        solicitudes.add(new SolicitudDatabase(12, "Valeria Castro", LocalDate.parse("2024-09-27"),
                "Evaluación de Proyectos", "Análisis del nuevo proyecto", "Pendiente"));
        solicitudes.add(new SolicitudDatabase(13, "Felipe Torres", LocalDate.parse("2024-09-28"), "Consulta Técnica",
                "Problema con el servidor", "Atendida"));
        solicitudes.add(new SolicitudDatabase(14, "Elena Gonzalez", LocalDate.parse("2024-09-29"), "Soporte IT",
                "Reinstalación de software", "En curso"));
        solicitudes.add(new SolicitudDatabase(15, "Javier Moreno", LocalDate.parse("2024-09-30"),
                "Consulta de Recursos Humanos", "Dudas sobre beneficios laborales", "Pendiente"));
        solicitudes.add(new SolicitudDatabase(16, "Natalia Silva", LocalDate.parse("2024-10-01"), "Consulta Técnica",
                "Problemas con el hardware", "Atendida"));
        solicitudes.add(new SolicitudDatabase(17, "Alfredo Delgado", LocalDate.parse("2024-10-02"), "Asesoría Contable",
                "Consulta sobre declaración de impuestos", "En curso"));
        solicitudes.add(new SolicitudDatabase(18, "Rosa Paredes", LocalDate.parse("2024-10-03"), "Consulta Médica",
                "Dolor de cabeza persistente", "Pendiente"));
        solicitudes.add(new SolicitudDatabase(19, "Tomás Reyes", LocalDate.parse("2024-10-04"), "Consulta Técnica",
                "Fallo en la conexión a internet", "Atendida"));
        solicitudes.add(new SolicitudDatabase(20, "Silvia Becerra", LocalDate.parse("2024-10-05"),
                "Consulta de Marketing", "Estrategias para redes sociales", "En curso"));
        solicitudes.add(new SolicitudDatabase(21, "Rafael Mendoza", LocalDate.parse("2024-10-06"), "Consulta Educativa",
                "Información sobre becas", "Pendiente"));
        solicitudes.add(new SolicitudDatabase(22, "Nadia Cruz", LocalDate.parse("2024-10-07"), "Consulta Médica",
                "Síntomas de alergia", "Pendiente"));

        guardarSolicitudes(); // Save the initial requests in the file
    }

    public void guardarSolicitudes() { // Ensure this method is public
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(solicitudes);
        } catch (IOException e) {
            System.out.println("Error al guardar las solicitudes: " + e.getMessage());
        }
    }

    public void crearSolicitud(String nombre, LocalDate fecha, String tema, String descripcion, String estado) {
        int nuevoId = obtenerNuevoId(); // Obtener el nuevo ID

        // Ahora no se verifica la existencia del ID ya que acabamos de generarlo y es
        // único por diseño.

        SolicitudDatabase nuevaSolicitud = new SolicitudDatabase(nuevoId, nombre, fecha, tema, descripcion, estado);
        solicitudes.add(nuevaSolicitud);
        guardarSolicitudes(); // Guardar después de crear una nueva solicitud
        System.out.println("Solicitud creada exitosamente con ID: " + nuevoId);
    }

    private int obtenerNuevoId() {
        // Determinar el último ID y generar el siguiente
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

    public boolean actualizarSolicitud(SolicitudDatabase solicitudActualizada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getSolicitudId() == solicitudActualizada.getSolicitudId()) {
                solicitudes.set(i, solicitudActualizada);
                guardarSolicitudes(); // Save after updating
                return true;
            }
        }
        return false;
    }

    public boolean eliminarSolicitud(int id) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getSolicitudId() == id) {
                solicitudes.remove(i);
                guardarSolicitudes(); // Save after deleting
                return true;
            }
        }
        return false;
    }

    public void mostrarSolicitudes() {
        System.out.println("---- Lista de Solicitudes ----");
        for (SolicitudDatabase solicitud : solicitudes) {
            System.out.println(solicitud);
        }
    }
}
