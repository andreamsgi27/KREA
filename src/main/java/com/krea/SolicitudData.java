package com.krea;

import java.util.ArrayList;
import java.util.List;

public class SolicitudData {
        private List<SolicitudDatabase> solicitudes;

        public SolicitudData() {
                solicitudes = new ArrayList<>();
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
