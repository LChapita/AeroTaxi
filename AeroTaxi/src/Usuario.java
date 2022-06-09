import java.util.List;

public class Usuario extends Persona{

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, int dni, int edad)
    {
        super(nombre, apellido, dni, edad);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Usuario modificarUsuario(List<Usuario> usuarios,int dni) {
       return  null;

    }
}
