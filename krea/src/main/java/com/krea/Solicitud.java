package com.krea;
public class Solicitud {
    private int solicitudId;
    private String nombreSolicitud;
    private String fechaSolicitud;
    private String temaSolicitud;
    private String descripcionSolicitud;
    private String estadoSolicitud;

    // Constructor
    public Solicitud(int solicitudId, String nombreSolicitud, String fechaSolicitud, String temaSolicitud, String descripcionSolicitud, String estadoSolicitud) {
        this.solicitudId = solicitudId;
        this.nombreSolicitud = nombreSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.temaSolicitud = temaSolicitud;
        this.descripcionSolicitud = descripcionSolicitud;
        this.estadoSolicitud = estadoSolicitud;
    }

    // Getters y Setters
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

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
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
    return "Solicitud{" +
            "solicitudId=" + solicitudId +
            ", nombreSolicitud='" + nombreSolicitud + '\'' +
            ", fechaSolicitud='" + fechaSolicitud + '\'' +
            ", temaSolicitud='" + temaSolicitud + '\'' +
            ", descripcionSolicitud='" + descripcionSolicitud + '\'' +
            ", estadoSolicitud='" + estadoSolicitud + '\'' +
            '}';
}

    }

