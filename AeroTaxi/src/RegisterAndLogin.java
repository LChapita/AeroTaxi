







import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.List;

public final class RegisterAndLogin{
    public RegisterAndLogin(){}


    public void Register(User user, List<User> userList){
        Scanner scanner = new Scanner(System.in);

        boolean verificar = false;

        do {
            try {
                System.out.println("Register: \n");


                System.out.println("Name: ");
                user.setName(scanner.nextLine());

                TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Surname: ");
                user.setSurname(scanner.nextLine());

                TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Dni: ");
                user.setDni(scanner.nextInt());

                TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Age: ");
                user.setAge(scanner.nextInt()); // si llegó a agregar la edad, se terminó de crear el usuario con sus datos administrativos

                TimeUnit.MILLISECONDS.sleep(10);

                // verifico que el usuario no se encuentre ya cargado en el archivo
                verificar = RequestFlyMenu.verificarUsuario(userList, user.getDni());
                if(verificar){
                    System.out.println("El usuario ya se encuentra registrado\n");
                    scanner.nextLine();
                }

            } catch (InputMismatchException e){
                System.out.println("try it again");
                scanner.nextLine();
            } catch (InterruptedException e){
                System.out.println("Time out, try again later");
                scanner.nextLine();
            }
        //} while(user.getAge() == 0);
        } while(verificar);

        passwordCreation(user);

        //userArrayList.add(user); // agrego el usuario ya registrado a la lista
        userList.add(user); // agrego el usuario ya registrado a la lista
    }

    public void passwordCreation(User user){
        Scanner scanner = new Scanner(System.in);
        //StringBuilder builder = new StringBuilder();

        do{
            try{

                // Ver alguna implementación en Java para censurar la contraseña mientras se escribe
                System.out.println("Password: ");
                user.setPassword(scanner.nextLine());


                TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Confirm password: ");
                user.setPasswordValidation(scanner.nextLine());

            } catch(InputMismatchException e){
                System.out.println("you must be enter with a corresponding value");
                scanner.nextLine();
            } catch (InterruptedException e){
                System.out.println("Time out, try again later");
                scanner.nextLine();
            }
        } while(user.getPassword().compareTo(user.getPasswordValidation()) != 0);
    }

    public boolean Login(User user, List<User> recuperarUsuarios){
        boolean confirmacion = false;
        Scanner scanner = new Scanner(System.in);

        /*if(user.getDni() == 0 || user.getPassword() == null){ // en caso de que el usuario entre directamente
            System.out.println("You must be register for login");
            return;
        }*/



        do{
            try{
                System.out.println("User login: \n");

                System.out.println("Dni: ");
                user.setDniValidation(scanner.nextInt());

                scanner.nextLine(); // limpio el buffer

                System.out.println("Password: ");
                user.setPasswordValidation(scanner.nextLine());


            } catch(InputMismatchException e){
                System.out.println("You must be enter with a corresponding value");
                scanner.nextLine();
            }


        //} while(user.getPasswordValidation().charAt(0) == 0);
        } while(user.getPasswordValidation().charAt(0) == 0);

        for (User userSearched : recuperarUsuarios) {
            if(userSearched.getDni() == user.getDniValidation() && (userSearched.getPassword().compareTo(user.getPasswordValidation())) == 0){
                System.out.println("Welcome back: " + user.getName() + " " + user.getSurname());
                confirmacion = true;
            }
        }
        return confirmacion;
    }



    public void censoredPassword(User user){
        Scanner scanner = new Scanner(System.in);

        TextField password = new TextField();
        //JPasswordField
        password.setEchoChar('*');

        scanner.next().charAt(0);

        /*do{
            user.setPassword(scanner.nextLine());




        } while();*/


    }

}
