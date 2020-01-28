package com.examples.poker.core.model;

import java.util.Objects;

public class Card {

    private final Ranks rank;
    private final Suites suite;

    public Card(Ranks rank, Suites suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Ranks getRank() {
        return rank;
    }

    public Suites getSuite() {
        return suite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                suite == card.suite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suite);
    }
}
