package com.akhilesh.deckofcards;

/**
 * Allows
 */
public interface ShuffleBehavior {
    /**
     * @param N The length of the returned array.
     * @return Should return an array of size N  representing a sequence of random numbers from 1..N
     */
    int[] getShuffledSequence(int N);
}
