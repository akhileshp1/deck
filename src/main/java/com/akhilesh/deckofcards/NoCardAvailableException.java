package com.akhilesh.deckofcards;

public class NoCardAvailableException extends Exception {
    public NoCardAvailableException() {
        super("No more cards are available");
    }
}
