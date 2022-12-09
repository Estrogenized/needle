package moe.queery.needle.math;

/**
 * @author FooFieOwO, lumii500pg
 */
public final class Arithmetics {
    public static short sum(final short... values) {
        short value = 0;
        for (final short i : values) value += i;
        return value;
    }

    public static int sum(final int... values) {
        int value = 0;
        for (final int i : values) value += i;
        return value;
    }

    public static long sum(final long... values) {
        long value = 0;
        for (final long i : values) value += i;
        return value;
    }

    public static float sum(final float... values) {
        float value = 0;
        for (final float f : values) value += f;
        return value;
    }

    public static double sum(final double... values) {
        double value = 0;
        for (final double d : values) value += d;
        return value;
    }

    public static int avgI(final short... data) {
        return Math.round(sum(data)) / data.length;
    }

    public static int avgI(final int... data) {
        return Math.round(sum(data)) / data.length;
    }

    public static int avgI(final float... data) {
        return Math.round(sum(data)) / data.length;
    }

    public static int avgI(final double... data) {
        return (int) clamp(Math.round(sum(data)), Integer.MIN_VALUE, Integer.MAX_VALUE) / data.length;
    }

    public static float avgF(final short... data) {
        return sum(data) / (float) data.length;
    }

    public static float avgF(final int... data) {
        return sum(data) / (float) data.length;
    }

    public static float avgF(final float... data) {
        return sum(data) / (float) data.length;
    }

    public static float avgF(final double... data) {
        return Math.round(sum(data)) / (float) data.length;
    }


    public static double avgD(final short... data) {
        return sum(data) / (double) data.length;
    }

    public static double avgD(final int... data) {
        return sum(data) / (double) data.length;
    }

    public static double avgD(final float... data) {
        return sum(data) / (double) data.length;
    }

    public static double avgD(final double... data) {
        return Math.round(sum(data)) / (double) data.length;
    }

    public static short clamp(final short value, final short minimum, final short maximum) {
        return (short) Math.max(minimum, Math.min(maximum, value));
    }

    public static int clamp(final int value, final int minimum, final int maximum) {
        return Math.max(minimum, Math.min(maximum, value));
    }

    public static long clamp(final long value, final long minimum, final long maximum) {
        return Math.max(minimum, Math.min(maximum, value));
    }

    public static float clamp(final float value, final float minimum, final float maximum) {
        return Math.max(minimum, Math.min(maximum, value));
    }

    public static double clamp(final double value, final double minimum, final double maximum) {
        return Math.max(minimum, Math.min(maximum, value));
    }
}
