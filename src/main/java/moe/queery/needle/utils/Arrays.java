package moe.queery.needle.utils;

import java.util.Objects;

public final class Arrays {
    public static boolean contains(final boolean[] array, final boolean value) {
        for (final boolean obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final short[] array, final short value) {
        for (final short obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final int[] array, final int value) {
        for (final int obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final long[] array, final long value) {
        for (final long obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final float[] array, final float value) {
        for (final float obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final double[] array, final double value) {
        for (final double obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final byte[] array, final byte value) {
        for (final byte obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final char[] array, final char value) {
        for (final char obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final String[] array, final String value) {
        for (final String obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(final Object[] array, final Object value) {
        for (final Object obj : array) {
            if (!Objects.equals(obj, value)) continue;
            return true;
        }
        return false;
    }
}
