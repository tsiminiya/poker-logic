package com.examples.poker.core.checker;

import com.examples.poker.core.model.BestCombination;
import com.examples.poker.core.model.Card;

import java.util.Optional;
import java.util.Set;

public interface Finder {

    Optional<BestCombination> findBestCombination(Set<Card> cards);

}
