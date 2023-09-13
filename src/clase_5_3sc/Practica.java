/*
menu que te de la bienvenida
agregar
ver
salir
actualizar
eliminar con confirmación
poder ordenar la play list sort ¡reacomoda y cambian los indices!
*/
package clase_5_3sc;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Collections;

public class Practica {
    
    public static ArrayList<String> playlist = new ArrayList<String>();
    
    
    public static int cap_num(String cad){
        try{
            return Integer.parseInt(JOptionPane.showInputDialog(cad));
        }catch(Exception e){
            msj("Escribe con números enteros");
            return cap_num(cad);
        }
    }
    
    
    public static String cap_cad(String cad){
        return JOptionPane.showInputDialog(cad);
    }
    
    
    public static void msj(String cad){
        JOptionPane.showMessageDialog(null, cad);
    }
    
    
    public static void menu(){
        menu_run(cap_num("Bienvenido a tu PlayList\n¿Qué deseas hacer?\n(1) agregar\n(2) ver\n(3) actualizar playlist\n(4) eliminar\n(5) ordenar PlayList de A-Z\n(6) salir de tu PlayList \nEscriba el número de la opción"));
    }
    
    
    public static void menu_run(int recib){
        switch (recib) {
            case 1: //agregar
                agregar();
                menu();
                break;
            case 2: //ver
                ver();
                menu();
                break;
            case 3: //actualizar
                actualizar_playlist();
                ver();
                menu();
                break;
            case 4: //eliminar
                if(playlist.isEmpty()){
                    if(JOptionPane.showConfirmDialog(null,"La PlayList esta vacia\n¿Quieres agregar una cancion?",null,0,JOptionPane.YES_NO_OPTION)==0){
                        agregar();
                        menu();
                    }else{
                        menu();
                    }
                }else{
                    eliminar(cap_num("¿Quiere eliminar una cancion o toda la playlist?\nEscriba 1 si quiere eliminar una canción\nEscriba 2 si quiere eliminar la playlist"));
                    ver();
                    menu();
                }
                break;
            case 5://Acomodo
                acomodo();
                menu();
                break;
                
            case 6://Salir
                msj("Saliste de tu PlayList");
                break;
            default:
                msj("El programa solo funciona con las opcciones indicadas, intente de nuevo");
                menu();
                
        }
    }
    
    
    public static void ver(){
        if(playlist.isEmpty()){
            if(JOptionPane.showConfirmDialog(null,"PlayList vacia\n¿Desea agregar una cancion?",null,0,JOptionPane.YES_NO_OPTION)==0){
                agregar();
            }else
                menu();
        }else{
            String acumula="";
                for (int i = 0; i < playlist.size(); i++) {
                    acumula+=(i+1)+" "+playlist.get(i)+"\n";
                }
            msj("PlayList\n"+acumula);
            
        }
    }
    
    
    public static void eliminar(int dato){
        int datito=0;
        do{
            if(1==dato){
                String acumula="";
                for (int i = 0; i < playlist.size(); i++) {
                    acumula+=(i+1)+" "+playlist.get(i)+"\n";
                }
                try{
                    datito=cap_num("PlayList\n"+acumula+"Ingresa el número de la canción que deseas eliminar");
                    if(JOptionPane.showConfirmDialog(null,"¿Estás seguro de eliminar "+playlist.get(datito-1)+"?",null,0,JOptionPane.YES_NO_OPTION)==0){
                        playlist.remove(datito-1);
                    }else{
                        eliminar(dato);
                    }
                }catch(Exception e){
                    eliminar(dato);
                }
            }else if(2==dato){
                playlist.clear();
            }else{
                msj("Solo hay dos opcciones wey");
                eliminar(dato);
            }
        }while (JOptionPane.showConfirmDialog(null,"¿Quieres eliminar algo más?",null,0,JOptionPane.YES_NO_OPTION)==0);
    }
    
    
    public static void actualizar_playlist(){
        String acumula="";
        for (int i = 0; i < playlist.size(); i++) {
            acumula+=(i+1)+" "+playlist.get(i)+"\n";
        }
        try{
            playlist.set((cap_num(acumula+"\nEscoja el número de la canción que quiere actualizar"))-1, cap_cad("\"Ingresa la cancion nueva\""));
        }catch(Exception e){
            msj("ese numero de cancion no existe");
            actualizar_playlist();
        }
                
    }
    
    
    public static void agregar(){
        String acumula="";
        do{
            acumula="";
            playlist.add(cap_cad("Ingrese la canción que desea agregar"));
            
            for (int i = 0; i < playlist.size(); i++) {
                acumula+=(i+1)+" "+playlist.get(i)+"\n";
            }
        }while (JOptionPane.showConfirmDialog(null,"Esta es tu PlayList\n"+acumula+"\n¿Desea agregar otra canción?",null,0,JOptionPane.YES_NO_OPTION)==0);
    }
    
    
    public static void acomodo(){
        Collections.sort(playlist);
        ver();
    }
    
    
    public static void main(String[] args) {
        menu(); 
    }
}
//githup crear cuenta, es pa la tarea pa
//subir proyecto
//dar acceso a rama de trabajo pra dar acceso