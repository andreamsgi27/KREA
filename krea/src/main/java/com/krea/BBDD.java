package com.krea;

public class BBDD {
    int id;
    String nombreSolicitante;
    String fechaSolicitud;
    String temaSolicitud;
    String descripcionSolicitud;
    String estadoSolicitud;
    
    public BBDD(int id, String nombreSolicitante, String fechaSolicitud, String temaSolicitud, String descripcionSolicitud, String estadoSolicitud) {
        this.id = id;
        this.nombreSolicitante = nombreSolicitante;
        this.fechaSolicitud = fechaSolicitud;
        this.temaSolicitud = temaSolicitud;
        this.descripcionSolicitud = descripcionSolicitud;
        this.estadoSolicitud = estadoSolicitud;
    }

    // Override
    public String toString() {
        return "Solicitud{id= " + id + ", nombreSolicitante='" + nombreSolicitante + "',
        fechaSolicitud='" + fechaSolicitud + "', temaSolicitud='" + temaSolicitud + "', descripcionSolicitud='" + descripcionSolicitud + "',
        estadoSolicitud='" + estadoSolicitud + "'}";

}
    }
