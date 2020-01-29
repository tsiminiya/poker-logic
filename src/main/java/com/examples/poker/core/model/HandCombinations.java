package com.examples.poker.core.model;

public enum HandCombinations {
    STRAIGHT_FLUSH(800),
    FOUR_OF_A_KIND(700),
    FULL_HOUSE(600),
    FLUSH(500),
    STRAIGHT(400),
    THREE_OF_A_KIND(300),
    TWO_PAIRS(200),
    ONE_PAIR(100),
    HIGH_HAND(0);

    private int weight;

    HandCombinations(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
