package biz;

import java.util.Scanner;

public class MainCola {

    public static void main() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Prueba cola de prioridades\n");
        System.out.print("Ingresa el tamaño de la cola de prioridades: ");
        ColaDePrioridad oColaDePrioridad = new ColaDePrioridad(entrada.nextInt());
        char ch;
        do {
            System.out.println("\nOperaciones cola de prioridades\n");
            System.out.println("1. Insertar");
            System.out.println("2. Atender");
            System.out.println("3. Comprobar si esta vacia");
            System.out.println("4. Comprobar si esta llena");
            System.out.println("5. Limpiar");
            System.out.println("6. Tamaño");
            System.out.println("7. Mostrar");

            int opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre y la prioridad");
                    oColaDePrioridad.insertar(entrada.next(), entrada.nextInt());
                    break;
                case 2:
                    System.out.println("\nPersona atendida\n\n" + oColaDePrioridad.borrar()); // Cambiar
                    break;
                case 3:
                    System.out.println("\nEstado vacio: " + oColaDePrioridad.isEmpty());
                    break;
                case 4:
                    System.out.println("\nEstado lleno: " + oColaDePrioridad.isFull());
                    break;
                case 5:
                    System.out.println("\nCola de prioridades limpia");
                    oColaDePrioridad.limpiar();
                    break;
                case 6:
                    System.out.println("\nTamaño = " + oColaDePrioridad.size());
                    break;
                case 7:
                    System.out.println("Mostrando cola de prioridades:");
                    oColaDePrioridad.mostar();
                    break;
                default:
                    System.out.println("Número no valido\n");
                    break;
            }
            System.out.println("\nDesea continuar (y o n)\n");
            ch = entrada.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}