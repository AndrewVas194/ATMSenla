package org.example.service;

import org.example.entity.ATM;
import org.example.entity.Card;
import org.example.entity.User;
import org.example.sc.Scan;

public class UserService {
    private static ATM atm;
    public static int howManyCash(){
        User user ;
        int cash;
        cash = Scan.getSomeInt();
        user = CardService.getUserCard();
        user.setCash(cash);
        return cash;
    }

    public static void addCardBalanceFromCash(){
        int cashUser;
        System.out.println("How much money?");
        cashUser = howManyCash();
        replenishAdd(CardService.cardUser,ATMService.balanceATM(cashUser),cashUser);
    }
    public static void replenishAdd(Card myCard,ATM atm ,int deposit) {
        myCard = CardService.cardUser.build();
        if (deposit > 0 && deposit < 1000000) {
            myCard.setBalance(myCard.getBalance() + deposit);
        } else if (deposit > 0 && deposit <= atm.getBalance()) {
            System.out.println("you cannot deposit more than 1 million");
        } else {
            System.out.println("wrong input");
        }
    }

    public static void decreaseCardBalanceFromCash(){
        int cashUser;
        System.out.println("How much money?");
        cashUser = howManyCash();
        replenishDis(CardService.cardUser,ATMService.balanceATM(cashUser),cashUser);
    }

    public static void replenishDis(Card myCard,ATM atm ,int deposit) {
        myCard = CardService.cardUser.build();
        if (CardService.cardUser.getBalance() > 0 && CardService.cardUser.getBalance() < atm.getBalance()) {
            myCard.setBalance(myCard.getBalance() - deposit);
        } else if (CardService.cardUser.getBalance() > 0 && deposit <= CardService.cardUser.getBalance()) {
            System.out.println("you cannot deposit more than 1 million");
        } else {
            System.out.println("wrong input");
        }
    }

}
