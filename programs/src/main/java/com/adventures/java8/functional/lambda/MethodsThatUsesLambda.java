package com.adventures.java8.functional.lambda;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodsThatUsesLambda {

    //lambda that is not wrapped in a method
    public static void testFirstAndLastChar() {
        String text = "Lambda";
        String result = firstAndLastChar.apply(text);
        System.out.println(result);
    }

    public static final Function<String, String> firstAndLastChar
            = (String s) -> String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(s.length() - 1));

    // Testing the method that contains the lambda is acceptable, but there are cases when we want to test
    // the lambda itself. A solution to this problem consists of three main steps:
    // 1. Extracting the lambda in a static method
    // 2. Replacing the lambda with a method reference
    // 3. Testing this static method
    public static List<String> rndStringFromStrings(List<String> strs) {

        // The below is with lambda without a method
//        return strs.stream()
//                .map(str -> {
//                    Random rnd = new Random();
//                    int nr = rnd.nextInt(str.length());
//                    String ch = String.valueOf(str.charAt(nr));
//
//                    return ch;
//                })
//                .collect(Collectors.toList());

        // The below is with lambda wrapped with a method
        return strs.stream()
                .map(MethodsThatUsesLambda::extractCharacter)
                .collect(Collectors.toList());
    }

    public static String extractCharacter(String str) {
        Random rnd = new Random();
        int nr = rnd.nextInt(str.length());
        String chAsStr = String.valueOf(str.charAt(nr));

        return chAsStr;
    }

    public static void main(String[] args) {
        testFirstAndLastChar();
        System.out.println(rndStringFromStrings(List.of("Some", "random", "text")));
    }

}
