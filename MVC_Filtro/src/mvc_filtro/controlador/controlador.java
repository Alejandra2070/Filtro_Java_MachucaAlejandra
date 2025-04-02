package mvc_filtro.controlador;

import mvc_filtro.modelo.Consultas;
import mvc_filtro.vista.Vista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mvc_filtro.modelo.Ninja;
import mvc_filtro.modelo.asignarMision;
import mvc_filtro.modelo.completarMision;
import mvc_filtro.modelo.misionesDisponibles;
import mvc_filtro.modelo.verMisionesCompletadas;

public class controlador {
    Consultas consultas;
    Vista vista;
    Ninja ninja;
    Scanner scanner;
    verMisionesCompletadas vmc;
    
    public controlador(Consultas consultas, Vista vista){
        this.consultas = consultas;
        this.vista = vista; 
        this.scanner = scanner = new Scanner(System.in);
    }
    
    public void iniciar(){
        while(true){
            System.out.println("------- Menú -------");
            System.out.println("1. Ver todos los ninjas.");
            System.out.println("2. Ver misiones disponibles por ninja.");
            System.out.println("3. Ver misiones completadas por ninja.");
            System.out.println("4. Asignar misión a un ninja.");
            System.out.println("5. Marcar misión como completada.");
            System.out.println("6. Ver todas las misiones completadas.");
            System.out.println("7. Salir.");
            System.out.println("Elige una de nuestras opciones: ");
            int opc = scanner.nextInt();
            
            switch(opc){
                case 1:
                    List<String> listaNinjas = new ArrayList<>();
                    listaNinjas = consultas.MostrarNinjas(ninja);
                    for(String nin : listaNinjas){
                        System.out.println(nin);
                    }
                    System.out.println("Lista de ninjas: ");
                    break;
                    
                case 2:
                    
                    List<String> listaDisponibles = new ArrayList<>();
                    misionesDisponibles md = vista.verMisionesDisponibles();
                    listaDisponibles = consultas.MisionesDisponibles(md);
                    for(String mis : listaDisponibles){
                        System.out.println(mis);
                    }
                    System.out.println("Misiones disponibles: ");
                    break;
                    
                case 3:
                    
                    List<String> listaCompletados = new ArrayList<>();
                    misionesDisponibles md2 = vista.verMisionesCompletadas();
                    listaCompletados = consultas.MisionesCompletadas(md2);
                    for(String mis : listaCompletados){
                        System.out.println(mis);
                    }
                    System.out.println("Misiones completadas: ");
                    break;
                    
                case 4:
                    asignarMision asig1 = vista.asignarMision();
                    consultas.asignarMision(asig1);
                    System.out.println("Misión asignada.");
                    break;
                    
                case 5:
                    completarMision compm = vista.completarMision();
                    consultas.completarMision(compm);
                    System.out.println("Misión completada.");
                    break;
                    
                case 6:
                    List<String> listaCompletas = new ArrayList<>();
                    listaCompletas = consultas.todasMisionesCompletadas(vmc);
                    for(String lis : listaCompletas){
                        System.out.println(lis);
                    }
                    System.out.println("Lista de misiones completadas: ");
                    break;
                    
                case 7:
                    System.out.println("Gracias por usar nuestro programa. Vuelve pronto!");
                    
            }
        }
    }
}
