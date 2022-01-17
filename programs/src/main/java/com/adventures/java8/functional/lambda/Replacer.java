package com.adventures.java8.functional.lambda;

/*
    Testing a method that takes a lambda as a parameter can be accomplished by passing different lambdas to this method.
 */
@FunctionalInterface
public interface Replacer<String> {
    String replace(String s);
}