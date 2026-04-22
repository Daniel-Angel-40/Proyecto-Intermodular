import java.sql.*;

// Creo esta clase para dividir la clase desarrollador a la gestion de la base de datos

public class DesarrolladorDAO {

    public static void insertarDesarrollador(Desarrollador dev) {

        // Creacion de la sentencia SQL
        String sentencia = "{CALL sp_insertar_desarrollador(?, ?, ?, ?, ?, ?)}";

        // Pongo aqui la conexion para que se desconecte automaticamente cuando acabe el try
        // Conexion a la base de datos
        try(Connection con = ConexionBD.getConnection()) {

            // Preparacion de la sentencia
            PreparedStatement ps = con.prepareStatement(sentencia);

            // Se añaden los valores menos el ID ya que es autoincremental
            ps.setString(1, dev.getDNI());
            ps.setString(2, dev.getNombre());
            ps.setString(3, dev.getApellido1());
            ps.setString(4, dev.getApellido2());
            ps.setString(5, dev.getEmail());
            ps.setString(6, dev.getFecha_alta());

            // Introduzco la variable para comprobar que ha salido bien la sentencia
            int resultado = ps.executeUpdate();

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

        // Pongo aqui la conexion para que se desconecte automaticamente cuando acabe el try
        // Conexion a la base de datos
        try(Connection con = ConexionBD.getConnection()) {

            // Preparacion de la sentencia
            PreparedStatement ps = con.prepareStatement(sentencia);

            // Se añade el id proporcionado a la sentencia
            ps.setInt(1, id);
            // Se ejecuta la sentencia
            ResultSet rs = ps.executeQuery();

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

        // Pongo aqui la conexion para que se desconecte automaticamente cuando acabe el try
        // Conexion a la base de datos
        try(Connection con = ConexionBD.getConnection()) {

            // Preparacion de la sentencia
            PreparedStatement ps = con.prepareStatement(sentencia);

            // Se introducen todos los datos del usuario
            ps.setInt(1, dev.getId());
            ps.setString(2, dev.getDNI());
            ps.setString(3, dev.getNombre());
            ps.setString(4, dev.getApellido1());
            ps.setString(5, dev.getApellido2());
            ps.setString(6, dev.getEmail());
            ps.setString(7, dev.getFecha_alta());

            // Ejecuto la sentencia
            ps.executeUpdate();

            System.out.println("Modificacion completada correctamente");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarDesarrollador(int id){

        // Creacion de la sentencia SQL
        String sentencia = "{CALL sp_delete_desarrollador(?)}";

        // Pongo aqui la conexion para que se desconecte automaticamente cuando acabe el try
        // Conexion a la base de datos
        try(Connection con = ConexionBD.getConnection()) {

            // Preparacion de la sentencia
            PreparedStatement ps = con.prepareStatement(sentencia);

            // Se añade el id proporcionado a la sentencia
            ps.setInt(1, id);

            // Ejecuto la sentencia
            ps.executeUpdate();

            System.out.println("Desarrollador eliminado correctamente");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
