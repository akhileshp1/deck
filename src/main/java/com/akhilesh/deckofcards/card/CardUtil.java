package com.akhilesh.deckofcards.card;

import java.util.ArrayList;
import java.util.List;

public class CardUtil {

    /**
     * Creates a new List of all unique cards (all combinations of suit and facevalue).
     *
     * @return The list of unique card combinations.
     */
    public static List<Card> getDeckOfCards() {
        List<Card> result = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(FaceValue faceValue : FaceValue.values()) {
                result.add(new Card(suit, faceValue));
            }
        }
        return result;
    }
}
