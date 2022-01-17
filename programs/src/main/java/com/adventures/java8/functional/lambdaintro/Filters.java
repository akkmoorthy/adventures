package com.adventures.java8.functional.lambdaintro;

// We will look at how to evolve the code from its basic and rigid implementation to a
// flexible implementation based on a functional interface.

import com.adventures.java8.functional.model.Melon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Let's assume that we have a client – let's call him Mark – who wants to start up a melon-selling business.
// We shaped the preceding class based on his description. His main goal is to have an inventory application
// that will sustain his ideas and decisions, so an application needs to be created that must grow based on
// business requirements and evolution.
public final class Filters {

    private Filters() {
        throw new AssertionError("Cannot be instantiated");
    }

    //Day1: Mark asked to provide a feature for filtering melons by their type
    public static List<Melon> filterByType(List<Melon> melons, String type) {

        if (melons == null || type == null) {
            throw new IllegalArgumentException("Melons/type cannot be null");
        }

        if (melons.isEmpty() || type.isBlank()) {
            return melons;
        }

        List<Melon> result = new ArrayList<>();
        for (Melon melon : melons) {
            if (melon != null && type.equalsIgnoreCase(melon.getType())) {
                result.add(melon);
            }
        }

        return result;
    }

    //Day1: Mark asked to provide a feature for filtering melons by weight
    //This is similar to filterByType(), except it has a different condition/filter.
    // As developers, we are starting to understand that, if we continue like this,
    // then the Filters class will end up with a lot of methods that simply repeat the code
    // and use a different condition. We are very close to a boilerplate code case here.
    public static List<Melon> filterByWeight(List<Melon> melons, int weight) {

        if (melons == null) {
            throw new IllegalArgumentException("Melons cannot be null");
        }

        if (melons.isEmpty() || weight <= 0) {
            return melons;
        }

        List<Melon> result = new ArrayList<>();
        for (Melon melon : melons) {
            if (melon != null && melon.getWeight() == weight) {
                result.add(melon);
            }
        }

        return result;
    }

    //Day 3 (filtering melons by type and weight)
    //Things are getting even worse. Mark has now asked us to add a new filter that filters melons by type and weight,
    // and he needs this quickly. However, the quickest implementation is the ugliest.
    // In our context, this is unacceptable. If we add a new filter criterion here,
    // the code will become hard to maintain as well as prone to errors.
    public static List<Melon> filterByTypeAndWeight(List<Melon> melons, String type, int weight) {

        if (melons == null || type == null) {
            throw new IllegalArgumentException("Melons/type cannot be null");
        }

        if (melons.isEmpty() || type.isBlank() || weight <= 0) {
            return melons;
        }

        List<Melon> result = new ArrayList<>();
        for (Melon melon : melons) {
            if (melon != null && type.equalsIgnoreCase(melon.getType())
                    && melon.getWeight() == weight) {
                result.add(melon);
            }
        }

        return result;
    }

    //If we think of each selection condition/criteria as a behavior, then it is pretty intuitive
    // to think of each behavior as an implementation of an interface.
    // Basically, all these behaviors have something in common – a selection condition/criteria
    // and a return of the boolean type (this is known as a predicate). In the context of an interface,
    // this is a contract that can be written as follows:

    // This technique has a name – the Strategy design pattern. According to GoF, this can "Define a family of algorithms,
    // encapsulate each one, and make them interchangeable. The strategy pattern lets the algorithm vary independently
    // from client to client."

    //So, the main idea is to dynamically select the behavior of an algorithm at runtime.
    // The MelonPredicate interface unifies all the algorithms dedicated to selecting melons, and each implementation
    // of it is a strategy.

    //At the moment, we have the strategies, but we don't have any method that receives a MelonPredicate parameter.
    // We need a filterMelons() method
    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {

        if (melons == null) {
            throw new IllegalArgumentException("Melon cannot be null");
        }

        List<Melon> result = new ArrayList<>();
        for (Melon melon : melons) {
            if (melon != null && predicate.test(melon)) {
                result.add(melon);
            }
        }

        return result;
    }

    // If there are 100 filters then instead of creating 100 strategy classes, it is better to use lambda
    // List<Melon> europeansLambda = Filters.filterMelons(melons, m -> "europe".equalsIgnoreCase(m.getOrigin()));
    // Predicate<Melon> predicate = (Melon m) -> "Watermelon".equalsIgnoreCase(m.getType());
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (t != null && predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }

}
