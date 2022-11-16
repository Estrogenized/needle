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

    public static String normalizeSpaces(String input) {
        input = input.replaceAll("\n", "");
        final StringBuilder stringBuilder = new StringBuilder();
        final char[] chars = input.toCharArray();
        final char space = ' ';
        for (int i = 0; i < input.length(); i++) {
            final char preChar = chars[Math.max(0, i - 1)], currChar = chars[i];
            if (i == 0) continue;
            if (currChar == space && i > input.length() - 1) continue;
            if (preChar == space && currChar == space) continue;
            stringBuilder.append(currChar);
        }
        return stringBuilder.toString();
    }

    public static String join(final Iterable<Object> iter, final String joining) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final Object obj : iter) stringBuilder.append(obj).append(joining);
        final String string = stringBuilder.toString();
        return string.substring(0, string.length() - joining.length());
    }

    public static String abbreviateMiddle(final String str, final String middle, final int length) {
        if (str.isEmpty() || middle.isEmpty()) return str;
        if (length >= str.length() || length < (middle.length() + 2)) return str;
        final int target = length - middle.length();
        return str.substring(0, target / 2 + target % 2) + middle + str.substring(str.length() - target / 2);
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

    public static String unescapeJava(final String st) {
        final StringBuilder sb = new StringBuilder(st.length());
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == '\\') {
                char nextChar = (i == st.length() - 1) ? '\\' : st.charAt(i + 1);
                if (nextChar >= '0' && nextChar <= '7') {
                    String code = "" + nextChar;
                    i++;
                    if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                            && st.charAt(i + 1) <= '7') {
                        code += st.charAt(i + 1);
                        i++;
                        if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                                && st.charAt(i + 1) <= '7') {
                            code += st.charAt(i + 1);
                            i++;
                        }
                    }
                    sb.append((char) Integer.parseInt(code, 8));
                    continue;
                }
                switch (nextChar) {
                    case '\\':
                        ch = '\\';
                        break;
                    case 'b':
                        ch = '\b';
                        break;
                    case 'f':
                        ch = '\f';
                        break;
                    case 'n':
                        ch = '\n';
                        break;
                    case 'r':
                        ch = '\r';
                        break;
                    case 't':
                        ch = '\t';
                        break;
                    case '\"':
                        ch = '\"';
                        break;
                    case '\'':
                        ch = '\'';
                        break;
                    case 'u':
                        if (i >= st.length() - 5) {
                            ch = 'u';
                            break;
                        }
                        int code = Integer.parseInt(
                                "" + st.charAt(i + 2) + st.charAt(i + 3)
                                        + st.charAt(i + 4) + st.charAt(i + 5), 16);
                        sb.append(Character.toChars(code));
                        i += 5;
                        continue;
                }
                i++;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
