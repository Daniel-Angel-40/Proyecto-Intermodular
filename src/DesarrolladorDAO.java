import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Creo esta clase para dividir la clase desarrollador a la gestion de la base de datos

public class DesarrolladorDAO {

    public static void insertarDesarrollador(Desarrollador dev){

        // Creacion de la sentencia SQL
        String sentencia = "INSERT INTO desarrollador (DNI, nombre, apellido1, apellido2, email, fecha_alta)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Conexion a la base de datos
            Connection con = ConexionBD.getConnection();
            // Preparacion de la sentencia
            PreparedStatement pst = con.prepareStatement(sentencia);

            // Se añaden los valores menos el ID ya que es autoincremental
            pst.setString(1, dev.getDNI());
            pst.setString(2, dev.getNombre());
            pst.setString(3, dev.getApellido1());
            pst.setString(4, dev.getApellido2());
            pst.setString(5, dev.getEmail());
            pst.setString(6, dev.getFecha_alta());

            // Introduzco la variable para comprobar que ha salido bien la sentencia
            int resultado = pst.executeUpdate();

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
