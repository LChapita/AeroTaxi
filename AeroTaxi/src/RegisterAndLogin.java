


import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class RegisterAndLogin {
    /*public RegisterAndLogin() {
    }*/


    public void register(User.User user, List<User.User> userArrayList) {
        Scanner scanner = new Scanner(System.in);

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

            } catch (InputMismatchException e) {
                System.out.println("try it again");
                scanner.nextLine();
            } catch (InterruptedException e) {
                System.out.println("Time out, try again later");
                scanner.nextLine();
            }
        } while (user.getAge() == 0);

        passwordCreation(user);

        userArrayList.add(user); // agrego el usuario ya registrado a la lista

    }

    public void passwordCreation(User.User user) {
        Scanner scanner = new Scanner(System.in);
        //StringBuilder builder = new StringBuilder();

        do {
            try {

                // Ver alguna implementación en Java para censurar la contraseña mientras se escribe
                System.out.println("Password: ");
                user.setPassword(scanner.nextLine());


                TimeUnit.MILLISECONDS.sleep(10);

                System.out.println("Confirm password: ");
                user.setPasswordValidation(scanner.nextLine());

            } catch (InputMismatchException e) {
                System.out.println("you must be enter with a corresponding value");
                scanner.nextLine();
            } catch (InterruptedException e) {
                System.out.println("Time out, try again later");
                scanner.nextLine();
            }
        } while (user.getPassword().compareTo(user.getPasswordValidation()) != 0);
    }

    public boolean Login(User.User user, List<User.User> recuperarUsuarios) {
        boolean confirmacion=false;
        Scanner scanner = new Scanner(System.in);
        /*
        if (user.getDni() == 0 || user.getPassword() == null) { // en caso de que el usuario entre directamente
            System.out.println("You must be register for login");
            return;
        }*/

        do {
            try {
                System.out.println("User login: \n");

                System.out.println("Dni: ");
                user.setDniValidation(scanner.nextInt());

                scanner.nextLine(); // limpio el buffer

                System.out.println("Password: ");
                user.setPasswordValidation(scanner.nextLine());


            } catch (InputMismatchException e) {
                System.out.println("You must be enter with a corresponding value");
                scanner.nextLine();
            }


            //} while(userArrayList.get(i).getDni() != user.getDniValidation() && userArrayList.get(i++).getPassword().compareTo(user.getPasswordValidation()) != 0);
            //} while(user.getDni() != user.getDniValidation() && user.getPassword().compareTo(user.getPasswordValidation()) != 0);
        } while (user.getPasswordValidation().charAt(0) == 0);

        for (User.User userSearched : recuperarUsuarios) {
            if ((userSearched.getDni() == user.getDniValidation()) && (userSearched.getPassword().compareTo(user.getPasswordValidation()) == 0)) {
                System.out.println("Welcome back: " + userSearched.getName() + " " + userSearched.getSurname());
                confirmacion=true;
            }
        }
        return confirmacion;
    }


    public void censoredPassword(User.User user) {
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
