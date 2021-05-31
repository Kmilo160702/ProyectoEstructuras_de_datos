package biz;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            //Creamos las opciones para mostrar a la persona.
            System.out.println("\t------ MENÚ DE INICIO -----\t");
            System.out.println("1: Lista enlazada");
            System.out.println("2: Pilas");
            System.out.println("3: Colas");
            System.out.println("4: Cola priorizada");
            System.out.println("5: Salir");

            //Se obtiene el numero ingresado en la consola.
            int opcion = Integer.parseInt(entrada.nextLine());

            //Segun el numero se ejecutara el case indicado.
            switch (opcion) {
                case 1:
                    System.out.println("\t------ LISTA ENLAZADA -----\t");
                    ListaEnlazada Op1 = new ListaEnlazada();
                    Op1.main();
                    break;

                case 2: //Mostrar los datos previamente guardados.
                    System.out.println("\t------ PILAS -----\t");
                    Pilas Op2 = new Pilas();
                    Op2.main();
                    break;
                case 3: //Eliminar datos.
                    System.out.println("\t------ COLAS -----\t");
                    BizCola Op3 = new BizCola();
                    Op3.main();
                    break;
                case 4: //Salir
                    System.out.println("\t------ COLA PRIORIZADA -----\t");
                    //Cola Corzo y jaider
                    ColaPrioridad Op4 = new ColaPrioridad();
                    //Cola Camilo
                    //MainCola Op4 = new MainCola();
                    Op4.main();
                    break;
                case 5: //Salir
                    salir = true;
                    System.out.println("Saliendo.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

}
