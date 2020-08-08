package com.akhilesh.deckofcards.card;

public enum Suit {
    HEARTS (1, "Hearts"),
    DIAMONDS (2, "Diamonds"),
    SPADES (3, "Spades"),
    CLUBS (4, "Clubs");

    private final int suitValue;
    private final String suitDescription;

    Suit(int suitValue, String suitDescription) {
        this.suitValue = suitValue;
        this.suitDescription = suitDescription;
    }

    @Override
    public String toString() {
        return suitDescription;
    }
}
