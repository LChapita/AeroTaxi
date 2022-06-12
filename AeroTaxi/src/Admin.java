import java.util.ArrayList;
import java.util.List;

public class Admin extends Persona {

    public Admin(String nombre, String apellido, int dni, int edad) {
        super(nombre, apellido, dni, edad);
    }

    @Override
    public void mostrarUsuarios(List<User.User> usuarios) {
        if (usuarios != null) {
            for (User.User all : usuarios) {
                System.out.println(all.toString());
            }
        } else {
            System.out.println("No se encontraron usuarios");
        }

    }

    @Override
    public List<User.User> removerUsuario(List<User.User> usuarios, int eliminar) {
        User.User aux = new User.User();
        if (!usuarios.isEmpty()) {

            for (User.User aEliminar : usuarios) {
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


