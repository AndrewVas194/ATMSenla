package org.example.entity;

import org.example.interfaces.CardInterface;
import org.example.model.AbstractModel;

public class Card extends AbstractModel implements CardInterface {

    private String cardNumber;
    private short pin;
    private int balance = 0;
    private boolean isBlocked;

    public String getCardNumber() {return cardNumber;}
    public CardInterface setCardNumber(String cardNumber) {this.cardNumber = cardNumber;return this;}

    public short getPin() {return pin;}
    public CardInterface setPin(short pin) {this.pin = pin;return this;}

    public int getBalance() {return balance;}
    public CardInterface setBalance(int balance) {this.balance = balance;return this;}

    public boolean isBlocked() {return isBlocked;}
    public CardInterface setBlocked(boolean blocked) {this.isBlocked = blocked;return this;}

    public Card build() {return this;}

    public Card() {
    }

    public Card(String cardNumber, short pin , int balance,boolean isBlocked) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.isBlocked = false;
    }

    @Override
    public void print() {
        super.print();
    }
}