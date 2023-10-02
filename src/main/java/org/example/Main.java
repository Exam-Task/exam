package org.example;


import org.example.ui.BaseUI;

import java.util.Scanner;

public class Main {

    public static final Scanner scannerInt = new Scanner(System.in);
    public static final Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {
        BaseUI baseUI = new BaseUI();
        baseUI.start();
    }
}