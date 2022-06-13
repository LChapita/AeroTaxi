import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.*;

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

    @Override
    public List<Usuario> modificarUsuario(List<Usuario> usuarios, int dni) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        for (Usuario usuario : usuarios) {
            if(usuario.getDni()==dni){

                System.out.println("Nombre: ");
                usuario.setNombre(scanner.nextLine());


                TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Apellido: ");
                usuario.setApellido(scanner.nextLine());

                TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Edad: ");
                usuario.setEdad(scanner.nextInt());
            }
        }
        return usuarios;
    }
    @Override
    public int compareTo(Object o) {
        Usuario nuevo = (Usuario) o;
        return super.getNombre().compareTo(nuevo.getNombre());
    }

    @Override
    public void ordenarUsuario_Por_Nombre(List<Usuario>usuarios) {
        Collections.sort(usuarios);
    }

    public void ordenarUsuario_Por_Dni(List<Usuario>usuarios){
        Collections.sort(usuarios);
    }
}


