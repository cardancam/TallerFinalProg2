package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private int codEstudiante;
    private String nomEstudiante;

    public int getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(int codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getNomEstudiante() {
        return nomEstudiante;
    }

    public void setNomEstudiante(String nomEstudiante) {
        this.nomEstudiante = nomEstudiante;
    }
    
    public static void insertarEstudiante (Estudiante estudiante){
        Connection conexion = ConexionDB.getConnection();
        
        String sql = "CALL insertar_docente(?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, estudiante.getNomEstudiante());

            // INSERT, UPDATE, DELETE
            statement.executeUpdate();

            // SELECT
            // statement.executeQuery();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    
    public static List<Estudiante> obtenerTodosLosEstudiantes() {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        String sql = "SELECT cod_estudiante, nom_estudiante FROM \"AdminAcademica\".estudiante";

        try {
            Connection conexion = ConexionDB.getConnection();
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setCodEstudiante(resultado.getInt("cod_estudiante"));
                estudiante.setNomEstudiante(resultado.getString("nom_estudiante"));

                listaEstudiantes.add(estudiante);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return listaEstudiantes;
    }
    public static void deleteDocente(int idEstudiante) {
        Connection conexion = ConexionDB.getConnection();
        String sql = "DELETE FROM \"AdminAcademica\".estudiante WHERE cod_estudiante = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idEstudiante);

            // INSERT, UPDATE, DELETE
            statement.executeUpdate();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public static void updateEstudiante(Estudiante estudiante) {
        Connection conexion = ConexionDB.getConnection();
        String sql = "UPDATE estudiante SET nombre = ? WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, estudiante.getNomEstudiante());
            statement.setInt(2, estudiante.getCodEstudiante());

            // INSERT, UPDATE, DELETE
            statement.executeUpdate();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

}
