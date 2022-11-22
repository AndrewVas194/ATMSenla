package org.example.interfaces;

import org.example.entity.Card;

public interface CardInterface {
    CardInterface setCardNumber(String cardNumber);
    CardInterface setPin(short pin);
    CardInterface setBalance(int balance);
    CardInterface setBlocked(boolean isBlocked);
    Card build();
}
