package com.krea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitudData {
        private List<SolicitudDatabase> solicitudes;

        public SolicitudData() {
                solicitudes = new ArrayList<>();
                cargarSolicitudes(); // Cargar solicitudes iniciales
        }

        private void cargarSolicitudes() {
                // Aquí se inicializan las solicitudes
                solicitudes.add(new SolicitudDatabase(1, "Juan Perez", LocalDate.parse("2024-09-15"), 
                        "Consulta Técnica", "Problema con acceso a la base de datos", "Atendida"));
                solicitudes.add(new SolicitudDatabase(2, "Maria Lopez", LocalDate.parse("2024-09-17"),
                        "Revisión de Proyecto", "Revisión del proyecto de inteligencia artificial", "En curso"));
                // ... (agregar las demás solicitudes)
                solicitudes.add(new SolicitudDatabase(22, "Nadia Cruz", LocalDate.parse("2024-10-07"), 
                        "Consulta Médica", "Síntomas de alergia", "Pendiente"));
        }

        // Método para mostrar todas las solicitudes
        public void mostrarSolicitudes() {
                System.out.println("\nLista de Solicitudes:");
                for (SolicitudDatabase solicitud : solicitudes) {
                System.out.println(solicitud);
                }
        }

        // Método para obtener una solicitud por ID
        public SolicitudDatabase obtenerSolicitudPorId(int id) {
                for (SolicitudDatabase solicitud : solicitudes) {
                if (solicitud.getSolicitudId() == id) {
                        return solicitud;
                }
                }
                return null; // No se encontró
        }

        // Método para agregar una nueva solicitud
        public void agregarSolicitud(SolicitudDatabase nuevaSolicitud) {
                solicitudes.add(nuevaSolicitud);
        }

        // Método para actualizar una solicitud
        public boolean actualizarSolicitud(SolicitudDatabase solicitudActualizada) {
                for (int i = 0; i < solicitudes.size(); i++) {
                if (solicitudes.get(i).getSolicitudId() == solicitudActualizada.getSolicitudId()) {
                        solicitudes.set(i, solicitudActualizada);
                        return true; // Actualización exitosa
                }
                }
                return false; // No se encontró la solicitud
        }

        // Método para eliminar una solicitud por ID
        public boolean eliminarSolicitud(int id) {
                return solicitudes.removeIf(solicitud -> solicitud.getSolicitudId() == id);
        }
}
