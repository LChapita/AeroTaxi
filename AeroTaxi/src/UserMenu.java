

import java.time.LocalDateTime;
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
        User userRegister=new User();

        if(datos){
            Avion avionGold=new Gold(15000,5,Propulsion.REACCION,true,true);
            Avion avionSilver=new Silver(5000,15,Propulsion.PISTONES,true);
            Avion avionBonze=new Bronze(11000,40,Propulsion.PISTONES);
            recuperarAvion.add(avionGold);
            recuperarAvion.add(avionSilver);
            recuperarAvion.add(avionBonze);

            archivoAviones.guardar(recuperarAvion,Avion.class);
        }


        RegisterAndLogin userCreation = new RegisterAndLogin();

        Scanner scanner = new Scanner(System.in);


        int option = 0;
        while (option != 3) {

            if(userRegister.getDni()!=0){
                break;
            }
            System.out.println("\n----------------------------------------------------------------------------------------\n");
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
                    userRegister= userCreation.register(recuperarUsuarios);
                    recuperarUsuarios.add(userRegister);
                    //guardar el usuario
                    archivoUsuarios.guardar(recuperarUsuarios,User.class);
                    ///guarda cuando finaliza el programa
                    break;

                case 2:///otra funcion de menu donde le de opciones de que quiere hacer
                    ///menu de usuario
                    User mantener=new User();
                    boolean confirmarLogin=userCreation.Login(userRegister, recuperarUsuarios,recuperarAvion,recuperarVuelos,archivoUsuarios,archivoAviones,archivoVuelos,mantener);

                    if (confirmarLogin) {
                        LoginOption(recuperarUsuarios, recuperarAvion, recuperarVuelos, archivoUsuarios, archivoAviones, archivoVuelos,mantener);
                    }else {
                        System.out.println("El usuario no se pudo encontrar\n");
                    }
                    /*
                    if (confirmarLogin){
                        //sacarvuelo
                        //System.out.println("macaco");
                        System.out.println("Ingrese su dni para realizar un pedido: ");
                        int dni=new Scanner(System.in).nextInt();
                        boolean correcto= RequestFlyMenu.SolicitarVuelo(recuperarUsuarios,recuperarAvion,recuperarVuelos,dni);
                        if(correcto){
                            archivoVuelos.guardar(recuperarVuelos,Vuelo.class);
                        }
                    }else{
                        System.out.println("You must be register for login");
                    }*/
                    break;

                case 3:
                    exitOption();
                    break;
            }
        }

    }


    private void LoginOption(List<User> recuperarUsuarios, List<Avion> recuperarAvion, List<Vuelo> recuperarVuelos,Archivo archivoUsuarios, Archivo archivoAviones, Archivo archivoVuelos, User mantener){
        Scanner scanner = new Scanner(System.in);
        int option = 0;


        do{
            System.out.println("---------------------------------\n");
            System.out.println("1 - realizar un pedido de vuelo:\n");
            System.out.println("2 - modificar informaci??n:\n");
            System.out.println("3 - ver informaci??n\n");
            System.out.println("4 - cancelar vuelo\n");
            System.out.println("0 - salir:\n");
            System.out.println("---------------------------------\n");


            try{
                option = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Solo valores num??ricos\n");
            }

            if(option != 5) // para verificar que si el usuario quiere salir, no haga el switch con las otras opciones
                switch (option){
                    case(1):{
                        RequestFly(recuperarUsuarios, recuperarAvion, recuperarVuelos, archivoVuelos);

                        break;
                    }

                    case(2):{
                        // modificar informaci??n
                        System.out.println("Ingrese su DNI para realizar la modificacion: ");

                        int dniMod = new Scanner(System.in).nextInt();

                        List<User> usuarioMod = modificarUsuarioDeLogin(recuperarUsuarios,dniMod);

                        recuperarUsuarios=usuarioMod;
                        archivoUsuarios.guardar(recuperarUsuarios,User.class);
                        break;

                    }

                    case(3):{
                        // ver informaci??n
                        System.out.println("-----------------\n");
                        User user= RequestFlyMenu.retornarUnUsuario(recuperarUsuarios,mantener.getDni());
                        System.out.println(user.toString());
                        System.out.println("-----------------\n");
                        break;
                    }
                    case(4):{
                        System.out.println("Cancelar Vuelo");
                        User user= RequestFlyMenu.retornarUnUsuario(recuperarUsuarios,mantener.getDni());
                        System.out.println("Ingrese fecha de vuelo: \n");
                        LocalDateTime fechaCancela= RequestFlyMenu.solicitarFecha();
                        Vuelo cancelar= RequestFlyMenu.cancelarUnVuelo(user,String.valueOf(fechaCancela),recuperarVuelos);
                        List<Vuelo> vueloCancelado=recuperarVuelos;

                        vueloCancelado.remove(cancelar);
                        archivoVuelos.guardar(vueloCancelado,Vuelo.class);
                        break;
                    }
                    case(0): {

                        break;
                    }
                }
        } while(option != 0);
    }

    private void RequestFly(List<User> recuperarUsuarios, List<Avion> recuperarAvion, List<Vuelo> recuperarVuelos, Archivo archivoVuelo){ // pedido de vuelo, m??s no de men??
        System.out.println("Ingrese su dni para realizar un pedido: ");
        int dni=new Scanner(System.in).nextInt();

        boolean correcto = RequestFlyMenu.SolicitarVuelo(recuperarUsuarios, recuperarAvion, recuperarVuelos, dni,archivoVuelo);
        if(correcto)
            System.out.println(correcto);
            //archivoVuelo.guardar(recuperarVuelos, Vuelo.class);16-16-06-2022
    }

    public void exitOption() {
        System.out.println("Finish process");

    }

    public List<User> modificarUsuarioDeLogin(List<User> usuarios, int dni) {
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

}
