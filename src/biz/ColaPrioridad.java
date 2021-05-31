package biz;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class prioridadQueue {

    Nodo primero;
    Nodo ultimo;
    private Task[] monton;
    private int tamaño, capacidad;

    public prioridadQueue(int capacidad) {
        this.capacidad = capacidad;
        monton = new Task[this.capacidad];
        tamaño = 0;

    }

    public void limpiar() {
        monton = new Task[capacidad];
        tamaño = 0;
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public boolean isFull() {
        return tamaño == capacidad - 1;
    }

    public int size() {
        return tamaño;
    }

    public void insertar(String nombre, int prioridad) {

        Task oNombre = new Task(nombre, prioridad);

        monton[tamaño] = oNombre;
        int pos = tamaño++;
        while (pos != 1 && oNombre.prioridad > monton[pos / 2].prioridad) {
            monton[pos] = monton[pos / 2];
            pos /= 2;

        }

        monton[pos] = oNombre;

    }

    public Task borrar() {
        int padre;
        int hijo;
        Task item;
        Task temp;
        if (isEmpty()) {
            System.out.println("Vacio");
            return null;
        }
        item = monton[1];
        temp = monton[tamaño--];
        padre = 1;
        hijo = 2;
        while (hijo <= tamaño) {
            if (hijo < tamaño && monton[hijo].prioridad < monton[hijo + 1].prioridad) {
                hijo++;
            }
            if (temp.prioridad >= monton[hijo].prioridad) {
                break;
            }

            monton[padre] = monton[hijo];
            padre = hijo;
            hijo *= 2;
        }
        monton[padre] = temp;
        return item;
    }

    public Task remove() {
        int padre, hijo;
        Task item, temp;
        if (isEmpty()) {
            System.out.println("Vacio");
            return null;
        }

        item = monton[1];
        temp = monton[tamaño--];

        padre = 1;
        hijo = 2;
        while (hijo <= tamaño) {
            if (hijo < tamaño && monton[hijo].prioridad < monton[hijo + 1].prioridad) {
                hijo++;
            }
            if (temp.prioridad >= monton[hijo].prioridad) {
                break;
            }

            monton[padre] = monton[hijo];
            padre = hijo;
            hijo *= 2;
        }
        monton[padre] = temp;

        return item;
    }

    public void imprimir(Task[] array) {
        //Arrays.sort(monton);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            } else {
                System.out.println((i + 1) + ". " + array[i].nombre + " Prioridad: " + array[i].prioridad);

            }

        }

    }

    public Task[] obtienearreglo() {
        return this.monton;
    }

}

class Task implements Comparable<Task> {

    String nombre;
    int prioridad;

    public Task(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "nombre Name : " + nombre + "\nprioridad : " + prioridad;
    }

    @Override
    public int compareTo(Task t) {
        if (prioridad < t.prioridad) {
            return -1;
        }
        if (prioridad > t.prioridad) {
            return 1;
        }
        return 0;
    }

}

public class ColaPrioridad {

    public static void main() {
        Task[] array = new Task[2];
        array[0] = new Task("felipe", 10);
        array[1] = new Task("julian", 9);
        Scanner scan = new Scanner(System.in);
        System.out.println("Prueba cola de prioridad\n");

        System.out.println("Ingresa el tamaño de la cola de prioridad: ");
        prioridadQueue pq = new prioridadQueue(scan.nextInt());

        char ch;

        do {
            System.out.println("\nOperaciones cola de prioridad\n");
            System.out.println("1. Insertar");
            System.out.println("2. Borrar");
            System.out.println("3. Comprobar si esta vacia");
            System.out.println("4. Comprobar si esta llena");
            System.out.println("5. limpiar");
            System.out.println("6. Tamaño");
            System.out.println("7. Imprimir");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Ingresa el nombre y la prioridad");
                    pq.insertar(scan.next(), scan.nextInt());
                    break;
                case 2:
                    System.out.println("\nNombre borrado \n\n" + pq.remove());
                    break;
                case 3:
                    System.out.println("\nEstado vacio: " + pq.isEmpty());
                    break;
                case 4:
                    System.out.println("\nEstado lleno: " + pq.isFull());
                    break;
                case 5:
                    System.out.println("\nCola de prioridad limpia");
                    pq.limpiar();
                    break;
                case 6:
                    System.out.println("\nTamaño = " + pq.size());
                    break;
                case 7:
                    System.out.println("\n Imprimiendo..... ");
                    Arrays.sort(pq.obtienearreglo());
                    pq.imprimir(pq.obtienearreglo());
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            //System.out.println("\nDesea continuar (y o n) \n");
            ch = 121;
        } while (ch == 'Y' || ch == 'y');
    }
}
