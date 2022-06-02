package User;


import com.google.gson.Gson;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class RegisterAndLogin{
    public RegisterAndLogin(){}


    public void Register(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.println("Register: \n");


                System.out.println("Name: ");
                user.setName(scanner.nextLine());

                TimeUnit.MILLISECONDS.sleep(1);

                System.out.println("Surname: ");
                user.setSurname(scanner.nextLine());

                TimeUnit.MILLISECONDS.sleep(1);

                System.out.println("Dni: ");
                user.setDni(scanner.nextInt());

                TimeUnit.MILLISECONDS.sleep(1);

                System.out.println("Age: ");
                user.setAge(scanner.nextInt()); // si llegó a agregar la edad, se terminó de crear el usuario con sus datos administrativos

                TimeUnit.MILLISECONDS.sleep(1);

            } catch (InputMismatchException e){
                System.out.println("try it again");
                scanner.nextLine();
            } catch (InterruptedException e){
                System.out.println("Time out, try again later");
                scanner.nextLine();
            }
        } while(user.getAge() == 0);

        passwordCreation(user);
    }

    public void passwordCreation(User user){
        Scanner scanner = new Scanner(System.in);
        //StringBuilder builder = new StringBuilder();

        do{
            try{

                // Ver alguna implementación en Java para censurar la contraseña mientras se escribe
                System.out.println("Password: ");
                user.setPassword(scanner.nextLine());


                TimeUnit.MILLISECONDS.sleep(1);

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

    public void Login(User user){
        Scanner scanner = new Scanner(System.in);

        // próxima implementación: agregar el menú con las opciones de registro y logueo dentro de una nueva clase

        do{
            try{
                System.out.println("User login: ");

                System.out.println("Dni: ");
                 user.setDniValidation(scanner.nextInt());

                System.out.println("Password: ");
                user.setPasswordValidation(scanner.nextLine());


            } catch(InputMismatchException e){
                System.out.println("You must be enter with a corresponding value");
                scanner.nextLine();
            }
        } while(user.getDni() != user.getDniValidation() && user.getPassword().compareTo(user.getPasswordValidation()) != 0);
    }


}
