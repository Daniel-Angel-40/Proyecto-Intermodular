public class Desarrollador {

    // ATRIBUTOS

    private int id;
    private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String fecha_alta;

    // SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getEmail() {
        return email;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    // CONSTRUCTORES

    public Desarrollador() {
    }

    // METODOS

    @Override
    public String toString() {
        return "=== Desarrollador ===" +
                "\nID:       " + id +
                "\nDNI:      " + DNI +
                "\nNombre:   " + nombre + " " + apellido1 + " " + apellido2 +
                "\nEmail:    " + email +
                "\nAlta:     " + fecha_alta +
                "\n====================";
    }
}
