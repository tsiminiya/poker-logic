package com.examples.poker.core.checker;

import com.examples.poker.core.model.Card;
import com.examples.poker.core.model.Suites;

import java.util.*;

public abstract class FlushFinder extends BaseFinder {

    public FlushFinder(Set<Card> cards) {
        super(cards);
    }

    protected Optional<Set<Card>> getFlush() {
        Map<Suites, Set<Card>> suiteCardMap = new HashMap<>();
        for (Card card : cards) {
            Set<Card> suiteCards = suiteCardMap.getOrDefault(card.getSuite(), new HashSet<>());
            suiteCards.add(card);
            suiteCardMap.put(card.getSuite(), suiteCards);
        }

        Set<Map.Entry<Suites, Set<Card>>> suitCardEntries = suiteCardMap.entrySet();
        for (Map.Entry<Suites, Set<Card>> suiteSetEntry : suitCardEntries) {
            if (suiteSetEntry.getValue().size() >= 5) {
                List<Card> cards = new ArrayList<>(suiteSetEntry.getValue());
                cards = sortDescending(cards);
                return Optional.of(new HashSet<>(cards.subList(0, 5)));
            }
        }

        return Optional.empty();
    }

}
