package moe.queery.needle.math;

/**
 * @author FooFieOwO, lumii500pg
 */
public final class Arithmetics {
    public static int sum(final int... values) {
        int value = 0;
        for (final int i : values) value += i;
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

    public static int avg(final int... data) {
        return sum(data) / data.length;
    }

    public static float avg(final float... data) {
        return sum(data) / data.length;
    }

    public static double avg(final double... data) {
        return sum(data) / data.length;
    }
}