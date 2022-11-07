package moe.queery.needle.color;

import org.jetbrains.annotations.NotNull;

public final class Colors {
    public static float[] rgba(final int color) {
        return new float[]{
                ((color >> 16) & 0xff) / 255f,
                ((color >> 8) & 0xff) / 255f,
                ((color) & 0xff) / 255f,
                ((color >> 24) & 0xff) / 255f
        };
    }

    public static int toDez(final float r, final float g, final float b, final float a) {
        return (((int) (a * 255) & 0xFF) << 24) |
                (((int) (r * 255) & 0xFF) << 16) |
                (((int) (g * 255) & 0xFF) << 8) |
                (((int) (b * 255) & 0xFF));
    }

    public static int toDez(final float @NotNull [] rgba) {
        return toDez(rgba[0], rgba[1], rgba[2], rgba[3]);
    }

    // @formatter:off
    public static int @NotNull [] hsvToRgb(final float @NotNull [] hsv) throws IllegalStateException { return hsvToRgb(hsv[0], hsv[1], hsv[2]); }
    //@formatter:on
    public static int @NotNull [] hsvToRgb(final float hue, final float saturation, final float value) throws IllegalStateException {
        final int h = (int) hue / 60;
        final float f = hue / 60 - h;
        final float p = value * (1 - saturation);
        final float q = value * (1 - f * saturation);
        final float t = value * (1 - (1 - f) * saturation);
        final float[] rgb;
        switch (h) {
            case 0: {
                rgb = new float[]{value, t, p};
                break;
            }
            case 1: {
                rgb = new float[]{q, value, p};
                break;
            }
            case 2: {
                rgb = new float[]{p, value, t};
                break;
            }
            case 3: {
                rgb = new float[]{p, q, value};
                break;
            }
            case 4: {
                rgb = new float[]{t, p, value};
                break;
            }
            case 5:
            case 6: {
                rgb = new float[]{value, p, q};
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        return new int[]{
                (int) (rgb[0] = rgb[0] * 255.F),
                (int) (rgb[1] = rgb[1] * 255.F),
                (int) (rgb[2] = rgb[2] * 255.F)
        };
    }
}
