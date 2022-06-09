import java.util.ArrayList;
import java.util.List;

public class Admin extends Persona {

    public Admin(String nombre, String apellido, int dni, int edad) {
        super(nombre, apellido, dni, edad);
    }

    @Override
    public void mostrarUsuarios(List<Usuario> usuarios) {
        if (usuarios != null) {
            for (Usuario all : usuarios) {
                System.out.println(all.toString());
            }
        } else {
            System.out.println("No se encontraron usuarios");
        }

    }

    @Override
    public List<Usuario> removerUsuario(List<Usuario> usuarios, int eliminar) {
        Usuario aux = new Usuario();
        if (!usuarios.isEmpty()) {

            for (Usuario aEliminar : usuarios) {
                if(aEliminar.getDni() == eliminar){
                    aux = aEliminar;
                }
            }
                usuarios.remove(aux);

        }else{
            System.out.println("No se encontro el usuario");
        }
        return usuarios;
    }
}


