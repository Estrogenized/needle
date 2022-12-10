package moe.queery.needle;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import moe.queery.needle.math.Randoms;
import moe.queery.needle.type.tuple.b.MutablePair;

import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * @author Lilly Hense (FooFieOwO)
 * @since 01/10/2022 - 14:27
 */
public final class Password {
    private static final Zxcvbn ZXCVBN = new Zxcvbn();
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]+");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]+");

    private static final Strength EMPTY_STRENGTH = ZXCVBN.measure("");

    public static MutablePair<String, Strength> checkPasswordStrength(final String password) {
        if (password.length() < 8) return new MutablePair<>("password_length", EMPTY_STRENGTH);
        if (!NUMBER_PATTERN.matcher(password).find()) return new MutablePair<>("password_number", EMPTY_STRENGTH);
        if (!UPPERCASE_PATTERN.matcher(password).find()) return new MutablePair<>("password_uppercase", EMPTY_STRENGTH);
        if (!LOWERCASE_PATTERN.matcher(password).find()) return new MutablePair<>("password_lowercase", EMPTY_STRENGTH);
        return new MutablePair<>("password_pass", ZXCVBN.measure(password));
    }

    public static String generateSecurePassword(final int minLength, final int maxLength, final boolean lower, final boolean upper, final boolean number, final boolean special) {
        final String[] categories = new String[4];
        int index = 0;
        if (lower) categories[index++] = Strings.getLowerChars();
        if (upper) categories[index++] = Strings.getUpperChars();
        if (number) categories[index++] = Strings.getNumberChars();
        if (special) categories[index] = Strings.getSpecialChars();

        final int length = Randoms.nextInt(minLength, maxLength);
        final StringBuilder password = new StringBuilder(length);
        final SecureRandom random = new SecureRandom(Randoms.randomBytes(minLength, maxLength));
        for (int i = 0; i < length; i++) {
            final String charCategory = categories[random.nextInt(categories.length)];
            password.append(charCategory.charAt(random.nextInt(charCategory.length())));
        }
        return password.toString();
    }

    public static String generatePasswordWithMinScore(final int minLength, final int maxLength, final int trys, final int score, final boolean lower, final boolean upper, final boolean number, final boolean special) {
        for (int i = 0; i < trys; i++) {
            final String password = generateSecurePassword(minLength, maxLength, lower, upper, number, special);
            final MutablePair<String, Strength> passwordSecurity = checkPasswordStrength(password);
            if (!(passwordSecurity.getFirst().equalsIgnoreCase("password_pass")
                    && passwordSecurity.getSecond().getScore() >= score)) continue;
            return password;
        }
        return "couldnt_find_password";
    }
}
