

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserMenu {
    public UserMenu() {
    }


    public void Options() {

        Archivo<User> archivoUsuarios = new Archivo<>("baseUsuarios.json");
        Archivo<Avion> archivoAviones = new Archivo<>("baseAviones.json");
        Archivo<Vuelo> archivoVuelos = new Archivo<>("baseVuelos.json");

        List<User> recuperarUsuarios = archivoUsuarios.rescatar(User.class);
        List<Avion> recuperarAvion = archivoAviones.rescatar(Avion.class);

        List<Vuelo> recuperarVuelos = archivoVuelos.rescatar(Vuelo.class);

        boolean datos=archivoAviones.existenDatos(recuperarAvion);


        if(datos==true){
            Avion avionGold=new Gold(15000,5,Propulsion.REACCION,true,true);
            Avion avionSilver=new Silver(5000,15,Propulsion.PISTONES,true);
            Avion avionBonze=new Bronze(11000,40,Propulsion.PISTONES);
            recuperarAvion.add(avionGold);
            recuperarAvion.add(avionSilver);
            recuperarAvion.add(avionBonze);

            archivoAviones.guardar(recuperarAvion,Avion.class);
        }


        RegisterAndLogin userCreation = new RegisterAndLogin();
        User user = new User();
        Scanner scanner = new Scanner(System.in);


        int option = 0;
        while (option != 3) {

            System.out.println("\n1 - Register: \n");
            System.out.println("2 - Login: \n");
            System.out.println("3 - Exit: \n");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Only integer value");
            }


            switch (option) {
                case 1:
                    user= userCreation.register(user, recuperarUsuarios);
                    recuperarUsuarios.add(user);
                    //guardar el usuario
                    archivoUsuarios.guardar(recuperarUsuarios,User.class);
                    ///guarda cuando finaliza el programa
                    break;

                case 2:///otra funcion de menu donde le de opciones de que quiere hacer
                    boolean confirmarLogin=userCreation.Login(user, recuperarUsuarios,recuperarAvion,recuperarVuelos);
                    if (confirmarLogin){
                        //sacarvuelo
                        //System.out.println("macaco");
                        System.out.println("Ingrese su dni para realizar un pedido: ");
                        int dni=new Scanner(System.in).nextInt();
                        boolean correcto= RequestFlyMenu.pruebaMetodos(recuperarUsuarios,recuperarAvion,recuperarVuelos,dni);
                        if(correcto){
                            archivoVuelos.guardar(recuperarVuelos,Vuelo.class);
                        }
                    }else{
                        System.out.println("You must be register for login");
                    }
                    break;

                case 3:
                    exitOption();
                    break;
            }
        }

    }


    public void exitOption() {
        System.out.println("Finish process");

    }


}
