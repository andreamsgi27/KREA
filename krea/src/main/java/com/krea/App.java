package com.krea;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new  Scanner(System.in);
        String rol;
        boolean check = true;
        while (check){
            try {
                // Imprimir un título destacado
                System.out.println("===========================================");
                System.out.println("           SELECCIÓN DE USUARIO          ");
                System.out.println("===========================================");
                System.out.println("===========================================");
                System.out.println("        ¿Eres técnico o empleado?         ");
                System.out.println("             Escribe T o E               ");
                System.out.println("             (S para salir)              ");
                System.out.println("===========================================");
                System.out.println("===========================================");
                
                rol = scanner.nextLine();
                if (rol.equalsIgnoreCase("T")) {
                    Tecnico.main(args);
                    break;
                } else if (rol.equalsIgnoreCase("E")) {
                    Empleado.main(args);
                    break;
                } else if (rol.equalsIgnoreCase("S")) {
                    break;
                } else {
                    System.out.println("No has escrito T o E");
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
            
        }
        scanner.close();
    }

    
}
