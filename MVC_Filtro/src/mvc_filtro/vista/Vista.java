package mvc_filtro.vista;

import java.util.List;
import java.util.Scanner;
import mvc_filtro.modelo.Ninja;
import mvc_filtro.modelo.asignarMision;
import mvc_filtro.modelo.completarMision;
import mvc_filtro.modelo.misionesDisponibles;
import mvc_filtro.modelo.verMisionesCompletadas;

public class Vista {
    Scanner scanner = new Scanner(System.in);
    
    public void verNinjas(List<Ninja> ninjas){
        System.out.println("Estos son los ninjas: ");
        for(Ninja n : ninjas){
            System.out.println(n);
        }
    }
    
    public misionesDisponibles verMisionesDisponibles(){
        System.out.println("Ingresa el id del ninja para ver sus misiones disponibles: ");
        int id = scanner.nextInt();
        return new misionesDisponibles(id);
    }
    
    public misionesDisponibles verMisionesCompletadas(){
        System.out.println("Ingresa el id del ninja para ver sus misiones completadas: ");
        int id = scanner.nextInt();
        return new misionesDisponibles(id);
    }
    
    public asignarMision asignarMision(){
        System.out.println("Ingresa los datos para asignar la misión");
        System.out.println("Fecha de inicio de la misión (yyyy-mm-dd): ");
        String fecha = scanner.nextLine();
        System.out.println("Id del ninja: ");
        int idN = scanner.nextInt();
        System.out.println("Id de la misión: ");
        int idM = scanner.nextInt();
        return new asignarMision(fecha, idN, idM);
    }
    
    public completarMision completarMision(){
        System.out.println("Ingresa el id: ");
        int ide = scanner.nextInt();
        System.out.println("Ingresa la fecha de finalización (yyyy-mm-dd): ");
        String fecha = scanner.nextLine();
        return new completarMision(ide, fecha);
    }
    
    public void verTodasMisionesCompletadas(List<verMisionesCompletadas> vmc){
        System.out.println("Estos son los ninjas: ");
        for(verMisionesCompletadas v : vmc){
            System.out.println(v);
        }
    }
}
