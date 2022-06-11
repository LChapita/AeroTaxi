package Menu;

import User.RegisterAndLogin;
import User.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu{
    public UserMenu(){}


    public void Options(ArrayList<User> userArrayList){
        RegisterAndLogin userCreation = new RegisterAndLogin();
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while(option != 3) {

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
                    userCreation.Register(user, userArrayList);
                    break;

                case 2:
                    userCreation.Login(user, userArrayList);
                    break;

                case 3:
                    exitOption();
                    break;
            }
        }

    }




    public void exitOption(){
        System.out.println("Finish process");
    }


}
