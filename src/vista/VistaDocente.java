/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import modelo.Docente;
public class VistaDocente {
    public void mostrarTodosLosEstudiantes(List<Docente> docentes) {
    for (Docente e : docentes) {
        System.out.println("Codigo: " + e.getCodDocente()+ ", Edad: " + e.getNomDocente());
    }
}
}
