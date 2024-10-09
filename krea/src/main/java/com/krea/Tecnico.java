package com.krea;

import java.util.Scanner;

public class Tecnico {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        SolicitudCRUD solicitudCRUD = new SolicitudCRUD();
        int opciones;
        boolean check = true;
        
        
        while (check){
            try {
                    System.err.println("");
                    System.out.println("[1 - Ver solicitudes] [2 - Cambiar estado de Solicitud] [3 - Editar Solicitud] [4 - Eliminar Solicitud] [5 - Salir]");
                opciones = scanner.nextInt();
                if (opciones == 1) {
                    solicitudCRUD.mostrarSolicitudes();

                }

                else if (opciones == 2){
                    System.out.println("el 2");
                    //SolicitudCRUD.cambiarestadoSolicitud();

                }

                else if (opciones == 3){
                    //SolicitudCRUD.actualizarSolicitud();
                    System.out.println("el 3");
                }
                
                else if (opciones == 4){
                    //SolicitudCRUD.eliminarSolicitud();
                    System.out.println("el 4");
                }
                
                else if (opciones == 5) {
                    break;
                }
                
                else {
                    System.out.println("No has escrito bien el número");
                    check = false;
                }
            
            } catch (Exception e) {
                System.out.println("Entrada no válida.");
            }
            
        }
        //scanner.close(); no se pone aquí, nos cierra el scanner del bucle principal
    }
}
