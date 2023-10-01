package org.example.ui;

import org.example.user.sevice.UserService;

import static org.example.Main.*;

public class BaseUI {
    private static UserService service = UserService.getUserService();
    public void start(){
        boolean isExited = false;
        while (isExited){
            System.out.println("""
                1. Sign in
                2. Sign up
                0. Exit
                >>>\s""");
            int index = scannerInt.nextInt();
            switch (index){
                case 1 -> signIn();
                case 2 -> logIn();
                case 0 -> isExited = true;
                default -> System.out.println("Incorrect command, please try again!");
            }
        }
    }

    private void logIn() {
        System.out.print("Please enter your username: ");

        System.out.print("Please enter your password: ");

    }

    private void signIn() {
        
    }
}
