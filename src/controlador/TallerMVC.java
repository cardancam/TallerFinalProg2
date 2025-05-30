package controlador;

import modelo.ConexionDB;
import modelo.Docente;
import vista.VistaDocente;

public class TallerMVC {

    public static void main(String[] args) {
        Docente.obtenerTodosLosDocentes();
        Docente.deleteDocente(103);
        
        
    }    
}
