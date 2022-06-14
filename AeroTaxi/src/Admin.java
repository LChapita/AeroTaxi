import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Persona {

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
    public List<User> removerUsuario(List<User> usuarios, int eliminar) {
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
    public static boolean verificarAdministrador(int admiDni,String admiPassword){
        boolean esAdmin=false;
        String password="admi";
        int user=0000;
        if ((admiPassword.compareTo(password)==0)&&(admiDni==user)){
            esAdmin=true;
        }
        return esAdmin;
    }
    public static void menuAdmi(List<User> recuperarUsuarios,List<Avion> recuperarAviones,List<Vuelo> recuperarVuelos){
        int opcion;
        do {
            opcion=new Scanner(System.in).nextInt();
            switch (opcion){
                case (1):

                    break;
                case (2):
                    //elimi
                    break;
                case (3):
                    //Modificar Usuario
                    break;
                case(0):
                    break;

            }
        }while (opcion > 0);

    }
}


