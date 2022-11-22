package org.example.check;

import org.example.entity.Card;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCard {
    public static boolean checkNumber(String s){
        Pattern p =Pattern.compile("([0-9]{4})+([-]\\d{4})+([-]\\d{4})+([-]\\d{4})");
        Matcher m = p.matcher(s);
        return m.matches();
    }
    public static boolean checkPin(String s){
        Pattern p =Pattern.compile("([0-9]{4})");
        Matcher m = p.matcher(s);
        return m.matches();
    }
    public void checkBalance(Card myCard) {
        System.out.println(myCard.getBalance());
    }
}
