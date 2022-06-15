import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Admin extends Persona {

    public Admin() {
    }

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
                if (aEliminar.getDni() == eliminar) {
                    aux = aEliminar;
                }
            }
            usuarios.remove(aux);

        } else {
            System.out.println("No se encontro el usuario");
        }
        return usuarios;
    }

    @Override
    public List<User> modificarUsuario(List<User> usuarios, int dni) {
        Scanner scanner = new Scanner(System.in);
        for (User usuario : usuarios) {
            if(usuario.getDni()==dni){

                System.out.println("Nombre: ");
                usuario.setName(scanner.nextLine());




                System.out.println("Apellido: ");
                usuario.setSurname(scanner.nextLine());



                System.out.println("Edad: ");
                usuario.setAge(scanner.nextInt());
            }
        }
        return usuarios;
    }
    public static boolean verificarAdministrador(int admiDni, String admiPassword) {
        boolean esAdmin = false;
        String password = "admi";
        int user = 0000;
        if ((admiPassword.compareTo(password) == 0) && (admiDni == user)) {
            esAdmin = true;
        }
        return esAdmin;
    }

    public static void menuAdmi(List<User> recuperarUsuarios, List<Avion> recuperarAviones, List<Vuelo> recuperarVuelos, Archivo archivoUsuarios, Archivo archivoAviones, Archivo archivoVuelos) {

        Admin admin = new Admin();
        int opcion;
        do {
            System.out.println("\n----------------------------------------------------------------------------------------\n");
            System.out.println("Bienvenido al menu administrador.");
            System.out.println("Ingrese opcion: \n");

            System.out.println("1- Menu Listas: \n");
            System.out.println("2- Eliminar un Usuario : \n");
            System.out.println("3- Modificar un Usuario  : \n");
            System.out.println("0- Exit  : \n");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case (1):
                    //lista
                    menuListaAdmi(recuperarUsuarios, recuperarAviones, recuperarVuelos);
                    break;
                case (2):
                    System.out.println("Ingrese un DNI de un usuario que quiera eliminar");

                    int dniBorrar = new Scanner(System.in).nextInt();

                    List<User> usuarioBorrado= admin.removerUsuario(recuperarUsuarios, dniBorrar);

                    recuperarUsuarios=usuarioBorrado;
                    archivoUsuarios.guardar(recuperarUsuarios, User.class);

                    System.out.println("Se borro el usuario");

                    break;
                case (3):
                    System.out.println("Ingrese un DNI de un usuario que quiera Modificiar");

                    int dniMod = new Scanner(System.in).nextInt();

                    List<User> usuarioMod = admin.modificarUsuario(recuperarUsuarios,dniMod);

                    recuperarUsuarios=usuarioMod;
                    archivoUsuarios.guardar(recuperarUsuarios,User.class);
                    break;
                case (0):
                    break;

            }
        } while (opcion > 0);

    }

    public static void menuListaAdmi(List<User> recuperarUsuarios, List<Avion> recuperarAviones, List<Vuelo> recuperarVuelos) {
        Admin admin = new Admin();
        int opcion;
        do {
            System.out.println("\n----------------------------------------------------------------------------------------\n");
            System.out.println("Menu de Listas ");
            System.out.println("Ingrese opcion: \n");

            System.out.println("1- Lista Usuarios: \n");
            System.out.println("2- Lista Aviones : \n");
            System.out.println("3- Lista Vuelos  : \n");
            System.out.println("0- Exit  : \n");

            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case (1):
                    //Lista usuarios
                    admin.mostrarUsuarios(recuperarUsuarios);
                    break;
                case (2):
                    //Lista aviones
                    admin.mostrarAviones(recuperarAviones);
                    break;
                case (3):
                    //Lista vuelos o vueloPedidos
                    admin.mostrarVuelos(recuperarVuelos);
                    break;
                case (0):
                    break;
            }
        } while (opcion > 0);
    }

    public void mostrarAviones(List<Avion> aviones) {
        if (aviones != null) {
            for (Avion all : aviones) {

                System.out.println(all.toString());
            }
        } else {
            System.out.println("No se encontraron Aviones");
        }

    }

    public void mostrarVuelos(List<Vuelo> vuelos) {
        if (vuelos != null) {
            for (Vuelo all : vuelos) {
                System.out.println(all.toString());
            }
        } else {
            System.out.println("No se encontraron Vuelos");
        }

    }

}


