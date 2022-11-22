package org.example.sc;

import java.util.Scanner;

public class Scan {
    private static final String EXIT = "exit";
    private static String returnAnswerString;
    private static Integer returnAnswerInt;

    public static String getSomeString(){
        returnAnswerString = newScanner().nextLine();
            return returnAnswerString;
    }
    public static Integer getSomeInt(){
        returnAnswerInt = newScanner().nextInt();
        return returnAnswerInt;
    }

    public static boolean isStop(){
        if(!EXIT.equalsIgnoreCase(returnAnswerString)) {
            return false;
        }
        else
        return true;
    }



   private static Scanner newScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
