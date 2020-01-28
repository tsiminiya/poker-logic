package com.examples.poker.core.checker;

import com.examples.poker.core.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class BaseFinder implements Finder {

    protected final Set<Card> cards;

    public BaseFinder(Set<Card> cards) {
        this.cards = cards;
    }

    protected List<Card> sortDescending(List<Card> cards) {
        final List<Card> sortedCards = new ArrayList<>(cards);
        Collections.reverse(sortedCards);
        return sortedCards;
    }

}
