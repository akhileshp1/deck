package com.akhilesh.deckofcards;

import com.akhilesh.deckofcards.card.Card;

public interface DeckOfCards {

    /**
     *  Randomizes the order in which the remaining cards are returned.
     */
    void shuffle();

    /**
     * Deals a card from the deck.
     * This call is not synchronized and therefore not thread-safe.
     *
     * @return A Card from the set.
     */
    Card dealOneCard() throws NoCardAvailableException;

    /**
     * @return True if another card is available.
     */
    boolean cardAvailable();
}
