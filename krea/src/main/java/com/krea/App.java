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
            try{
                System.out.println("¿Eres técnico o empleado? Escribe T o E (S para salir)" );
            rol = scanner.nextLine();
            if  (rol.equalsIgnoreCase("T")) {
                Tecnico.main(args);
                break;
            } else if (rol.equalsIgnoreCase("E")){
                Empleado.main(args);
                break;
            } else if (rol.equalsIgnoreCase("S")){
                break;
            } else {
                System.out.println("No has escrito T o E");
                //check = false;
            }
            } catch  (Exception e) {
                System.out.println("Error");
            }

            
            
        }
        




        System.out.println("Gracias por usar nuestro programa");
        scanner.close();
    }

    
}
