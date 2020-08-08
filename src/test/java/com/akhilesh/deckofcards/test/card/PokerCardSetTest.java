package com.akhilesh.deckofcards.test.card;

import com.akhilesh.deckofcards.*;
import com.akhilesh.deckofcards.card.Card;
import com.akhilesh.deckofcards.card.CardUtil;
import com.akhilesh.deckofcards.card.FullSetOfCardsFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PokerCardSetTest {

    static final List<Card> fullListOfCards = CardUtil.getDeckOfCards();

    @Test
    public void verifyDefaultOrderTest() throws NoCardAvailableException {

        PokerCardSet pcs = new PokerCardSet(new RandomShuffler(), new FullSetOfCardsFactory() );
        List<Card> pulledCards = new ArrayList<>();
        while (pcs.cardAvailable()) {
            pulledCards.add(pcs.dealOneCard());
        }
        Assert.assertEquals("Count of cards pulled should be equal to the original",
                fullListOfCards.size(), pulledCards.size());
        Assert.assertArrayEquals("The order of cards should be preserved if no shuffle() called",
                fullListOfCards.toArray(), pulledCards.toArray());
    }

    @Test
    public void verifyFixedOrderTest() throws NoCardAvailableException {

        final int callCount[] = { 0 };

        PokerCardSet pcs = new PokerCardSet(new ShuffleBehavior() {
            @Override
            public int[] getShuffledSequence(int N) {
                callCount[0]++;
                Assert.assertFalse("Random generator called too many times",
                        callCount[0] > 1);
                int [] fixed = new int[N];
                for(int i = 0; i < N; i++) {
                    fixed[i] = N-i;
                }
                return fixed;
            }
        }, new FullSetOfCardsFactory() );
        List<Card> pulledCards = new ArrayList<>();
        pcs.shuffle();
        Assert.assertEquals("Random generator should be called 1 times", 1, callCount[0]);
        while (pcs.cardAvailable()) {
            pulledCards.add(pcs.dealOneCard());
        }
        Assert.assertEquals("Count of cards pulled should be equal to the original",
                fullListOfCards.size(), pulledCards.size());
        Collections.reverse(pulledCards);
        Assert.assertArrayEquals("Order of cards should be reversed with fixed sort strategy",
                fullListOfCards.toArray(), pulledCards.toArray());
    }

    @Test(expected = NoCardAvailableException.class)
    public void verifyAllCardsReturnedTest() throws NoCardAvailableException {
        final PokerCardSet pcs = new PokerCardSet(new RandomShuffler(), new FullSetOfCardsFactory());
        final Set<Card> pulledCards = new TreeSet<>();
        try {
            pcs.shuffle();
            while (pcs.cardAvailable()) {
                pulledCards.add(pcs.dealOneCard());
            }
            Assert.assertEquals(fullListOfCards.size(), pulledCards.size());
            for(Card c : fullListOfCards) {
                Assert.assertTrue("Card not found", pulledCards.contains(c));
            }
        }
        catch(NoCardAvailableException e) {
            Assert.fail("Ran out of cards");
        }
        pcs.dealOneCard();
        Assert.fail("Should never return a card after cardAvailable() is false");
    }
}
