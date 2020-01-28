package com.examples.poker.core.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class River {

    private final Set<Card> cards;

    public River(Card first, Card second, Card third, Card fourth, Card fifth) {
        this.cards = new HashSet<>(Arrays.asList(first, second, third, fourth, fifth));
    }

    public Set<Card> getCards() {
        return cards;
    }

}
