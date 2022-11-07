package moe.queery.needle;

import java.util.List;

public final class Strings {

    // @formatter:off
    private static final String upperCharacters   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerCharacters   = upperCharacters.toLowerCase();
    private static final String specialCharacters = "!@#$%&*()_+-=[]|,./?><";
    private static final String numberCharacters  = "0123456789";

    public static String longestOf(final List<String> strings) { return longestOf(strings.toArray(new String[0])); }
    // @formatter:on

    public static String longestOf(final String... strings) {
        String longestString = "";
        int max = 0;
        for (final String string : strings) if (string.length() > max) max = (longestString = string).length();
        return longestString;
    }

    public static String getLowerCharacters() {
        return lowerCharacters;
    }

    public static String getNumberCharacters() {
        return numberCharacters;
    }

    public static String getSpecialCharacters() {
        return specialCharacters;
    }

    public static String getUpperCharacters() {
        return upperCharacters;
    }
}
