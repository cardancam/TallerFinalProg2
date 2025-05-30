package controlador;
import java.util.List;
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
    
    public void crearEstudiante(Docente nuevoDocente){
        nuevoDocente.insertarDocente(nuevoDocente);
        System.out.println("Docente creado correctamente!");
    }
    
    public List<Docente> obtenerDocente() {
        return modelo.obtenerTodosLosDocentes();
    }
    
    public void removerEstudiante(int id){
        modelo.deleteDocente(id);
        System.out.println("Docente con id " + id + " eliminado correctamente!");
    }
    
    public void actualizarEstudiante(Docente docente){
        modelo.updateDocente(docente);
        System.out.println("Docente actualizado correctamente!");
    }
}