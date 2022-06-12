import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;

    private int contraseña;

    public Usuario(){}

    public Usuario(String nombre, String apellido, int dni, int edad,int contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.contraseña=contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public int getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                ", contraseña=" + contraseña +
                '}';
    }
}
