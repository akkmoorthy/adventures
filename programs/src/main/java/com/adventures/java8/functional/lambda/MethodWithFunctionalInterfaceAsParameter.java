package com.adventures.java8.functional.lambda;

import java.util.function.Function;
import java.util.stream.Stream;

public class MethodWithFunctionalInterfaceAsParameter {

    public static void main(String[] args) {
        Function<String, String> f1 = (String s) -> s.toUpperCase();
        Function<String, String> f2 = (String s) -> s.concat(" DONE");

        Function<String, String> f = reduceStrings(f1, f2);

        System.out.println(f.apply("test"));
    }

    @SuppressWarnings("unchecked")
    public static Function<String, String> reduceStrings(Function<String, String>... functions) {
        Function<String, String> function = Stream.of(functions)
                .reduce(Function.identity(), Function::andThen);

        return function;
    }
}
