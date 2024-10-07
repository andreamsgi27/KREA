package com.krea;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new  Scanner(System.in);
        String rol;
        boolean check = true;
        while (check = true){
            System.out.println("¿Eres técnico o empleado? Escribe T o E (S para salir)" );
            rol = scanner.nextLine();
            if  (rol.equalsIgnoreCase("T")) {
                //Tecnico.main(args);
                System.out.println("Bienvenido técnico");
                //break;
            } else if (rol.equalsIgnoreCase("E")){
                //Empleado.main(args);
                System.out.println("Bienvenido empleado");
                //break;
            } else if (rol.equalsIgnoreCase("S")){
                break;
            } else {
                System.out.println("No has escrito T o E");
                check = false;
            }
            
        }
        




        System.out.println("Gracias por usar nuestro programa");
        scanner.close();
    }

    
}
