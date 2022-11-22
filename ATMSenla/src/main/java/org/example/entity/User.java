package org.example.entity;

public class User extends Card{
    private int cash=0;
    private Card card;

    public int getCash() {return cash;}
    public void setCash(int cash) {this.cash = cash;}

    public Card getCard() {return card;}
    public void setCard(Card card) {this.card = card;}

    public User() {
    }

    public User(int cash, Card card) {
        this.cash = cash;
        this.card = card;
    }
}
