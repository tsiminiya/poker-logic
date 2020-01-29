package com.examples.poker.core.checker;

import com.examples.poker.core.model.BestCombination;
import com.examples.poker.core.model.Card;
import com.examples.poker.core.model.Ranks;

import java.util.*;

import static com.examples.poker.core.model.HandCombinations.FOUR_OF_A_KIND;

public class NOfAKindFinder extends BaseFinder {

    public NOfAKindFinder(Set<Card> cards) {
        super(cards);
    }

    @Override
    public Optional<BestCombination> findBestCombination(Set<Card> cards) {
        Map<Ranks, Set<Card>> rankCardsMap = buildRankCardsMap(cards);
        Map<Integer, Set<Card>> nOfAKindMap = buildNOfAKindMap(rankCardsMap);

        Set<Card> fourOfAKind = nOfAKindMap.getOrDefault(4, Collections.emptySet());
        if (!fourOfAKind.isEmpty()) {
            List<Card> remainingCards = removeCardSubsetAndSortDescending(cards, fourOfAKind);
            Card highestCard = remainingCards.get(0);
            Set<Card> bestCards = combineCardSets(fourOfAKind, Collections.singleton(highestCard));
            return fourOfAKind.stream().findFirst()
                    .map(card -> new BestCombination(bestCards, FOUR_OF_A_KIND.getWeight() + card.getRank().getValue()));
        }

        return Optional.empty();
    }

    private Map<Integer, Set<Card>> buildNOfAKindMap(Map<Ranks, Set<Card>> rankCardsMap) {
        Map<Integer, Set<Card>> nOfAKindMap = new HashMap<>();
        Set<Map.Entry<Ranks, Set<Card>>> sameRankEntries = rankCardsMap.entrySet();
        for (Map.Entry<Ranks, Set<Card>> sameRankEntry : sameRankEntries) {
            Integer n = sameRankEntry.getValue().size();
            Set<Card> nkOfAKindCards = nOfAKindMap.getOrDefault(n, new HashSet<>());
            nkOfAKindCards.addAll(sameRankEntry.getValue());
            nOfAKindMap.put(n, nkOfAKindCards);
        }
        return nOfAKindMap;
    }

    private Map<Ranks, Set<Card>> buildRankCardsMap(Set<Card> cards) {
        Map<Ranks, Set<Card>> rankCardsMap = new HashMap<>();
        for (Card card : cards) {
            Set<Card> sameRankCards = rankCardsMap.getOrDefault(card.getRank(), new HashSet<>());
            sameRankCards.add(card);
            rankCardsMap.put(card.getRank(), sameRankCards);
        }
        return rankCardsMap;
    }
}
