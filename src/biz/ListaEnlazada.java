/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public class ListaEnlazada {

    public static void main() {
        Scanner entrada = new Scanner(System.in);
        //Creamos la lista en donde serán almacenados los datos.
        ArrayList<Dato> datos = new ArrayList<>();
        boolean salir = false;
        while (!salir) {
            //Creamos las opciones para mostrar a la persona.
            System.out.println("\n--------------------");
            System.out.println("\tIngrese una opción\t");
            System.out.println("1: Crear datos.");
            System.out.println("2: Lista de datos.");
            System.out.println("3: Eliminar datos.");
            System.out.println("4: Modificar datos.");
            System.out.println("5: Salir.");

            //Se obtiene el numero ingresado en la consola.
            int opcion = Integer.parseInt(entrada.nextLine());

            //Segun el numero se ejecutara el case indicado.
            switch (opcion) {
                case 1: //Ingresar datos nuevos.
                    Dato a = new Dato();
                    System.out.println("Ingrese nombre: ");
                    //Se obtiene el nombre y se almacena.
                    a.setNombre(entrada.nextLine());
                    System.out.println("Ingrese identificación: ");
                    //Se almacena la identificacion.
                    a.setIdentificacion(Integer.parseInt(entrada.nextLine()));
                    System.out.println("Ingrese EPS: ");
                    //Se almacena la EPS.
                    a.setEps(entrada.nextLine());
                    System.out.println("Ingrese su RH: ");
                    //Se almacena el RH.
                    a.setRh(entrada.nextLine());

                    //Los datos almacenados en (a), se agregaran a (datos).
                    datos.add(a);

                    //Mostramos los datos creados.
                    System.out.println("\tDatos creados\t");
                    System.out.println("Nombre: " + a.getNombre());
                    System.out.println("Identificación: " + a.getIdentificacion());
                    System.out.println("EPS: " + a.getEps());
                    System.out.println("RH: " + a.getRh());

                    break;

                case 2: //Mostrar los datos previamente guardados.
                    for (int i = 0; i < datos.size(); i++) {//datos.size permite ver cuantos datos hay guardados.
                        System.out.println("\tPersona:\t " + (i + 1));
                        Dato persona = datos.get(i);
                        System.out.println("Nombre: " + persona.getNombre());
                        System.out.println("Identificacion: " + persona.getIdentificacion());
                        System.out.println("EPS: " + persona.getEps());
                        System.out.println("RH: " + persona.getRh());
                    }
                    break;
                case 3: //Eliminar datos.
                    System.out.println("Ingresar nombre que desea eliminar: ");
                    String nombre = entrada.nextLine();

                    for (int i = 0; i < datos.size(); i++) {
                        Dato persona = datos.get(i);
                        //Buscamos que nombre concuerda con lo que el usuario escribio.
                        if (nombre.equals(persona.getNombre())) {
                            datos.remove(i);
                            System.out.println("Persona eliminada.");
                        }
                    }
                    break;
                case 4://Modificar datos.
                    System.out.println("Ingresa nombre a modificar: ");
                    nombre = entrada.nextLine();

                    for (int i = 0; i < datos.size(); i++) {
                        Dato persona = datos.get(i);
                        if (nombre.equals(persona.getNombre())) {
                            System.out.println("Identificación: " + persona.getIdentificacion());
                            System.out.println("EPS: " + persona.getEps());
                            System.out.println("RH: " + persona.getRh());
                            System.out.println("Ingrese nueva identificación: ");
                            int identificacion = Integer.parseInt(entrada.nextLine());
                            System.out.println("Ingrese nueva EPS: ");
                            String eps = entrada.nextLine();
                            System.out.println("Ingrese nuevo RH: ");
                            String rh = entrada.nextLine();

                            persona.setIdentificacion(identificacion);
                            persona.setEps(eps);
                            persona.setRh(rh);
                        }
                    }
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