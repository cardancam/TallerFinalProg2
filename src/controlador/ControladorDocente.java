package controlador;
import modelo.Docente;
import vista.VistaDocenteGUI;

public class ControladorDocente {
    private Docente modelo;
    private VistaDocenteGUI vista;

    public ControladorDocente(Docente modelo, VistaDocenteGUI vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void setNombreDocente(String nombre) {
        modelo.setNomDocente(nombre);
    }

    public String getNombreDocente() {
        return modelo.getNomDocente();
    }
    
    public void crearDocente(Docente nuevoDocente){
        nuevoDocente.insertarDocente(nuevoDocente);
        System.out.println("Docente creado correctamente!");
    }
}