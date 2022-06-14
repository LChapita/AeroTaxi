import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Admin extends Persona{

    public Admin(String nombre, String apellido, int dni, int edad) {
        super(nombre, apellido, dni, edad);
    }

    @Override
    public void mostrarUsuarios(List<User> usuarios) {
        if (usuarios != null) {
            for (User all : usuarios) {
                System.out.println(all.toString());
            }
        } else {
            System.out.println("No se encontraron usuarios");
        }

    }

    @Override
    public List<User> removerUsuario(List<User> usuarios, int eliminar){
        User aux = new User();
        if (!usuarios.isEmpty()) {

            for (User aEliminar : usuarios) {
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
    public List<User> modificarUsuario(List<User> usuarios, int dni){
        Scanner scanner = new Scanner(System.in);
        for (User user : usuarios) {
            if(user.getDni()==dni){

                System.out.println("Nombre: ");
                user.setName(scanner.nextLine());

                //TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Apellido: ");
                user.setSurname(scanner.nextLine());

                //TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Edad: ");
                user.setAge(scanner.nextInt());
            }
        }
        return usuarios;
    }
    @Override
    public int compareTo(Object o) {
        User nuevo = (User) o;
        return super.getNombre().compareTo(nuevo.getName());
    }

    @Override
    public void ordenarUsuario_Por_Nombre(List<User>usuarios) {
        Collections.sort(usuarios);
    }


    public void ordenarUsuario_Por_Dni(List<User>usuarios){
        Collections.sort(usuarios);
    }


}
