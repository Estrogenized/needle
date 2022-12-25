package moe.queery.needle;

import java.util.List;

public final class Strings {
    // @formatter:off
    private static final String UPPER_CHARS   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CHARS   = "abdcefghijklmnopqrstuvwxyz";
    private static final String SPECIAL_CHARS = "!@#$%&*()_+-=[]|,./?><";
    private static final String NUMBER_CHARS  = "0123456789";
    // @formatter:on

    // @formatter:off
    Strings() throws InstantiationException { throw new InstantiationException("it's an utility class!"); }
    // @formatter:on

    // @formatter:off
    public static String longestOf(final List<String> strings) { return longestOf(strings.toArray(new String[0])); }
    // @formatter:on
    public static String longestOf(final String... strings) {
        String longestString = "";
        int max = 0;
        for (final String string : strings) if (string.length() > max) max = (longestString = string).length();
        return longestString;
    }

    // @formatter:off
    public static String smallestOf(final List<String> strings) { return smallestOf(strings.toArray(new String[0])); }
    // @formatter:on
    public static String smallestOf(final String... strings) {
        String smallestString = "";
        long min = Long.MAX_VALUE;
        for (final String string : strings) if (string.length() < min) min = (smallestString = string).length();
        return smallestString;
    }

    // @formatter:off
    public static String getLowerChars()   { return LOWER_CHARS; }
    public static String getNumberChars()  { return NUMBER_CHARS; }
    public static String getSpecialChars() { return SPECIAL_CHARS; }
    public static String getUpperChars()   { return UPPER_CHARS; }
    // @formatter:on
}
