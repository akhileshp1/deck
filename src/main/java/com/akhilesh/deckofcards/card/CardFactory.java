package com.akhilesh.deckofcards.card;

import com.akhilesh.deckofcards.card.Card;
import com.akhilesh.deckofcards.card.CardUtil;

import java.util.List;

public interface CardFactory {
    /**
     * @return A list of cards.
     */
    List<Card> getListOfCards();
}
