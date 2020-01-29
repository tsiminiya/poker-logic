package com.examples.poker.core.checker;

import com.examples.poker.core.model.BestCombination;
import com.examples.poker.core.model.Card;
import com.examples.poker.core.model.Suites;

import java.util.*;

import static com.examples.poker.core.model.HandCombinations.FLUSH;
import static com.examples.poker.core.model.HandCombinations.STRAIGHT_FLUSH;

public class FlushFinder extends BaseFinder {

    public FlushFinder(Set<Card> cards) {
        super(cards);
    }

    @Override
    public Optional<BestCombination> findBestCombination(Set<Card> cards) {
        return getFlush().map(this::computeAndAddWeight);
    }

    private BestCombination computeAndAddWeight(Set<Card> cards) {
        List<Card> cardList = sortCardsDescending(cards);
        Card highestCard = cardList.get(0);
        Card lowestCard = cardList.get(4);
        if (highestCard.getRank().getValue() - lowestCard.getRank().getValue() == 4) {
            return new BestCombination(cards, STRAIGHT_FLUSH.getWeight() + highestCard.getRank().getValue());
        }
        return new BestCombination(cards, FLUSH.getWeight() + highestCard.getRank().getValue());
    }

    private Optional<Set<Card>> getFlush() {
        Map<Suites, Set<Card>> suiteCardsMap = buildSuiteCardsMap();

        Set<Map.Entry<Suites, Set<Card>>> suitCardEntries = suiteCardsMap.entrySet();
        for (Map.Entry<Suites, Set<Card>> suiteSetEntry : suitCardEntries) {
            if (suiteSetEntry.getValue().size() >= 5) {
                List<Card> cards = new ArrayList<>(suiteSetEntry.getValue());
                cards = sortCardsDescending(cards);
                return Optional.of(new HashSet<>(cards.subList(0, 5)));
            }
        }

        return Optional.empty();
    }

    private Map<Suites, Set<Card>> buildSuiteCardsMap() {
        Map<Suites, Set<Card>> suiteCardsMap = new HashMap<>();
        for (Card card : cards) {
            Set<Card> suiteCards = suiteCardsMap.getOrDefault(card.getSuite(), new HashSet<>());
            suiteCards.add(card);
            suiteCardsMap.put(card.getSuite(), suiteCards);
        }
        return suiteCardsMap;
    }
}
