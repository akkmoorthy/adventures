package com.adventures.java8.functional.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebuggingLambda {

    public static void main(String[] args) {

        //The below will throw nullpointerexception and debugging what threw nullpointer is difficult
        /*List<String> names = Arrays.asList("anna", "bob", null, "mary");
        names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());*/

        //The below uses peek which helps in debugging each pipeline to see if there is any exception
        List<String> names1 = Arrays.asList("anna", "bob", "christian", "carmen", "rick", "carla");
//        List<String> names = Arrays.asList("anna", "bob", "christian", null, "carmen", "rick", "carla");
        names1.stream()
                .peek(p -> System.out.println("\tstream(): " + p))
                .filter(s -> s.startsWith("c"))
                .peek(p -> System.out.println("\tfilter(): " + p))
                .map(String::toUpperCase)
                .peek(p -> System.out.println("\tmap(): " + p))
                .sorted()
                .peek(p -> System.out.println("\tsorted(): " + p))
                .collect(Collectors.toList());


    }

}
