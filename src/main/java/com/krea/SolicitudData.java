package com.krea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitudData {
        private List<SolicitudDatabase> solicitudes;

        public SolicitudData() {
                solicitudes = new ArrayList<>();
                cargarSolicitudes();
        }

        private void cargarSolicitudes() {
                solicitudes.add(new SolicitudDatabase(1, "Juan Perez", LocalDate.parse("2024-09-15"), 
                        "Consulta Técnica", "Problema con acceso a la base de datos", "Atendida"));
                solicitudes.add(new SolicitudDatabase(2, "Maria Lopez", LocalDate.parse("2024-09-17"),
                        "Revisión de Proyecto", "Revisión del proyecto de inteligencia artificial", "En curso"));
                solicitudes.add(new SolicitudDatabase(22, "Nadia Cruz", LocalDate.parse("2024-10-07"), 
                        "Consulta Médica", "Síntomas de alergia", "Pendiente"));
        }

        public void mostrarSolicitudes() {
                System.out.println("\nLista de Solicitudes:");
                for (SolicitudDatabase solicitud : solicitudes) {
                System.out.println(solicitud);
                }
        }

        public SolicitudDatabase obtenerSolicitudPorId(int id) {
                for (SolicitudDatabase solicitud : solicitudes) {
                if (solicitud.getSolicitudId() == id) {
                        return solicitud;
                }
                }
                return null;
        }

        public void agregarSolicitud(SolicitudDatabase nuevaSolicitud) {
                solicitudes.add(nuevaSolicitud);
        }

        public boolean actualizarSolicitud(SolicitudDatabase solicitudActualizada) {
                for (int i = 0; i < solicitudes.size(); i++) {
                if (solicitudes.get(i).getSolicitudId() == solicitudActualizada.getSolicitudId()) {
                        solicitudes.set(i, solicitudActualizada);
                        return true;
                }
                }
                return false;
        }

        public boolean eliminarSolicitud(int id) {
                return solicitudes.removeIf(solicitud -> solicitud.getSolicitudId() == id);
        }
}
