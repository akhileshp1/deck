package com.akhilesh.deckofcards;

import com.akhilesh.deckofcards.card.Card;
import com.akhilesh.deckofcards.card.CardFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerCardSet implements DeckOfCards {
    private final ShuffleBehavior shuffler;
    private List<Card> cards;

    public PokerCardSet(ShuffleBehavior shuffler, CardFactory cardFactory) {
        this.shuffler = shuffler;
        cards = cardFactory.getListOfCards();
        Collections.reverse(cards);
    }

    @Override
    public void shuffle() {
        int[] sequence = shuffler.getShuffledSequence(cards.size());
        List<Card> updatedSeq = new ArrayList<>();
        for(int i = 0; i < sequence.length; i++) {
            updatedSeq.add(cards.get(sequence[i]-1));
        }
        cards = updatedSeq;
    }

    @Override
    public Card dealOneCard() throws NoCardAvailableException {
        if (cards.size() == 0)
        {
            throw new NoCardAvailableException();
        }
        return cards.remove(cards.size()-1);
    }

    @Override
    public boolean cardAvailable() {
        return cards.size() != 0;
    }
}
