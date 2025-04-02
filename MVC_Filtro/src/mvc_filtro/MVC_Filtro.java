package mvc_filtro;

import mvc_filtro.modelo.Consultas;
import mvc_filtro.controlador.controlador;
import mvc_filtro.vista.Vista;

public class MVC_Filtro {

    public static void main(String[] args) {
        Consultas consultas = new Consultas();
        Vista vista = new Vista();
        controlador ctr = new controlador(consultas, vista);
        
        ctr.iniciar();
    }
    
}
