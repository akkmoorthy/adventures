package com.adventures.problems;

import java.time.Clock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingSubstringOccurrences {

    private static final String STRING = "111111";
    private static final String SUBSTRING = "11";

    public static void main(String[] args) {

        Clock clock = Clock.systemUTC();
        long startTimeV1 = clock.millis();
        int countV1 = countStringInStringV1(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("V1: '" + SUBSTRING + "' has occured " + countV1 + " times in '" + STRING + "'");

        long startTimeV2 = clock.millis();
        int countV2 = countStringInStringV2(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("V2: '" + SUBSTRING + "' has occured " + countV2 + " times in '" + STRING + "'");

        long startTimeV3 = clock.millis();
        int countV3 = countStringInStringV3(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV3);
        System.out.println("V3: '" + SUBSTRING + "' has occured " + countV3 + " times in '" + STRING + "'");
    }

    public static int countStringInStringV1(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || toFind.isBlank()) {
            return 0;
        }

        int position = 0;
        int count = 0;
        int n = toFind.length();

        while ((position = string.indexOf(toFind, position)) != -1) {
            position = position + n;
            count++;
        }

        return count;
    }

    public static int countStringInStringV2(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || toFind.isBlank()) {
            return 0;
        }

        return string.split(Pattern.quote(toFind), -1).length - 1;
    }

    public static int countStringInStringV3(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || toFind.isBlank()) {
            return 0;
        }

        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);

        int position = 0;
        int count = 0;
        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }

        return count;
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }

}
