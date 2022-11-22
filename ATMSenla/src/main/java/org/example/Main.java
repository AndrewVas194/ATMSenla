package org.example;

import org.example.service.CardService;
import org.example.startWork.StartWork;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number card and pass:");
        CardService.authorization();
        StartWork.scanner();
    }
}
