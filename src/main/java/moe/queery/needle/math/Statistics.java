package moe.queery.needle.math;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.floats.FloatArrayList;

import java.util.Collections;

/**
 * @author FooFieOwO, lumii500pg
 */
public final class Statistics {
    public static float median(final float... data) {
        return ((data.length % 2) == 0 ?
                ((data[data.length / 2] + data[data.length / 2 - 1]) / 2) :
                data[data.length / 2]);
    }

    public static double median(final double... data) {
        return ((data.length % 2) == 0 ?
                ((data[data.length / 2] + data[data.length / 2 - 1]) / 2) :
                data[data.length / 2]);
    }

    public static float kurtosis(final float... data) {
        final int count = data.length;
        if (count < 3.0F) return 0.0F;
        final float sum = Arithmetics.sum(data);

        final float efficiencyFirst = count * (count + 1.0F) / ((count - 1.0F) * (count - 2.0F) * (count - 3.0F));
        final float efficiencySecond = 3.0F * (float) Math.pow(count - 1.0F, 2.0F) / ((count - 2.0F) * (count - 3.0F));
        final float average = sum / count;

        float variance = 0.0F;
        float varianceSquared = 0.0F;

        for (final float number : data) {
            variance += Math.pow(average - number, 2.0D);
            varianceSquared += Math.pow(average - number, 4.0D);
        }

        return efficiencyFirst * (varianceSquared / (float) Math.pow(variance / sum, 2.0D)) - efficiencySecond;
    }

    public static double kurtosis(final double... data) {
        final int count = data.length;
        if (count < 3.0D) return 0.0D;
        final double sum = Arithmetics.sum(data);

        final double efficiencyFirst = count * (count + 1.0D) / ((count - 1.0D) * (count - 2.0D) * (count - 3.0D));
        final double efficiencySecond = 3.0 * Math.pow(count - 1.0D, 2.0D) / ((count - 2.0D) * (count - 3.0D));
        final double average = sum / count;

        double variance = 0.0D;
        double varianceSquared = 0.0D;

        for (final double number : data) {
            variance += Math.pow(average - number, 2.0D);
            varianceSquared += Math.pow(average - number, 4.0D);
        }

        return efficiencyFirst * (varianceSquared / Math.pow(variance / sum, 2.0D)) - efficiencySecond;
    }

    public static float skewness(final float... data) {
        final int count = data.length;
        final FloatArrayList numbers = new FloatArrayList();

        float sum = 0.0F;

        for (final float number : data) {
            sum += number;
            numbers.add(number);
        }

        Collections.sort(numbers);

        final float mean = sum / count;
        final float median = (count % 2 != 0) ?
                numbers.getFloat(count / 2) :
                (numbers.getFloat((count - 1) / 2)
                        + numbers.getFloat(count / 2)) / 2;
        final float variance = variance(data);

        return 3 * (mean - median) / variance;
    }

    public static double skewness(final double... data) {
        final int count = data.length;
        final DoubleArrayList numbers = new DoubleArrayList();

        double sum = 0.0;

        for (final double number : data) {
            sum += number;
            numbers.add(number);
        }

        Collections.sort(numbers);

        final double mean = sum / count;
        final double median = (count % 2 != 0) ?
                numbers.getDouble(count / 2) :
                (numbers.getDouble((count - 1) / 2)
                        + numbers.getDouble(count / 2)) / 2;
        final double variance = variance(data);

        return 3 * (mean - median) / variance;
    }

    public static float variance(final float... data) {
        final int count = data.length;
        final double sum = Arithmetics.sum(data);
        final double average = sum / count;
        float variance = 0.0F;
        for (final float number : data) variance += Math.pow(number - average, 2.0D);
        return variance / count;
    }

    public static double variance(final double... data) {
        final int count = data.length;
        final double sum = Arithmetics.sum(data);
        final double average = sum / count;
        double variance = 0.0D;
        for (final double number : data) variance += Math.pow(number - average, 2.0D);
        return variance / count;
    }

    public static float standardDeviation(final float... data) {
        return (float) Math.sqrt(variance(data));
    }

    public static double standardDeviation(final double... data) {
        return Math.sqrt(variance(data));
    }
}