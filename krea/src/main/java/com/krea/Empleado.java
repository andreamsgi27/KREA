package com.krea;

import java.util.Scanner;

public class Empleado {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int opciones;
        boolean check = true;
        
        
        while (check = true){
            try {
                    System.out.println("[1 - Nueva Solicitud] [2 - Modificar Solicitud] [3 - Ver Solicitudes] [4 - Cerrar]");
                opciones = scanner.nextInt();
                if (opciones == 1) {
                    System.out.println("el 1");
                    SolicitudCRUD.crearSolicitud();

                } else if (opciones == 2){
                    System.out.println("el 2");
                    //Solicitud.modificarSolicitud();

                } else if (opciones == 3){
                    //Solicitud.mostrarLista();

                    System.out.println("el 3");
                } else if (opciones == 4) {
                    break;
                } else {
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
