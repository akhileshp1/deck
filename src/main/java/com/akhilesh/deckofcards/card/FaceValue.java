package com.akhilesh.deckofcards.card;

/**
 * Represents the value on a Card
 */
public enum FaceValue implements Comparable<FaceValue> {
    ACE (1, "Ace"),
    TWO (2, "Two"),
    THREE (3, "Three"),
    FOUR (4, "Four"),
    FIVE (5, "Five"),
    SIX (6, "Six"),
    SEVEN (7, "Seven"),
    EIGHT (8, "Eight"),
    NINE (9, "Nine"),
    TEN (10, "Ten"),
    JACK (11, "Jack"),
    QUEEN (12, "Queen"),
    KING (13, "King");

    private final int value;
    private final String description;

    FaceValue(int value, String description) {
        this.value = value;
        this.description = description;
    }

    int getValue() { return value; }
    String getDescription() { return description; }

    @Override
    public String toString() {
        return description;
    }
}
