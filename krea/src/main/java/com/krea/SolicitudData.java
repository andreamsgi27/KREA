package com.krea;

import java.util.ArrayList;

public class SolicitudData {
    public static void main(String[] args) {

        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(new Solicitud(1,   "Juan Perez", "2024-09-15", 
        "Consulta Técnica", "Problema con acceso a la base de datos",
        "Atendida"));
        solicitudes.add(new Solicitud(2, "Maria Lopez", "2024-09-17",
        "Revisión de Proyecto", "Revisión del proyecto de inteligencia artificial",
        "En curso"));

        // Tienen que haber tres funciones dentro esta clase; cómo mostrar las solicitudes y seleccionar solicitud dentro del arraylist
        // cómo marcar y/o sleccionar y/o modificar una solicitud
        // Para imprimir los datos; ¿sería un read? 
        System.out.println("\nLista de Solicitudes:");
        for (Solicitud solicitud : solicitudes) {
        System.out.println(solicitud);
        } 
    }
}




        