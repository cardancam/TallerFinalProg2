package controlador;
import modelo.Docente;
import vista.VistaDocente;

public class ControladorDocente {
    private Docente modelo;
    private VistaDocente vista;

    public ControladorDocente(Docente modelo, VistaDocente vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    
}