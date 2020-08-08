package com.akhilesh.deckofcards.test.card;

import com.akhilesh.deckofcards.card.Card;
import com.akhilesh.deckofcards.card.CardUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CardUtilTest {
    @Test
    public void getListOfCardsTest() {
        List<Card> listOfCards = CardUtil.getDeckOfCards();
        Set<Card> cardSet = new TreeSet<>(listOfCards);
        Assert.assertEquals(cardSet.size(),listOfCards.size());
        Assert.assertEquals(52, cardSet.size());
        for(Card c : listOfCards)
        {
            Assert.assertTrue(cardSet.contains(c));
        }
    }
}
