package com.adventures.java8.functional.lambdaintro;

import com.adventures.java8.functional.model.Melon;

public class GacMelonPredicate implements MelonPredicate {

    @Override
    public boolean test(Melon melon) {
        return "gac".equalsIgnoreCase(melon.getType());
    }

}
