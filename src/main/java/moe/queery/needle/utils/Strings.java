package moe.queery.needle.utils;

import java.util.List;

public final class Strings {

    // @formatter:off
    private static final String UPPER_CHARS   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CHARS   = "abdcefghijklmnopqrstuvwxyz";
    private static final String SPECIAL_CHARS = "!@#$%&*()_+-=[]|,./?><";
    private static final String NUMBER_CHARS  = "0123456789";

    public static String longestOf(final List<String> strings) { return longestOf(strings.toArray(new String[0])); }
    // @formatter:on

    public static String longestOf(final String... strings) {
        String longestString = "";
        int max = 0;
        for (final String string : strings) if (string.length() > max) max = (longestString = string).length();
        return longestString;
    }

    public static String sub(final String input, final int sub) {
        return input.substring(Math.min(input.length(), sub));
    }

    public static String sub(final String input, final int start, final int end) {
        int min = Math.min(start, end), max = Math.max(start, end);
        min = Math.min(input.length(), min);
        max = Math.min(input.length(), min);
        return input.substring(min, max);
    }

    public static String getLowerChars() {
        return LOWER_CHARS;
    }

    public static String getNumberChars() {
        return NUMBER_CHARS;
    }

    public static String getSpecialChars() {
        return SPECIAL_CHARS;
    }

    public static String getUpperChars() {
        return UPPER_CHARS;
    }
}
