package com.adventures.others.immutable;

import java.lang.reflect.Field;

public class AccessingStringImmutable {

//    Well, behind the scenes, String uses private final char[] to store each character of the string.
//    By using the Java Reflection API, in JDK 8, the following code will modify this char[]
//    (the same code in JDK 11 will throw java.lang.ClassCastException):
    
    public static void main(String[] args) 
            throws NoSuchFieldException, IllegalAccessException {

        String user = "guest";
        System.out.println("User is of type: " + user);

        Class<String> type = String.class;
        Field field = type.getDeclaredField("value");
        field.setAccessible(true);

        char[] chars = (char[]) field.get(user);

        chars[0] = 'a';
        chars[1] = 'd';
        chars[2] = 'm';
        chars[3] = 'i';
        chars[4] = 'n';

        System.out.println("User is of type: " + user);
    }

}
