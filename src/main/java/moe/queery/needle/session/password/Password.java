package moe.queery.needle.session.password;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import moe.queery.needle.Strings;
import moe.queery.needle.math.Randoms;
import moe.queery.needle.type.pair.Pair;

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

    public static Pair<String, Strength> checkPasswordStrength(final String password) {
        if (password.length() < 8) return new Pair<>("password_length", null);
        if (!NUMBER_PATTERN.matcher(password).find()) return new Pair<>("password_number", null);
        if (!UPPERCASE_PATTERN.matcher(password).find()) return new Pair<>("password_uppercase", null);
        if (!LOWERCASE_PATTERN.matcher(password).find()) return new Pair<>("password_lowercase", null);
        return new Pair<>("password_pass", ZXCVBN.measure(password));
    }

    public static String generateSecurePassword(final int minLength, final int maxLength, final boolean upper, final boolean lower, final boolean special, final boolean number) {
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

    public static String generatePasswordWithMinScore(final int minLength, final int maxLength, final boolean upper, final boolean lower, final boolean special, final boolean number, final int trys, final int score) {
        for (int i = 0; i < trys; i++) {
            final String password = generateSecurePassword(minLength, maxLength, upper, lower, special, number);
            final Pair<String, Strength> passwordSecurity = checkPasswordStrength(password);
            if (!(passwordSecurity.getKey().equalsIgnoreCase("password_pass")
                    && passwordSecurity.getValue().getScore() >= score)) continue;
            return password;
        }
        return "couldnt_find_password";
    }
}
