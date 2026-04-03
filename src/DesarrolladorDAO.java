import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Creo esta clase para dividir la clase desarrollador a la gestion de la base de datos

public class DesarrolladorDAO {

    public static void insertarDesarrollador(Desarrollador dev){

        // Creacion de la sentencia SQL
        String sentencia = "{CALL sp_insertar_desarrollador(?, ?, ?, ?, ?, ?)}";

        try {
            // Conexion a la base de datos
            Connection con = ConexionBD.getConnection();
            // Preparacion de la sentencia
            CallableStatement cs = con.prepareCall(sentencia);

            // Se añaden los valores menos el ID ya que es autoincremental
            cs.setString(1, dev.getDNI());
            cs.setString(2, dev.getNombre());
            cs.setString(3, dev.getApellido1());
            cs.setString(4, dev.getApellido2());
            cs.setString(5, dev.getEmail());
            cs.setString(6, dev.getFecha_alta());

            // Introduzco la variable para comprobar que ha salido bien la sentencia
            int resultado = cs.executeUpdate();

            // Compruebo el resultado
            if (resultado > 0) {
                System.out.println("Desarrollador insertado correctamente");
            } else {
                System.out.println("Error");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
