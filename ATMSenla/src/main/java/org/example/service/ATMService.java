package org.example.service;

import org.example.entity.ATM;

public class ATMService {
    private static ATM atm = new ATM();

    public static ATM balanceATM(int balance){
        long bal = atm.getBalance();
        bal+=balance;
        atm.setBalance(bal);
        return atm;
    }
    public static long getBal(){
       return atm.getBalance();
    }
}
