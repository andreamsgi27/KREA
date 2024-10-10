package com.krea;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new  Scanner(System.in);
        String rol;
        boolean check = true;
        String azul = "\033[1;36m";
        String reset = "\033[0m";

        while (check){
            try {
                System.out.println("===========================================\n");
                System.out.println(azul + "           SELECCIÓN DE USUARIO          " + reset);
                System.out.println("\n===========================================");
                System.out.println("\n        ¿Eres Técnico o Empleado?         ");
                System.out.println("             Escribe T o E               ");
                System.out.println("             (S para salir)              \n");
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
