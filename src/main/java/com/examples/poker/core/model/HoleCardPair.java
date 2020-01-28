package com.examples.poker.core.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HoleCardPair {

    private final Set<Card> cards;

    public HoleCardPair(Card first, Card second) {
        this.cards = new HashSet<>(Arrays.asList(first, second));
    }

    public Set<Card> getCards() {
        return cards;
    }

}
