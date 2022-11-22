package org.example.service;

import org.example.check.CheckCard;
import org.example.entity.Card;
import org.example.entity.User;
import org.example.sc.Scan;
import org.example.startWork.StartWork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CardService  {
    private static final String link = "file1.txt";
    private static List<Card> cardList = new ArrayList<>();
    public static Card cardUser;
    private static int countMistakes=0;
    private static User user = new User();

    public static void authorization() {
        String numb;
        short pin;
        if(cardList.isEmpty())
        getCards();
        numb=Scan.getSomeString();
        pin=Scan.getSomeInt().shortValue();
        if (CheckCard.checkNumber(numb))
        {
            if (CheckCard.checkPin(Short.toString(pin)))
            {
                for (Card str : cardList)
                {
                    if(numb.equals(str.getCardNumber()) && pin == str.getPin())
                    {

                        cardUser = str;
                        user.setCard(cardUser);
                        System.out.println("Logging..");

                    }
                    else if(countMistakes==cardList.size()-1)
                    {
                        System.out.println("Card not found or pin was wrong");
                    }
                    else countMistakes++;

                }
            }
            else System.out.println("Неверно введен pin код карты. Пример 'xxxx' , только цифры");
        }
        else System.out.println("Неверно введен номер карты. Пример 'xxxx-xxxx-xxxx-xxxx' только цифры");

    }

    public static void getUserCardInfo(){
           if(!(user.getCardNumber()==null)||!(user.getPin()==' '))
           {
                System.out.println("Balance:" + user.getCard().getBalance());
           }
           else
           {
               System.out.println("please, get authorize");
               authorization();
           }
        }
    public static User getUserCard() {
            user.getCard().getCardNumber();
            user.getCard().getPin();
            user.getCard().getBalance();
            return user;
    }

    public static void addCard(){
        cardList.clear();
        try (FileWriter fileWriter = new FileWriter(link,true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
            )
        {
            System.out.println("Введите номер карты и пароль");
            String checkNumb = Scan.getSomeString();

            if(CheckCard.checkNumber(checkNumb))
            {
                Short checkPin = Scan.getSomeInt().shortValue();

                if(CheckCard.checkPin(checkPin.toString()))
                {
                        Card card = new Card().setCardNumber(checkNumb)
                                .setPin(checkPin)
                                .setBalance(0)
                                .setBlocked(false)
                                .build();
                        cardList.add(card);
                        String write;
                        for (Card out : cardList)
                        {
                            write = (out.getCardNumber() + " ");
                            write += (out.getPin() + " ");
                            write += (out.getBalance() + " ");
                            bufferedWriter.write(write + "\n");
                        }
                }
                else
                {
                    System.out.println("Неверно введен pin код карты. Пример 'xxxx' , только цифры");
                    addCard();
                }
            }
            else if(Scan.isStop())
            {
                System.out.println("Выходим");
                StartWork.scanner();
            }
            else
            {
                System.out.println("Неверно введен номер карты. Пример 'xxxx-xxxx-xxxx-xxxx' только цифры");
                addCard();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void getCards(){
        cardList.clear();
        Card card;
        Path path = Path.of(link);
        if(Files.isRegularFile(path))
        {
            try {
                List<String> list = Files.readAllLines(path);
                String out;
                for (int i = 0; i < list.size(); i++) {
                    out = list.get(i);
                    String[] words = out.split(" ");
                        card = new Card().setCardNumber(words[0])
                                .setPin(Short.parseShort(words[1]))
                                .setBalance(Integer.parseInt(words[2]))
                                .build();
                        cardList.add(i, card);
                }
                /*for (Card card1 : cardList) {
                    String number = card1.getCardNumber();
                    short pass = card1.getPin();
                    int cash = card1.getBalance();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    System.out.println("Номер карты - '" + number + "' с паролем - <" + pass + ">." +
                            " На этом счёте:" + cash + "$.");
                    System.out.println("--------------------------------------------------------------------------------------------------");
                }*/
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}