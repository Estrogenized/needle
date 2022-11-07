package moe.queery.needle.math;


import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class Randoms {
    private static final Random
            NORMAL = new Random(),
            SECURE = new SecureRandom();
    private static Random threadLocal = ThreadLocalRandom.current();

    public static int nextInt() {
        return NORMAL.nextInt();
    }

    public static int nextInt(final int bound) {
        return NORMAL.nextInt(bound);
    }

    public static int nextInt(final int min, final int max) {
        return min + (nextInt() * ((max + 1) - min));
    }

    public static int nextSecureInt() {
        return SECURE.nextInt();
    }

    public static int nextSecureInt(final int min, final int max) {
        return min + (nextSecureInt() * ((max + 1) - min));
    }

    public static int nextSecureInt(final int bound) {
        return SECURE.nextInt(bound);
    }

    public static int nextThreadInt(final boolean updateThread) {
        return (threadLocal = updateThread ? ThreadLocalRandom.current() : threadLocal).nextInt();
    }

    public static int nextThreadInt(final int bound, final boolean updateThread) {
        return (threadLocal = updateThread ? ThreadLocalRandom.current() : threadLocal).nextInt(bound);
    }

    public static int nextThreadInt(final int min, final int max, final boolean updateThread) {
        return min + (nextThreadInt(updateThread) * ((max + 1) - min));
    }

    public static float nextFloat() {
        return NORMAL.nextFloat();
    }

    public static float nextFloat(final float min, final float max) {
        return min + (nextFloat() * ((max + 1) - min));
    }

    public static float nextSecureFloat() {
        return SECURE.nextFloat();
    }

    public static float nextSecureFloat(final float min, final float max) {
        return min + (nextSecureFloat() * ((max + 1) - min));
    }

    public static float nextThreadFloat(final boolean updateThread) {
        return (threadLocal = updateThread ? ThreadLocalRandom.current() : threadLocal).nextFloat();
    }

    public static float nextThreadFloat(final float min, final float max, final boolean updateThread) {
        return min + (nextThreadFloat(updateThread) * ((max + 1) - min));
    }

    public static double nextDouble() {
        return NORMAL.nextDouble();
    }

    public static double nextDouble(final double min, final double max) {
        return min + (nextDouble() * ((max + 1) - min));
    }

    public static double nextSecureDouble() {
        return SECURE.nextDouble();
    }

    public static double nextSecureDouble(final double min, final double max) {
        return min + (nextSecureDouble() * ((max + 1) - min));
    }

    public static double nextThreadDouble(final boolean updateThread) {
        return (threadLocal = updateThread ? ThreadLocalRandom.current() : threadLocal).nextDouble();
    }

    public static double nextThreadDouble(final float min, final float max, final boolean updateThread) {
        return min + (nextThreadDouble(updateThread) * ((max + 1) - min));
    }

    public static double nextGaussian() {
        return NORMAL.nextGaussian();
    }

    public static double nextSecureGaussian() {
        return SECURE.nextGaussian();
    }

    public static double nextThreadGaussian(final boolean updateThread) {
        return (threadLocal = updateThread ? ThreadLocalRandom.current() : threadLocal).nextGaussian();
    }

    public static long nextLong() {
        return NORMAL.nextLong();
    }

    public static long nextSecureLong() {
        return SECURE.nextLong();
    }

    public static long nextThreadLong(final boolean updateThread) {
        return (threadLocal = updateThread ? ThreadLocalRandom.current() : threadLocal).nextLong();
    }

    public static void updateThreadLocal() {
        threadLocal = ThreadLocalRandom.current();
    }

    public static byte[] randomBytes(final int min, final int max) { // TODO: ...
        //final byte[] bytes = new byte[randomInt(min, max)];
        //SECURE.nextBytes(bytes);
        //return bytes;
        return new byte[0];
    }
}