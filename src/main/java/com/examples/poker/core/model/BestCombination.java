package com.examples.poker.core.model;

import java.util.Set;

public class BestCombination {

    private final Set<Card> cards;
    private final int weight;

    public BestCombination(Set<Card> cards, int weight) {
        this.cards = cards;
        this.weight = weight;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public int getWeight() {
        return weight;
    }

}
