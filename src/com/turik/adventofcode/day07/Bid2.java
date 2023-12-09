package com.turik.adventofcode.day07;

import java.util.Arrays;
import java.util.List;

public class Bid2 implements Comparable<Bid2> {

    enum Card {
        J, $2, $3, $4, $5, $6, $7, $8, $9, T, Q, K, A
    }

    enum Hand {
        HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FULL_HOUSE, FOUR_OF_A_KIND, FIVE_OF_A_KIND
    }

    Hand hand;

    Card[] cards;

    int bid;

    public Bid2(String line) {
        String[] split = line.split(" ");
        String hand = split[0];
        this.bid = Integer.parseInt(split[1]);
        this.cards = new Card[5];
        int[] counts = new int[Card.values().length];
        int i = 0;
        int jokers = 0;

        for (char c : hand.toCharArray()) {
            String name = Character.isDigit(c) ? "$" + c : "" + c;
            Card card = Card.valueOf(name);
            this.cards[i++] = card;
            if (card != Card.J) {
                counts[card.ordinal()]++;
            } else {
                jokers++;
            }
        }

        this.hand = this.getHand(counts, jokers);
    }

    private Hand getHand(int[] counts, int jokers) {
        if (jokers >= 4) {
            return Hand.FIVE_OF_A_KIND;
        }

        boolean foundThree = false;
        boolean foundTwo = false;
        Hand hand = null;

        for (int c: counts) {
            if (c == 5) {
                hand = Hand.FIVE_OF_A_KIND;
                break;
            } else if (c == 4) {
                hand = Hand.FOUR_OF_A_KIND;
                break;
            } else if (c == 3) {
                foundThree = true;
                if (foundTwo) {
                    hand = Hand.FULL_HOUSE;
                    break;
                }
            } else if (c == 2) {
                if (foundThree) {
                    hand = Hand.FULL_HOUSE;
                    break;
                }
                if (foundTwo) {
                    hand = Hand.TWO_PAIR;
                    break;
                }
                foundTwo = true;
            }
        }

        if (hand == null) {
            if (foundThree && foundTwo) {
                hand = Hand.FULL_HOUSE;
            } else if (foundThree) {
                hand = Hand.THREE_OF_A_KIND;
            } else if (foundTwo) {
                hand = Hand.ONE_PAIR;
            } else {
                hand = Hand.HIGH_CARD;
            }
        }

        if (jokers == 0) {
            return hand;
        } else {
            if (hand == Hand.TWO_PAIR) {
                return Hand.FULL_HOUSE;
            }
            List<Hand> sequence = List.of(Hand.HIGH_CARD, Hand.ONE_PAIR, Hand.THREE_OF_A_KIND, Hand.FOUR_OF_A_KIND, Hand.FIVE_OF_A_KIND);
            return sequence.get(sequence.indexOf(hand) + jokers);
        }
    }

    @Override
    public int compareTo(Bid2 o) {
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
