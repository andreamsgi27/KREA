package com.krea;

import java.io.Serializable;
import java.time.LocalDate;

public class SolicitudDatabase implements Serializable {
    private static final long serialVersionUID = 1L;

    private int solicitudId;
    private String nombreSolicitud;
    private LocalDate fechaSolicitud;
    private String temaSolicitud;
    private String descripcionSolicitud;
    private String estadoSolicitud;

    public SolicitudDatabase(int solicitudId, String nombreSolicitud, LocalDate fechaSolicitud,
            String temaSolicitud, String descripcionSolicitud, String estadoSolicitud) {
        this.solicitudId = solicitudId;
        this.nombreSolicitud = nombreSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.temaSolicitud = temaSolicitud;
        this.descripcionSolicitud = descripcionSolicitud;
        this.estadoSolicitud = estadoSolicitud;
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getNombreSolicitud() {
        return nombreSolicitud;
    }

    public void setNombreSolicitud(String nombreSolicitud) {
        this.nombreSolicitud = nombreSolicitud;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getTemaSolicitud() {
        return temaSolicitud;
    }

    public void setTemaSolicitud(String temaSolicitud) {
        this.temaSolicitud = temaSolicitud;
    }

    public String getDescripcionSolicitud() {
        return descripcionSolicitud;
    }

    public void setDescripcionSolicitud(String descripcionSolicitud) {
        this.descripcionSolicitud = descripcionSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Override
    public String toString() {
        return "       " + solicitudId + "    " +
                "-->> " + estadoSolicitud +" <<--\n" +
                "\n            [ " + fechaSolicitud + " ]    " +
                "\n            Nombre: " + nombreSolicitud + "    " +
                "\n            Tema:  " + temaSolicitud + "    " +
                "\n            Descripción: " + descripcionSolicitud + "\n\n";
    }

}