package com.akhilesh.deckofcards.card;

import java.util.List;

public class FullSetOfCardsFactory implements CardFactory {
    @Override
    public List<Card> getListOfCards() {
        return CardUtil.getDeckOfCards();
    }
}
