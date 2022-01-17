package com.adventures.java8.functional.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MethodWithLambdaAsParameter {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ann a 15", "Mir el 28", "D oru 33");

        List<String> resultWs = replace(
                names, (String s) -> s.replaceAll("\\s", ""));
        List<String> resultNr = replace(
                names, (String s) -> s.replaceAll("\\d", ""));

        System.out.println(resultWs);
        System.out.println(resultNr);
    }

    @SuppressWarnings("unchecked")
    public static Function<String, String> reduceStrings(Function<String, String>... functions) {
        Function<String, String> function = Stream.of(functions)
                .reduce(Function.identity(), Function::andThen);

        return function;
    }

    public static List<String> replace(List<String> list, Replacer<String> r) {

        if (list == null || r == null) {
            throw new IllegalArgumentException("List/replacer cannot be null");
        }

        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(r.replace(s));
        }

        return result;
    }

}
