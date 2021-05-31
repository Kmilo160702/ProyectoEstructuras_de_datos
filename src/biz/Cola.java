
package biz;

import java.util.Scanner;
public class Cola {
    
    Nodo primero;
    Nodo ultimo;
    Scanner teclado = new Scanner(System.in);
   
    public Cola(){
        primero = null;
        ultimo = null;
        
    }
    
    public void insertarNodo(){
        Nodo nuevo = new Nodo();
        System.out.print (" Ingresar dato:  " );
        nuevo.dato = teclado.nextLine();
        if(primero == null){
            primero = nuevo;
            primero.siguiente = null;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = null;
            ultimo = nuevo;
            
        }
        System.out.print("\n Dato ingresado con exito \n");
        
    }
    
    public void buscarNodo(){
        
        Nodo actual = new Nodo();
        actual = primero;
        boolean encontrado = false;
        System.out.print(" Ingrese el dato del nodo a buscar : ");
        String nodoBuscado = teclado.nextLine();
        
        if(primero !=null){
            while(actual !=null && encontrado != true){
                if(actual.dato.equals(nodoBuscado)){
                   System.out.println("\n Nodo con el dato (" +actual.dato + ") Encontrado \n");
                   encontrado = true;
                }
              
                actual = actual.siguiente;
            }
            if(!encontrado){
                System.out.println(" \n Nodo no encontrado, revise de nuevo \n");
                
            }
        }else{
            System.out.print("\n La lista de la cola se encuentra vacia\n");
            
        }
        
    }
    
    public void modificarNodo(){
         Nodo actual = new Nodo();
        actual = primero;
        boolean encontrado = false;
        System.out.print(" Ingrese el dato del nodo a modificar : ");
        String nodoBuscado = teclado.nextLine();
        
        if(primero !=null){
            while(actual !=null && encontrado != true){
                if(actual.dato.equals(nodoBuscado)){
                   System.out.println("\n Nodo con el dato (" +actual.dato + ") Encontrado \n");
                   System.out.println(" Ingrese el nuevo dato para el nodo : ");
                   actual.dato = teclado.nextLine();
                   System.out.println("\n El nodo se ha modificado");
                   encontrado = true;
                }
              
                actual = actual.siguiente;
            }
            if(!encontrado){
                System.out.println(" \n Nodo no encontrado, revise de nuevo \n");
                
            }
        }else{
            System.out.print("\n La lista de la cola se encuentra vacia\n");
            
        }
    }
    
    public void eliminarNodo(){
        Nodo actual = new Nodo();
        actual = primero;
        Nodo anterior = new Nodo();
        anterior = null;
        boolean encontrado = false;
        //System.out.print(" Ingrese el dato del nodo que quiere Eliminar : ");
        //String nodoBuscado = teclado.nextLine();
        
        if(primero !=null){
            while(actual !=null && encontrado != true){

                    
                    if(actual == primero){
                       primero = primero.siguiente;
                    }else if(actual == ultimo){
                       anterior.siguiente = null;
                       ultimo = anterior;
                    }else{
                       anterior.siguiente = actual.siguiente;
                    }
                   System.out.println("\n Nodo eliminado y/o atendido\n");
                   encontrado = true;
                }
                anterior = actual;
                actual = actual.siguiente;
            
        }else{
            System.out.print("\n La lista de la cola se encuentra vacia\n");
            
        }
    }
    
    public void desplegarCola(){
        Nodo actual = new Nodo();
        actual = primero;
        if(primero !=null){
            while(actual !=null){
                System.out.println(" " + actual.dato);
                actual = actual.siguiente;
            }
        }else{
            System.out.print("\n La lista de la cola se encuentra vacia\n");
            
        }
        
    }
    
    
}
