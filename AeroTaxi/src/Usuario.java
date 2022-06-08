import java.util.List;

public class Usuario extends Persona{

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, int dni, int edad)
    {
        super(nombre, apellido, dni, edad);
    }



    @Override
    public void mostrarUsuarios(List<Usuario> usuarios) {
        if(usuarios != null){
            for (Usuario usuario: usuarios) {

            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
