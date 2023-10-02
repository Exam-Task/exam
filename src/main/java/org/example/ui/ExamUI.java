package org.example.ui;

import org.example.Main;

public class ExamUI {

    public void MainExamUI() {
        boolean isExisting = true;
        while (isExisting) {
            System.out.print("""
                    
                   /------------------/ 
                     1. Exams
                     2. Create exam
                     0. Exit
                   >>> 
                    """);

            String s = Main.scannerStr.nextLine();

            switch (s){
                case "1" -> {exams();}
                case "0" -> isExisting = false;
            }


        }
    }
    private void exams() {

    }
}
