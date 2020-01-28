package com.examples.poker.core;

import com.examples.poker.core.exception.InvalidHoleCardPairException;
import com.examples.poker.core.exception.InvalidRiverException;
import com.examples.poker.core.model.BestCombination;
import com.examples.poker.core.model.Card;
import com.examples.poker.core.model.HoleCardPair;
import com.examples.poker.core.model.River;

public class PokerLogic {

    public BestCombination determineBestCombination(River river, HoleCardPair holeCardPair) {
        if (river.getCards().stream().anyMatch(this::isInvalidCard)) {
            throw new InvalidRiverException();
        }

        if (holeCardPair.getCards().stream().anyMatch(this::isInvalidCard)) {
            throw new InvalidHoleCardPairException();
        }

        return null;
    }

    private boolean isInvalidCard(Card card) {
        return card == null || card.getRank() == null || card.getSuite() == null;
    }

}
