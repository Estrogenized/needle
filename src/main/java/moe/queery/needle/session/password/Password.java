package moe.queery.needle.session.password;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import moe.queery.needle.Maths;
import moe.queery.needle.Strings;
import moe.queery.needle.types.Pair;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author Lilly Hense (FooFieOwO)
 * @since 01/10/2022 - 14:27
 */
public class Password {
    private final static Zxcvbn zxcvbn = new Zxcvbn();
    private final static Pattern numberPattern = Pattern.compile("[0-9]+");
    private final static Pattern uppercasePattern = Pattern.compile("[A-Z]+");
    private final static Pattern lowercasePattern = Pattern.compile("[a-z]+");

    public static Pair<String, Strength> checkPasswordStrength(final String password) {
        if (password.length() < 8)
            return new Pair<>("password_length", null);
        if (!numberPattern.matcher(password).find())
            return new Pair<>("password_number", null);
        if (!uppercasePattern.matcher(password).find())
            return new Pair<>("password_uppercase", null);
        if (!lowercasePattern.matcher(password).find())
            return new Pair<>("password_lowercase", null);
        return new Pair<>("password_pass", zxcvbn.measure(password));
    }

    public static String generateSecurePassword(final int minLength, final int maxLength, final boolean upper, final boolean lower, final boolean special, final boolean number) {
        final int length = Maths.Randoms.nextInt(minLength, maxLength);
        final StringBuilder password = new StringBuilder(length);
        final Random random = new SecureRandom(Maths.Randoms.randomBytes(minLength, maxLength));
        final List<String> charCategories = new ArrayList<>(4);

        if (lower) charCategories.add(Strings.getLowerCharacters());
        if (upper) charCategories.add(Strings.getUpperCharacters());
        if (number) charCategories.add(Strings.getNumberCharacters());
        if (special) charCategories.add(Strings.getSpecialCharacters());

        for (int i = 0; i < length; i++) {
            final String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            final int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return password.toString();
    }

    public static String generatePasswordWithMinScore(final int minLength, final int maxLength, final boolean upper, final boolean lower, final boolean special, final boolean number, final int trys, final int score) {
        for (int i = 0; i < trys; i++) {
            final String password = generateSecurePassword(minLength, maxLength, upper, lower, special, number);
            final Pair<String, Strength> passwordSecurity = checkPasswordStrength(password);
            if (passwordSecurity.getKey().equalsIgnoreCase("password_pass") && passwordSecurity.getValue().getScore() >= score)
                return password;
        }
        return "couldnt_find_password";
    }
}
