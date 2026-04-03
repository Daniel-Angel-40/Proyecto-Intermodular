import java.sql.*;

// Creo esta clase para dividir la clase desarrollador a la gestion de la base de datos

public class DesarrolladorDAO {

    public static void insertarDesarrollador(Desarrollador dev) {

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

    public static void consultarDesarrollador(int id) {

        // Creacion de la sentecia SQL
        String sentencia = "{CALL sp_get_desarrollador(?)}";

        try {
            // Conexion con la base de datos
            Connection con = ConexionBD.getConnection();
            // Preparacion de la sentencia
            CallableStatement cs = con.prepareCall(sentencia);

            // Se añade el id proporcionado a la sentencia
            cs.setInt(1, id);
            // Se ejecuta la sentencia
            ResultSet rs = cs.executeQuery();

            // Asigno los atributos al objeto desarrollador
            if (rs.next()) {
                Desarrollador dev = new Desarrollador(rs.getString("DNI"), rs.getString("nombre"),
                        rs.getString("apellido1"), rs.getString("apellido2"),
                        rs.getString("email"), rs.getString("fecha_alta"));
                dev.setId(id);

                // Muestro el objeto con los atributos
                System.out.println(dev);
            } else {
                System.out.println("No existe un desarrollador con ese id asignado");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarDesarrollador(Desarrollador dev){

        // Creacion de la sentencia SQL
        String sentencia = "{CALL sp_update_desarrollador(?, ?, ?, ?, ?, ?, ?)}";

        try {
            // Conexion a la base de datos
            Connection con = ConexionBD.getConnection();

            // Preparacion de la sentencia
            CallableStatement cs = con.prepareCall(sentencia);

            // Se introducen todos los datos del usuario
            cs.setInt(1, dev.getId());
            cs.setString(2, dev.getDNI());
            cs.setString(3, dev.getNombre());
            cs.setString(4, dev.getApellido1());
            cs.setString(5, dev.getApellido2());
            cs.setString(6, dev.getEmail());
            cs.setString(7, dev.getFecha_alta());

            // Ejecuto la sentencia
            cs.executeUpdate();

            System.out.println("Modificacion completada correctamente");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarDesarrollador(int id){

        // Creacion de la sentencia SQL
        String sentencia = "{CALL sp_delete_desarrollador(?)}";

        try {
            // Conexion a la base de datos
            Connection con = ConexionBD.getConnection();
            // Preparacion de la sentencia
            CallableStatement cs = con.prepareCall(sentencia);

            // Se añade el id proporcionado a la sentencia
            cs.setInt(1, id);

            // Ejecuto la sentencia
            cs.executeUpdate();

            System.out.println("Desarrollador eliminado correctamente");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
