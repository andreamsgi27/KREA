package com.krea;

import java.time.LocalDate;
import java.util.ArrayList;

public class SolicitudData {
    public static void main(String[] args) {

        ArrayList<SolicitudDatabase> solicitudes = new ArrayList<>();
        solicitudes.add(new SolicitudDatabase(1, "Juan Perez", LocalDate.parse("2024-09-15"), 
                "Consulta Técnica", "Problema con acceso a la base de datos", "Atendida"));
        
        solicitudes.add(new SolicitudDatabase(2, "Maria Lopez", LocalDate.parse("2024-09-17"),
                "Revisión de Proyecto", "Revisión del proyecto de inteligencia artificial", "En curso"));

        solicitudes.add(new SolicitudDatabase(3, "Carlos Garcia", LocalDate.parse("2024-09-18"), 
                "Consulta Médica", "Problema con un medicamento", "Atendida"));

        solicitudes.add(new SolicitudDatabase(4, "Ana Martínez", LocalDate.parse("2024-09-19"), 
                    "Consulta Técnica", "Error en la configuración", "Pendiente"));

        solicitudes.add(new SolicitudDatabase(5, "Luis Torres", LocalDate.parse("2024-09-20"), 
                    "Revisión de Proyecto", "Necesito ayuda con el código", "En curso"));

        solicitudes.add(new SolicitudDatabase(6, "Sofía Jiménez", LocalDate.parse("2024-09-21"), 
                    "Consulta Técnica", "Fallo en el sistema", "Atendida"));

        solicitudes.add(new SolicitudDatabase(7, "Javier Romero", LocalDate.parse("2024-09-22"), 
                    "Revisión de Proyecto", "Revisar el diseño de la interfaz", "Pendiente"));

        solicitudes.add(new SolicitudDatabase(8, "Laura Medina", LocalDate.parse("2024-09-23"), 
                    "Consulta Médica", "Consulta de rutina", "En curso"));

        solicitudes.add(new SolicitudDatabase(9, "David Flores", LocalDate.parse("2024-09-24"), 
                    "Consulta Técnica", "Problema con el acceso a la red", "Atendida"));

        solicitudes.add(new SolicitudDatabase(10, "María Ruiz", LocalDate.parse("2024-09-25"), 
                    "Revisión de Proyecto", "Mejoras en la presentación", "Pendiente"));

        solicitudes.add(new SolicitudDatabase(11, "Pedro Sánchez", LocalDate.parse("2024-09-26"), 
                    "Consulta Técnica", "Dificultades en el análisis de datos", "En curso"));

        solicitudes.add(new SolicitudDatabase(12, "Isabel Castro", LocalDate.parse("2024-09-27"), 
                    "Consulta Médica", "Consulta sobre síntomas", "Atendida"));

        solicitudes.add(new SolicitudDatabase(13, "Andrés Morales", LocalDate.parse("2024-09-28"), 
                    "Revisión de Proyecto", "Revisión de código de backend", "Pendiente"));

        solicitudes.add(new SolicitudDatabase(14, "Elena Torres", LocalDate.parse("2024-09-29"), 
                    "Consulta Técnica", "Problema con la instalación", "Atendida"));

        solicitudes.add(new SolicitudDatabase(15, "Fernando López", LocalDate.parse("2024-09-30"), 
                    "Consulta Médica", "Problema digestivo", "En curso"));

        solicitudes.add(new SolicitudDatabase(16, "Clara Ramírez", LocalDate.parse("2024-10-01"), 
                    "Consulta Técnica", "Duda sobre API", "Pendiente"));

        solicitudes.add(new SolicitudDatabase(17, "Roberto Díaz", LocalDate.parse("2024-10-02"), 
                    "Revisión de Proyecto", "Revisión del informe final", "Atendida"));

        solicitudes.add(new SolicitudDatabase(18, "Valeria Herrera", LocalDate.parse("2024-10-03"), 
                    "Consulta Técnica", "Fallo en el servidor", "En curso"));

        solicitudes.add(new SolicitudDatabase(19, "Hugo Vargas", LocalDate.parse("2024-10-04"), 
                    "Consulta Médica", "Chequeo anual", "Pendiente"));

        solicitudes.add(new SolicitudDatabase(20, "Patricia Morales", LocalDate.parse("2024-10-05"), 
                    "Revisión de Proyecto", "Consulta sobre funcionalidades", "Atendida"));

        solicitudes.add(new SolicitudDatabase(21, "Ricardo Silva", LocalDate.parse("2024-10-06"), 
                    "Consulta Técnica", "Error en la aplicación", "En curso"));

        solicitudes.add(new SolicitudDatabase(22, "Nadia Cruz", LocalDate.parse("2024-10-07"), 
                    "Consulta Médica", "Síntomas de alergia", "Pendiente"));

                
        // Tienen que haber tres funciones dentro esta clase; cómo mostrar las solicitudes y seleccionar solicitud dentro del arraylist
        // cómo marcar y/o sleccionar y/o modificar una solicitud
        // Para imprimir los datos; ¿sería un read? 
        System.out.println("\nLista de Solicitudes:");
        for (SolicitudDatabase solicitud : solicitudes) {
        System.out.println(solicitud);
        } 
    }
}




        