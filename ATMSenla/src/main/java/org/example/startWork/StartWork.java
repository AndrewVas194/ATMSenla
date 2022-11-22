package org.example.startWork;

import org.example.menu.MyMenuSc;
import org.example.sc.Scan;
import org.example.service.CardService;
import org.example.service.UserService;

public class StartWork {
    static String in;
    static String num;
    static short pin;

    public static void scanner(){
        do
        {
            MyMenuSc.outMenu();
            in = Scan.getSomeString();
            switch (in)
            {
                case "1":
                    CardService.getUserCardInfo();
                    break;
                case "2":
                    UserService.decreaseCardBalanceFromCash();
                    System.out.println(CardService.cardUser.getBalance());
                    break;
                case "3":
                    UserService.addCardBalanceFromCash();
                    System.out.println(CardService.cardUser.getBalance());
                    break;
                default:
                    System.out.println("Выберите пункт из меню");
                    break;
            }
        }
        while (!Scan.isStop());
    }
}