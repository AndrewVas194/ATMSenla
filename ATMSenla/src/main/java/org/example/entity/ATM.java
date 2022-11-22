package org.example.entity;

import org.example.interfaces.ATMInterface;
import org.example.model.AbstractModel;

public class ATM extends AbstractModel implements ATMInterface {
    private long balance = 35000000;

    public long getBalance() {return balance;}
    public ATMInterface setBalance(long balance) {this.balance = balance;return this;}

    public ATM build() {return this;}

    public ATM() {
    }

    public ATM(long balance) {
        this.balance = balance;
    }
}
