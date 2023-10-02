package org.example.ui;

import org.example.Main;
import org.example.exam.entity.Exam;
import org.example.exam.service.ExamService;

import java.util.List;

public class ExamUI {



    public final ExamService examService = ExamService.getInstance();


    public void MainExamUI() {
        boolean isExisting = true;
        while (isExisting) {
            System.out.print("""
                    
                   /------------------/
                     1. Exams
                     0. Exit
                   >>> \s
                    """);

            String s = Main.scannerStr.nextLine();

            switch (s){
                case "1" -> exams();
                case "0" -> isExisting = false;
            }
        }
    }



    private void exams() {
        boolean isExit = true;
        List<Exam> all = examService.getAll();
        int count = 3;
        while (isExit){
            for (int i = 0;i < all.size()/count;i++){
                System.out.printf("""
                        %d %s""",i,all.get(i).getName());
            }
        }
    }
}
