package org.example.ui;

import org.example.user.entity.User;
import org.example.user.sevice.UserService;

import java.util.UUID;

import static org.example.Main.*;

public class BaseUI {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    private static UserService service = UserService.getUserService();
    private UserUI userUI = new UserUI();
    private AdminUI adminUI = new AdminUI();


    public void start() {
        boolean isExited = false;
        while (isExited) {
            System.out.println("""
                    1. Sign in
                    2. Sign up
                    0. Exit
                    >>>\s""");
            int index = scannerInt.nextInt();
            switch (index) {
                case 1 -> signUp();
                case 2 -> signIn();
                case 0 -> isExited = true;
                default -> System.out.println("Incorrect command, please try again!");
            }
        }
    }

    private void signIn() {
        System.out.print("Please enter your username: ");
        String username = scannerStr.nextLine();
        System.out.print("Please enter your password: ");
        String password = scannerStr.nextLine();
        if ((!username.isBlank()) && (!password.isBlank())) {
            User byUsername = service.getByUsername(username, password);
            switch (byUsername.getUserType()) {
                case ADMIN -> adminUI.mainMenu(byUsername);
                case USER -> userUI.mainMenu(byUsername);
            }
        } else {
            System.out.println("Wrong password or username! Please try again!");
        }
    }

    private void signUp() {
        System.out.print("Please write your name: ");
        String name = scannerStr.nextLine();
        System.out.print("Please write your surname: ");
        String surname = scannerStr.nextLine();
        System.out.print("Please write your username: ");
        String username = scannerStr.nextLine();
        System.out.print("Please set up password: ");
        String password = scannerStr.nextLine();
        User user = User.builder()
                .userId(UUID.randomUUID())
                .name(name)
                .surname(surname)
                .username(username)
                .password(password)
                .build();
        service.add(user);
        System.out.println("You have been successfully registered!");
    }
}