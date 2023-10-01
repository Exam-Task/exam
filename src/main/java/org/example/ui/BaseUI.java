package org.example.ui;

import static org.example.Main.*;

public class BaseUI {
    public void start(){
        boolean isExited = false;
        while (isExited){
            System.out.println("""
                1. Sign in
                2. Sign up
                0. Exit
                >>>\s""");
            int index = scannerInt.nextInt();

        }
    }
}
