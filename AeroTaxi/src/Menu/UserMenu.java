package Menu;



import User.RegisterAndLogin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu{
    public UserMenu(){}


    public void Options(){
        RegisterAndLogin userMenu = new RegisterAndLogin();

        System.out.println("\n1 - Register: \n");
        System.out.println("2 - Login: \n");
        System.out.println("3 - Exit: \n");

        Scanner scanner = new Scanner(System.in);

        int option = 0;
        try {
            option = scanner.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Only integer value");
        }


        switch(option){
            case 1:
                userMenu.Register();
                break;

            case 2:
                //userMenu.Login();
                break;




        }







    }






}
