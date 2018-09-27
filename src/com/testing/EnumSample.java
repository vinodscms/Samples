package com.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnumSample {
    public static void main(String args[]) {
        PizzaMaker maker = new PizzaMaker();
        maker.setStatus(PizzaMaker.PizzaStatus.READY);
        //Questions from Customer whether it is ready or delivered
        System.out.println(maker.statusUpdate(PizzaMaker.PizzaStatus.DELIVERED.toString()));
        System.out.println(maker.statusUpdate(PizzaMaker.PizzaStatus.READY.toString()));
        maker.printDetails();

        maker = new PizzaMaker();
        maker.setStatus(PizzaMaker.PizzaStatus.PREPARING);
        //Questions from Customer whether it is ready or delivered or ordered
        System.out.println(maker.statusUpdate(PizzaMaker.PizzaStatus.DELIVERED.toString()));
        System.out.println(maker.statusUpdate(PizzaMaker.PizzaStatus.READY.toString()));
        System.out.println(maker.statusUpdate(PizzaMaker.PizzaStatus.ORDER.toString()));
        maker.printDetails();

        System.out.println("------------------------");
        //Card shuffle using Enum
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        deck.print();

    }
}

class PizzaMaker {

    private PizzaStatus status;

    //Constants first, then declare variable names, then private constructor
    public enum PizzaStatus {
        ORDER (10,"Just Ordered"){
            @Override
            public boolean isOrdered() {return true;}
        },
        PREPARING (5,"Prepartion going on"){
            @Override
            public boolean isPreparing() {return true;}
            @Override
            public boolean isOrdered() {return true;}
        },
        READY (1,"Ready for pickup/delivery"){
            @Override
            public boolean isReady() {return true;}
            @Override
            public boolean isPreparing() {return true;}
            @Override
            public boolean isOrdered() {return true;}
        },
        DELIVERED (0,"Delivered/Picked up"){
            @Override
            public boolean isDelivered() {return true;}
            @Override
            public boolean isReady() {return true;}
            @Override
            public boolean isPreparing() {return true;}
            @Override
            public boolean isOrdered() {return true;}
        };

        private int timeToDelivery;
        private String text;

        PizzaStatus (int timeToDelivery,String text) {
            this.timeToDelivery = timeToDelivery;
            this.text = text;
        }

        public boolean isPreparing() {return false;}
        public boolean isReady() {return false;}
        public boolean isDelivered(){return false;}
        //abstract method. All enums should override
        public abstract boolean isOrdered();


        public int getTimeToDelivery() {
            return timeToDelivery;
        }
        public String getExplanation() {
            return text;
        }
    }

    public boolean statusUpdate(String whereAt) {
        switch(whereAt){
            case "ORDER" : return this.status.isOrdered();
            case "PREPARING" : return this.status.isPreparing();
            case "READY" : return this.status.isReady();
            case "DELIVERED" : return this.status.isDelivered();
        }
        return false;
    }

    public void printDetails() {
        System.out.println("Pizza is " + this.getStatus().getExplanation());
        System.out.println("Time to delivery is " + this.getStatus().getTimeToDelivery());
    }

    public PizzaStatus getStatus() {return status;}
    public void setStatus(PizzaStatus status) {this.status = status;}

}

enum Suit { SPADE, DIAMOND, CLUB, HEART }
enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }
class Card {
    private Suit suit;
    private Rank rank;
    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    Rank getRank() { return rank; }
    Suit getSuit() { return suit; }
    public String toString() { return rank + " of " + suit; }
}

class DeckOfCards {
    List<Card> deck;
    DeckOfCards() {
        deck = new ArrayList<>();
        //Iterating enums
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }
    public void print() {
        for (Card card : deck) System.out.println(card);
    }
    public void shuffle() {
        Collections.shuffle(deck);
    }
}
