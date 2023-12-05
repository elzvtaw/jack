package ru.dolbak.blackjack;

import static java.lang.Math.abs;

import java.util.Random;

class Deck{
    int pointer = 0;
    Card[] cards = new Card[52];
    Card[] cards2 = new Card[52];
    //TODO: конструктор, в котором перемешиваются карты
    // создать карту - вызвать new Card(Rate, Suit)

    //TODO:" функция take() - взять карту из колоды
    Suit[] suits = {Suit.Hearts, Suit.Clubs, Suit.Spades, Suit.Diamonds};
    Rate[] rates = {Rate.TWO, Rate.THREE, Rate.FOUR, Rate.FIVE, Rate.SIX, Rate.SEVEN, Rate.EIGHT, Rate.NINE, Rate.TEN, Rate.JACK, Rate.QUEEN, Rate.KING, Rate.ACE};

    public Deck(){
        for (int i=0; i<4; i++){
            for (int j=0; j<13; j++){
                cards[i*13+j]= new Card(rates[j] , suits[i]);
            }
        }
        Random rnd = new Random();
        for(int i=0; i< cards.length; i++){
            int randomIndex= abs(rnd.nextInt()) % (cards.length - i);
            cards2[i]=cards[randomIndex];
            cards[randomIndex]= cards[cards.length-i-1];
        }
    }
    public Card take(){
        pointer++;
        return cards2[pointer-1];
    }

}

enum Suit{
    Diamonds,
    Hearts,
    Spades,
    Clubs
}

enum Rate{
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(1),
    COVER(0);
    private int points;
    Rate(int points){
        this.points = points;
    }
    public int getPoints(){
        return this.points;
    }
}

class Card{
    Rate rate;
    Suit suit;
    int points = 0;
    public Card(Rate rate, Suit suit){
        this.rate = rate;
        this.suit = suit;
    }

    //TODO: в points записать очки карты
}

class Game{
    //TODO переменные для очков игрока и крупье
    //методы для взятия карты игроком и крупье
    //метод для вывода очков игрока и крупье
    //метод для вывода карт игрока и крупье
    //определить, кто победил

}

