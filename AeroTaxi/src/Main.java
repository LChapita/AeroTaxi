/*
        TP - AeroTaxi
        Integrantes: Lucas Chapa, Alex Villca, Leonardo Suarez
*/



import User.RegisterAndLogin;
import User.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("AeroTaxi\n\n");


        RegisterAndLogin user1 = new RegisterAndLogin();
        user1.Register();
        System.out.println();

        ArrayList<RegisterAndLogin> ArrayListUser = new ArrayList<>();
        ArrayListUser.add(user1);









    }

}
