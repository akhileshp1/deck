package com.akhilesh.deckofcards.test.card;

import com.akhilesh.deckofcards.RandomShuffler;
import org.junit.Assert;
import org.junit.Test;

public class RandomShufflerTest {
    @Test
    public void validateRandomShufflerGeneratesCorrectLengthTest() {
        RandomShuffler shuffler = new RandomShuffler();
        int N = 52;
        Assert.assertEquals("Shuffler should generate right length sequence",
                N, shuffler.getShuffledSequence(N).length);
        N = 0;
        Assert.assertEquals("Shuffler should generate right length sequence",
                N, shuffler.getShuffledSequence(N).length);
    }

    @Test
    public void validateSequenceGeneratedContainsAllNumbersOnceTest() {
        int N = 23;
        boolean[] set = new boolean[N];
        RandomShuffler shuffler = new RandomShuffler();
        int[] sequence = shuffler.getShuffledSequence(N);
        Assert.assertEquals("Random sequence must be length "+N, N, sequence.length);
        for(int i = 0; i < sequence.length; i++) {
            Assert.assertFalse ("", set[i]);
            set[i] = true;
            N--;
        }
        Assert.assertEquals("Each number should be selected once", 0, N);
    }
}
