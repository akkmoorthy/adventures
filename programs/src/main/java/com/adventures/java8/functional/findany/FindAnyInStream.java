package com.adventures.java8.functional.findany;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyInStream {

    // The findAny() method returns an arbitrary (nondeterministic) element from the stream
    public static void main(String[] args) {

        List<String> melons = Arrays.asList("Gac", "Cantaloupe", "Hemi",
                "Gac", "Gac", "Hemi", "Cantaloupe", "Horned", "Hemi", "Hemi");

        Optional<String> anyMelon = melons.stream()
                .findAny();

        if (!anyMelon.isEmpty()) {
            System.out.println("Any melon: " + anyMelon.get());
        } else {
            System.out.println("No melon was found");
        }

        // We can combine findAny() with other operations as well. Here's an example:
        String anyApollo = melons.stream()
                .filter(m -> m.equals("Apollo"))
                .findAny()
                .orElse("nope");
        System.out.println("Any Apollo? " + anyApollo);
    }

}
