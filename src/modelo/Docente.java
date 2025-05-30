package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Docente {
    private int codDocente;
    private String nomDocente;

    public int getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(int codDocente) {
        this.codDocente = codDocente;
    }

    public String getNomDocente() {
        return nomDocente;
    }

    public void setNomDocente(String nomDocente) {
        this.nomDocente = nomDocente;
    }

    public static void insertarDocente (Docente docente){
        Connection conexion = ConexionDB.getConnection();
        
        String sql = "CALL insertar_docente(?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, docente.getNomDocente());

            // INSERT, UPDATE, DELETE
            statement.executeUpdate();

            // SELECT
            // statement.executeQuery();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    
    public static List<Docente> obtenerTodosLosDocentes() {
        List<Docente> listaDocentes = new ArrayList<>();
        String sql = "SELECT cod_docente, nom_docente FROM \"AdminAcademica\".docentes";

        try {
            Connection conexion = ConexionDB.getConnection();
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                Docente docente = new Docente();
                docente.setCodDocente(resultado.getInt("cod_docente"));
                docente.setNomDocente(resultado.getString("nom_docente"));

                listaDocentes.add(docente);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return listaDocentes;
    }
//
//    public static void deleteDocente(int idDocente) { //aqui voy actualizando************
//        Connection conexion = ConexionDatabase.getConnection();
//        String sql = "DELETE FROM estudiante WHERE id = ?";
//
//        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
//            statement.setInt(1, idEstudiante);
//
//            // INSERT, UPDATE, DELETE
//            statement.executeUpdate();
//
//        } catch (Exception error) {
//            error.printStackTrace();
//        }
//    }
//
//    public static void updateEstudiante(Estudiante estudiante) {
//        Connection conexion = ConexionDatabase.getConnection();
//        String sql = "UPDATE estudiante SET nombre = ?, edad = ? WHERE id = ?";
//
//        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
//            statement.setString(1, estudiante.getNombre());
//            statement.setInt(2, estudiante.getEdad());
//            statement.setInt(3, estudiante.getId());
//
//            // INSERT, UPDATE, DELETE
//            statement.executeUpdate();
//
//        } catch (Exception error) {
//            error.printStackTrace();
//        }
//    }
}

