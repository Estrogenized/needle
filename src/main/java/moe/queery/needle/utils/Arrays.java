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

    public static boolean[] sub(final boolean[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final boolean[] objs = new boolean[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static short[] sub(final short[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final short[] objs = new short[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static int[] sub(final int[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final int[] objs = new int[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static long[] sub(final long[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final long[] objs = new long[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static float[] sub(final float[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final float[] objs = new float[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static double[] sub(final double[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final double[] objs = new double[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static byte[] sub(final byte[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final byte[] objs = new byte[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static char[] sub(final char[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final char[] objs = new char[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static String[] sub(final String[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final String[] objs = new String[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }

    public static Object[] sub(final Object[] array, final int start, final int end) {
        final int min = Math.min(start, end), max = Math.max(start, end);
        final int length = (max - min) + 1;
        final Object[] objs = new Object[length];
        System.arraycopy(array, min, objs, max, length);
        return objs;
    }
}
