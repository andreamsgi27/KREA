package com.krea; // Declaración del paquete al que pertenece esta clase.

import java.time.LocalDate; // Importa la clase LocalDate que permite manejar fechas.
import java.util.ArrayList; // Importa la clase ArrayList que permite crear listas dinámicas.
import java.util.Collections; // Importa la clase Collections que ofrece métodos para trabajar con colecciones.
import java.util.Comparator; // Importa la clase Comparator que permite comparar objetos.
import java.util.List; // Importa la interfaz List que define una colección ordenada.

public class SolicitudCRUD { // Declaración de la clase SolicitudCRUD.
    private List<SolicitudDatabase> solicitudes; // Declara una variable privada de tipo List para almacenar las solicitudes.

    public SolicitudCRUD(List<SolicitudDatabase> solicitudes) { // Constructor que recibe una lista de solicitudes.
        this.solicitudes = solicitudes; // Asigna la lista recibida a la variable de instancia.
    }

    // Crear una nueva solicitud (Create)
    public void crearSolicitud(int solicitudId, String nombreSolicitud, LocalDate fechaSolicitud, String temaSolicitud, String descripcionSolicitud, String estadoSolicitud) {
        SolicitudDatabase solicitud = new SolicitudDatabase(solicitudId, nombreSolicitud, fechaSolicitud, temaSolicitud, descripcionSolicitud, estadoSolicitud);
        solicitudes.add(solicitud); // Agrega la nueva solicitud a la lista de solicitudes.
    }

    // Leer una solicitud por su ID (Read)
    public SolicitudDatabase obtenerSolicitud(int id) {
        for (SolicitudDatabase solicitud : solicitudes) { // Recorre cada solicitud en la lista.
            if (solicitud.getSolicitudId() == id) { // Verifica si el ID de la solicitud coincide con el ID buscado.
                return solicitud; // Retorna la solicitud si el ID coincide.
            }
        }
        return null; // Si no se encuentra la solicitud, retorna null.
    }

    // Actualizar una solicitud (Update)
    public boolean actualizarSolicitud(SolicitudDatabase solicitudActualizada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            SolicitudDatabase solicitud = solicitudes.get(i);
            if (solicitud.getSolicitudId() == solicitudActualizada.getSolicitudId()) {
                solicitudes.set(i, solicitudActualizada); // Reemplaza la solicitud existente con la actualizada.
                return true; // Retorna true si la actualización fue exitosa.
            }
        }
        return false; // Retorna false si no se encontró la solicitud para actualizar.
    }

    // Eliminar una solicitud solo si está finalizada (Delete)
    public boolean eliminarSolicitud(int id) {
        for (int i = 0; i < solicitudes.size(); i++) {
            SolicitudDatabase solicitud = solicitudes.get(i);
            if (solicitud.getSolicitudId() == id && "Finalizada".equals(solicitud.getEstadoSolicitud())) {
                solicitudes.remove(i); // Elimina la solicitud de la lista.
                return true; // Retorna true si la eliminación fue exitosa.
            }
        }
        return false; // Retorna false si no se encontró la solicitud o no estaba finalizada.
    }

    // Listar todas las solicitudes en orden de creación (Read all)
    public List<SolicitudDatabase> listarSolicitudesEnOrdenAsc() {
        Collections.sort(solicitudes, Comparator.comparing(SolicitudDatabase::getFechaSolicitud)); // Ordena la lista por fecha de solicitud.
        return new ArrayList<>(solicitudes); // Devuelve una copia de la lista de solicitudes.
    }

    // Cambiar el estado de una solicitud
    public boolean cambiarEstadoSolicitud(int id, String nuevoEstado) {
        for (SolicitudDatabase solicitud : solicitudes) {
            if (solicitud.getSolicitudId() == id) {
                solicitud.setEstadoSolicitud(nuevoEstado); // Cambia el estado de la solicitud.
                if ("Atendida".equals(nuevoEstado)) {
                    solicitud.setFechaSolicitud(LocalDate.now()); // Establece la fecha de atención como la fecha actual.
                }
                return true; // Retorna true si el cambio de estado fue exitoso.
            }
        }
        return false; // Retorna false si no se encontró la solicitud.
    }
}
