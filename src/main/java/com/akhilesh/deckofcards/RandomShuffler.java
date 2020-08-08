package com.akhilesh.deckofcards;

import com.akhilesh.deckofcards.card.Card;

import java.util.Random;

public final class RandomShuffler implements ShuffleBehavior {
    static final Random rndm = new Random();

    @Override
    public int[] getShuffledSequence(int N) {
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = i + 1;
        }
        for (int i = 0; i < N; i++) {
            int j = i + rndm.nextInt(N - i);
            if (j != i) {
                int previousValue = seq[j];
                seq[j] = seq[i];
                seq[i] = previousValue;
            }
        }
        return seq;
    }
}
