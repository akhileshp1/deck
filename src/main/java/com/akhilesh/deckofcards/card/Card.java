package com.akhilesh.deckofcards.card;

import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card> {
    private final Suit suit;
    private final FaceValue faceValue;

    public Card(Suit suit, FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    /**
     * @return Gets the suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return Get the face value of the card.
     */
    public FaceValue getFaceValue() {
        return faceValue;
    }

    @Override
    public String toString() {
        return faceValue.toString() + " of " + suit.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        return compareTo((Card)obj) == 0;
    }

    @Override
    public int compareTo(Card card) {
        if (card.suit != this.suit)
            return this.suit.compareTo(card.suit);
        return this.faceValue.compareTo(card.faceValue);
    }
}
