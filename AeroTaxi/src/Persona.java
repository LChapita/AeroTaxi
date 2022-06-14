import java.util.List;
import java.util.Objects;

public abstract class Persona implements AccionesDePersona, Comparable{
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;

    public Persona(String nombre, String apellido, int dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    protected Persona() {
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

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                '}';
    }

    @Override
    public void mostrarUsuarios(List<User> usuarios) {
    }

    @Override
    public List<User> removerUsuario(List<User> usuarios,int eliminar) {
        return null;
    }

    @Override
    public List<User> modificarUsuario(List<User> usuarios, int dni) {
        return null;
    }

    @Override
    public void ordenarUsuario_Por_Dni(List<User> usuarios) {
    }

    @Override
    public void ordenarUsuario_Por_Nombre(List<User> usuarios) {
    }

    @Override
    public int compareTo(Object o) {
        // que le diga a la pc, que tiene que comparar del objeto?
        // como lo ordena? segun que?
        User nuevo = (User) o;
        return nombre.compareTo(nuevo.getName());
    }


}




