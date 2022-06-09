import java.util.List;

public abstract class Persona implements AccionesDePersona{
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
    public void mostrarUsuarios(List<Usuario> usuarios) {
    }

    @Override
    public List<Usuario> removerUsuario(List<Usuario> usuarios,int eliminar) {
        return null;
    }

    @Override
    public Usuario modificarUsuario(List<Usuario> usuarios,int dni) {
        return null;
    }
}