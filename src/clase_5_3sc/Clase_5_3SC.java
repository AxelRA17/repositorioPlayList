/*
ArrayList
*/
package clase_5_3sc;

import java.util.ArrayList;

public class Clase_5_3SC {
    public static void main(String[] args) {
        //ArrayList<String> corridos = new ArrayList<>(); -> También puedes escribirlo así
        ArrayList<String> canciones = new ArrayList<String>();
        //método 1
        canciones.add("no sé");
        canciones.add("el que quiera una cancion");
        canciones.add("se fue la luz");
        System.out.println(canciones);
        canciones.add("una pieza que no se baila");
        System.out.println(canciones);
        
        //métodos para ArrayList
        System.out.println(canciones.get(1));//Te entrega el valor que pides por el Index
        System.out.println(canciones.size());//Te entrega la longitud del ArrayList
        canciones.remove(0);//Elimina el valor que deseas por el Index
        canciones.set(2, "alma enamorada");//Actualizacion de valor
        canciones.clear();//Limpia el ArrayList
        
        
        
    }
    
}
