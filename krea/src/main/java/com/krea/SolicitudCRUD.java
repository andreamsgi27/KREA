package com.krea; // Declaración del paquete al que pertenece esta clase.

import java.time.LocalDate; // Importa la clase LocalDate que permite manejar fechas.
import java.util.ArrayList; // Importa la clase ArrayList que permite crear listas dinámicas.
import java.util.Collections; // Importa la clase Collections que ofrece métodos para trabajar con colecciones.
import java.util.Comparator; // Importa la clase Comparator que permite comparar objetos.
import java.util.List; // Importa la interfaz List que define una colección ordenada.

public class SolicitudCRUD { // Declaración de la clase SolicitudCRUD.
    private List<Solicitud> solicitudes; // Declara una variable privada de tipo List para almacenar las solicitudes.

    public SolicitudCRUD(List<Solicitud> solicitudes) { // Constructor que recibe una lista de solicitudes.
        this.solicitudes = solicitudes; // Asigna la lista recibida a la variable de instancia.
    }

    // Crear una nueva solicitud (Create)
    public void crearSolicitud(int solicitudId, String nombreSolicitud, LocalDate fechaSolicitud, String temaSolicitud, String descripcionSolicitud, String estadoSolicitud) { // Método para crear una nueva solicitud.
        Solicitud solicitud = new Solicitud(solicitudId, nombreSolicitud, fechaSolicitud, temaSolicitud, descripcionSolicitud, estadoSolicitud);
        solicitudes.add(solicitud); // Agrega la nueva solicitud a la lista de solicitudes.
    }

    // Leer una solicitud por su ID (Read)
    public Solicitud obtenerSolicitud(int id) { // Método para obtener una solicitud usando su ID.
        for (Solicitud solicitud : solicitudes) { // Recorre cada solicitud en la lista.
            if (solicitud.getSolicitudId() == id) { // Verifica si el ID de la solicitud coincide con el ID buscado.
                return solicitud; // Retorna la solicitud si el ID coincide.
            }
        }
        return null; // Si no se encuentra la solicitud, retorna null.
    }

    // Actualizar una solicitud (Update)
    public boolean actualizarSolicitud(Solicitud solicitudActualizada) { // Método para actualizar una solicitud existente.
        for (int i = 0; i < solicitudes.size(); i++) { // Itera sobre la lista de solicitudes usando un índice.
            Solicitud solicitud = solicitudes.get(i); // Obtiene la solicitud en la posición actual.
            if (solicitud.getSolicitudId() == solicitudActualizada.getSolicitudId()) { // Verifica si los IDs coinciden.
                solicitudes.set(i, solicitudActualizada); // Reemplaza la solicitud existente con la actualizada.
                return true; // Retorna true si la actualización fue exitosa.
            }
        }
        return false; // Retorna false si no se encontró la solicitud para actualizar.
    }

    // Eliminar una solicitud solo si está finalizada (Delete)
    public boolean eliminarSolicitud(int id) { // Método para eliminar una solicitud por su ID.
        for (int i = 0; i < solicitudes.size(); i++) { // Itera sobre la lista de solicitudes.
            Solicitud solicitud = solicitudes.get(i); // Obtiene la solicitud en la posición actual.
            // Verifica si el ID coincide y si el estado es "Finalizada".
            if (solicitud.getSolicitudId() == id && "Finalizada".equals(solicitud.getEstadoSolicitud())) {
                solicitudes.remove(i); // Elimina la solicitud de la lista.
                return true; // Retorna true si la eliminación fue exitosa.
            }
        }
        return false; // Retorna false si no se encontró la solicitud o no estaba finalizada.
    }

    // Listar todas las solicitudes en orden de creación (Read all)
    public List<Solicitud> listarSolicitudesEnOrdenAsc() { // Método para listar todas las solicitudes en orden ascendente.
        Collections.sort(solicitudes, Comparator.comparing(Solicitud::getFechaSolicitud)); // Ordena la lista por fecha de solicitud.
        return new ArrayList<>(solicitudes); // Devuelve una copia de la lista de solicitudes.
    }

    // Cambiar el estado de una solicitud
    public boolean cambiarEstadoSolicitud(int id, String nuevoEstado) { // Método para cambiar el estado de una solicitud.
        for (Solicitud solicitud : solicitudes) { // Recorre cada solicitud en la lista.
            if (solicitud.getSolicitudId() == id) { // Verifica si el ID coincide.
                solicitud.setEstadoSolicitud(nuevoEstado); // Cambia el estado de la solicitud.
                // Si el nuevo estado es "Atendida", establece la fecha de atención.
                if ("Atendida".equals(nuevoEstado)) {
                    solicitud.setFechaSolicitud(LocalDate.now()); // Establece la fecha de atención como la fecha actual.
                }
                return true; // Retorna true si el cambio de estado fue exitoso.
            }
        }
        return false; // Retorna false si no se encontró la solicitud.
    }
}

//Requisitos:
//La solicitud contendrá los siguientes datos: nombre del solicitante, fecha de la solicitud, tema de la consulta, descripción
//Los empleados podrán crear nuevas solicitudes de soporte técnico, visualizarlas, y actualizarlas.
//El departamento técnico debe poder solicitar todas la solicitudes en orden de creación (ASC)
//El departamento técnico debe saber si una solicitud está en curso
//El departamento técnico debe poder marcar una solicitud como atendida, en curso o finalizada
//El departamento técnico debe poder saber cuando de efectuó la asistencia
//El departamento técnico debe poder editar una solicitud ya registrada
//El departamento técnico debe poder eliminar una solicitud siempre y cuando está haya sido marcada previamente como finalizada