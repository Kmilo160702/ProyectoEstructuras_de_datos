
package biz;
import java.util.Scanner;
public class BizCola {
    
    public static void main(){
        Cola c = new Cola();
        Scanner teclado = new Scanner(System.in);
        int opcionMenu = 0;
        
        do
            
        {
            System.out.println("-----------------COLAS-------------------");
            System.out.println("1. Insertar        |     4. Atender");
            System.out.println("2. Buscar          |     5. Imprimir");       
            System.out.println("3. Modificar       |     6. Salir"); 
            System.out.println("-----------------------------------------");
            System.out.println(" Escoja una opcion: ");
            System.out.println("                                ");   
           opcionMenu = teclado.nextInt();
           switch (opcionMenu){
               
               case 1:
                   System.out.println("\n\n ISERTAR NODO EN LA COLA\n");
                   c.insertarNodo();
                   break;
                   
               case 2:
                   System.out.println("\n\n BUSCAR NODO EN LA COLA\n");
                   c.buscarNodo();
                   break;
               
               case 3:
                   System.out.println("\n\n MODIFICAR NODO EN LA COLA\n");
                   c.modificarNodo();
                   break;
                   
               case 4:
                   System.out.println("\n\n ATENDER NODO EN LA COLA\n");
                   c.eliminarNodo();
                   break;
                   
               case 5:
                   System.out.println("\n\n DESPLEGAR NODO EN LA COLA\n");
                   c.desplegarCola();
                   break;
                   
               case 6:
                   System.out.println("\n\n Programa finalizado....\n");
                   break;
               default:
                   System.out.println("\n\n Opcion NO Valida\n");
                   System.out.println(0);
                   break;
                
                 
           }
                    
        }
        while (opcionMenu !=6);
    }
}
