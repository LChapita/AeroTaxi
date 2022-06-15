import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.List;

public class UserMenu{
    public UserMenu(){}


    public void Options(){
        Archivo<User> archivoUsuarios = new Archivo<>("baseUsuarios.json");
        Archivo<Avion> archivoAviones = new Archivo<>("baseAviones.json");
        Archivo<Vuelo> archivoVuelos = new Archivo<>("baseVuelos.json");

        List<User> recuperarUsuarios = archivoUsuarios.rescatar(User.class);
        List<Avion> recuperarAvion = archivoAviones.rescatar(Avion.class);
        List<Vuelo> recuperarVuelos = archivoVuelos.rescatar(Vuelo.class);


        RegisterAndLogin userCreation = new RegisterAndLogin();
        User userControler = new User();
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while(option != 3) {

            System.out.println("---------------------------------\n");
            System.out.println("\n1 - Register: \n");
            System.out.println("2 - Login: \n");
            System.out.println("3 - Exit: \n");
            System.out.println("---------------------------------\n");


            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Only integer value");
                scanner.nextLine();
            }



            switch (option) {
                case 1:
                    userControler = userCreation.Register(userControler, recuperarUsuarios);
                    recuperarUsuarios.add(userControler);
                    archivoUsuarios.guardar(recuperarUsuarios, User.class);
                    break;

                case 2:
                    boolean confirmarLogin = userCreation.Login(userControler, recuperarUsuarios);
                    //userCreation.Login(user, recuperarUsuarios);

                    if(confirmarLogin)
                        LoginOption(recuperarUsuarios, recuperarAvion, recuperarVuelos, archivoVuelos, userControler);

                    else
                        System.out.println("El usuario no se pudo encontrar\n");
                    break;

                case 3:
                    exitOption();
                    break;
            }
        }
    }


    private void LoginOption(List<User> recuperarUsuarios, List<Avion> recuperarAvion, List<Vuelo> recuperarVuelos, Archivo<Vuelo> ArchivoVuelos, User user){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do{
            System.out.println("---------------------------------\n");
            System.out.println("1 - realizar un pedido de vuelo:\n");
            System.out.println("2 - modificar información:\n");
            System.out.println("3 - ver información\n");
            System.out.println("4 - salir:\n");
            System.out.println("---------------------------------\n");


            try{
            option = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Solo valores numéricos\n");
            }

            if(option != 4) // para verificar que si el usuario quiere salir, no haga el switch con las otras opciones
            switch (option){
                case(1):{
                    RequestFly(recuperarUsuarios, recuperarAvion, recuperarVuelos, ArchivoVuelos);
                    break;
                }

                case(2):{
                    // modificar información





                }

                case(3):{
                    // ver información
                    System.out.println("-----------------\n");
                    System.out.println(user.toString());
                    System.out.println("-----------------\n");
                }
            }
        } while(option != 4);
    }

    private void RequestFly(List<User> recuperarUsuarios, List<Avion> recuperarAvion, List<Vuelo> recuperarVuelos, Archivo<Vuelo> ArchivoVuelo){ // pedido de vuelo, más no de menú
        System.out.println("Ingrese su dni para realizar un pedido: ");
        int dni=new Scanner(System.in).nextInt();

        boolean correcto = RequestFlyMenu.SolicitarVuelo(recuperarUsuarios, recuperarAvion, recuperarVuelos, dni);
        if(correcto)
            ArchivoVuelo.guardar(recuperarVuelos, Vuelo.class);
    }




    private void exitOption(){
        System.out.println("Finish process");
    }


}
