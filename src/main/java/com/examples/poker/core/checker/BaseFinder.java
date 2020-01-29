package com.examples.poker.core.checker;

import com.examples.poker.core.model.Card;
import com.examples.poker.core.model.Ranks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public abstract class BaseFinder implements Finder {

    protected final Set<Card> cards;

    public BaseFinder(Set<Card> cards) {
        this.cards = cards;
    }

    protected List<Card> removeCardSubsetAndSortDescending(Set<Card> cards, Set<Card> subset) {
        Set<Card> updatedCardSet = removeCardSubset(cards, subset);
        return sortCardsDescending(updatedCardSet);
    }

    protected List<Card> sortCardsDescending(Set<Card> cards) {
        return sortCardsDescending(new ArrayList<>(cards));
    }

    protected List<Card> sortCardsDescending(List<Card> cards) {
        final List<Card> sortedCards = new ArrayList<>(cards);
        return sortedCards.stream().sorted(this::compareByRanks).collect(toList());
    }

    protected List<Ranks> sortRanksDescending(Set<Ranks> ranks) {
        final List<Ranks> sortedRanks = new ArrayList<>(ranks);
        return sortedRanks.stream().sorted(this::compareByRanks).collect(toList());
    }

    protected Set<Card> removeCardSubset(Set<Card> cards, Set<Card> subset) {
        Set<Card> updatedCardSet = new HashSet<>(cards);
        updatedCardSet.removeAll(subset);
        return updatedCardSet;
    }

    protected Set<Card> combineCardSets(Set<Card> cardSet1, Set<Card> cardSet2) {
        Set<Card> combinedCardSet = new HashSet<>(cardSet1);
        combinedCardSet.addAll(cardSet2);
        return combinedCardSet;
    }

    private int compareByRanks(Card card1, Card card2) {
        return compareByRanks(card1.getRank(), card2.getRank());
    }

    private int compareByRanks(Ranks rank1, Ranks rank2) {
        return Integer.signum(rank1.getValue() - rank2.getValue());
    }

}
