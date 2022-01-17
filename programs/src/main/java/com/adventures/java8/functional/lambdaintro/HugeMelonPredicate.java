package com.adventures.java8.functional.lambdaintro;

import com.adventures.java8.functional.model.Melon;

public class HugeMelonPredicate implements MelonPredicate {

    @Override
    public boolean test(Melon melon) {
        return melon.getWeight() > 5000;
    }

}
