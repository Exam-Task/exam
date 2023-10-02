package org.example;


import org.example.exam.repository.ExamRepository;
import org.example.user.entity.User;
import org.example.user.entity.UserType;
import org.example.user.repository.UserRepository;

import java.util.Scanner;


public class Main {

    public static final Scanner scannerInt = new Scanner(System.in);
    public static final Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {
        ExamRepository examRepository = ExamRepository.getInstance();
        System.out.println(examRepository.getAll());

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.updateUserById(UUID.fromString("30383ed4-7121-4da1-a224-2b2019813a8a"), ADMIN, "Suroj","dfsd", "sdd","sdsdf");
    }
}