package com.turik.adventofcode.day07;

import java.util.Arrays;

public class Bid implements Comparable<Bid> {

    enum Card {
        A, K, Q, J, T, $9, $8, $7, $6, $5, $4, $3, $2
    }

    enum Hand {
        FIVE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD
    }

    Hand hand;

    Card[] cards;

    int bid;

    public Bid(String line) {
        String[] split = line.split(" ");
        String hand = split[0];
        this.bid = Integer.parseInt(split[1]);
        this.cards = new Card[5];
        int[] counts = new int[Card.values().length];
        int i = 0;

        for (char c : hand.toCharArray()) {
            String name = Character.isDigit(c) ? "$" + c : "" + c;
            Card card = Card.valueOf(name);
            this.cards[i++] = card;
            counts[card.ordinal()]++;
        }

        this.hand = this.getHand(counts);
    }

    private Hand getHand(int[] counts) {
        boolean foundThree = false;
        boolean foundTwo = false;

        for (int c: counts) {
            if (c == 5) {
                return Hand.FIVE_OF_A_KIND;
            } else if (c == 4) {
                return Hand.FOUR_OF_A_KIND;
            } else if (c == 3) {
                foundThree = true;
                if (foundTwo) {
                    return Hand.FULL_HOUSE;
                }
            } else if (c == 2) {
                if (foundThree) {
                    return Hand.FULL_HOUSE;
                }
                if (foundTwo) {
                    return Hand.TWO_PAIR;
                }
                foundTwo = true;
            }
        }

        if (foundThree && foundTwo) {
            return Hand.FULL_HOUSE;
        } else if (foundThree) {
            return Hand.THREE_OF_A_KIND;
        } else if (foundTwo) {
            return Hand.ONE_PAIR;
        } else {
            return Hand.HIGH_CARD;
        }
    }

    @Override
    public int compareTo(Bid o) {
        int comparingHand = this.hand.compareTo(o.hand);

        if (comparingHand != 0) {
            return comparingHand;
        }

        for (int i = 0; i < 5; i++) {
            int comparingCards = this.cards[i].compareTo(o.cards[i]);
            if (comparingCards != 0) {
                return comparingCards;
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "hand=" + hand +
                ", highCard=" + Arrays.toString(cards) +
                ", bid=" + bid +
                '}';
    }
}
