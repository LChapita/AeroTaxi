package User;

import User.Exceptions.AgeNotValidException;
import User.Exceptions.DniNotValidException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterAndLogin {
    public RegisterAndLogin(){}

    public void Register(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);


        while(user.getAge() == 0) {
            try {
                System.out.println("Register: \n");

                scanner.reset(); // ver por qué no funciona sí uno de los datos es ingresado de forma incorrecta

                System.out.println("Name: ");
                System.out.println("Surname: ");
                System.out.println("Dni: ");
                System.out.println("age: ");
                user.setName(scanner.nextLine()); // este se lo saltea si a la primera vez no se crea el usuario correctamente

                //System.out.println("Surname: ");
                user.setSurname(scanner.nextLine());

                //System.out.println("Dni: ");
                user.setDni(scanner.nextInt());

                //System.out.println("Age: ");
                user.setAge(scanner.nextInt()); // si llegó a agregar la edad, se terminó de crear el usuario con sus datos administrativos



            } catch (DniNotValidException e) {
                System.out.println("you must be enter with a corresponding value");
            } catch (AgeNotValidException e) {
                System.out.println("you must be enter with a natural number");
            }
        }

        String confirmPassword = new String("password");

        while(user.getPassword().compareTo(confirmPassword) < 0){
            try{
                System.out.println("\n Username: ");
                System.out.println("Password: ");
                System.out.println("Confirm password: ");

                scanner.reset();

                user.setUserName(scanner.nextLine()); // ver por qué me inicializa el nombre de usuario como null directamente
                user.setPassword(scanner.nextLine());
                confirmPassword = scanner.nextLine();

            } catch(InputMismatchException e){
                System.out.println("you must be enter with a corresponding value");
            }
        }

        //System.out.println(user);

    }




}
