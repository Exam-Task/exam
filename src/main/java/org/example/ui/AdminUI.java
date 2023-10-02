package org.example.ui;

import org.example.user.entity.User;
import org.example.user.sevice.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.*;

public class AdminUI {
    private UserService service = UserService.getUserService();

    public void mainMenu(User user) {
        boolean isExited = false;
        while (!isExited) {
            System.out.println("""
                    1. Create Exam
                    2. Delete Exam
                    3. Show Results
                    0. Exit
                    >>>\s""");
            int index = scannerInt.nextInt();
            switch (index) {
                case 1 -> createExam(user);
                case 2 -> deleteExam(user);
                case 3 -> showExam(user);
                default -> System.out.println("You wrote wrong command!");
            }
        }
    }

    private void showExam(User user) {

    }

    private void deleteExam(User user) {

    }

    private void createExam(User user) {
        boolean isExited = false;
        boolean isDone = false;
        int count = 0;
        List<List<String>> options = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        List<String> questions = new ArrayList<>();
        System.out.println("Write exam name: ");
        String examName = scannerStr.nextLine();
        while (!isExited) {
            System.out.println("Write question or write 0 for finish: ");
            String question = scannerStr.nextLine();
            if (!question.equals("0")) {
                questions.add(question);
                List<String> listOption = new ArrayList<>();
                while (!isDone) {
                    System.out.println("Write option or write 0 for finish: ");
                    String option = scannerStr.nextLine();
                    if (!option.equals("0")) {
                        listOption.add(option);
                    } else {
                        isDone = true;
                    }
                }
                System.out.println("Question: "+question);
                System.out.print("Choose answer index: ");
                for (String option : listOption){
                    System.out.println(count+". "+option);
                }
                int index = scannerInt.nextInt();
                if (listOption.size()>=0 && listOption.size()<index){
                    answers.add(index);
                    System.out.println("Successfully answer added!");
                }
            } else {
                isExited = true;
                System.out.println("Exam successfully created!");
            }
        }
    }
}
