package moe.queery.needle.color;

public final class Color {

    /*
        This is a faster Color class then Color from java.awt
     */

    //@formatter:off
    public static final Color white       = new Color(255, 255, 255);

    public static final Color lightGray   = new Color(192, 192, 192);

    public static final Color gray        = new Color(128, 128, 128);

    public static final Color darkGray    = new Color(64, 64, 64);

    public static final Color black       = new Color(0, 0, 0);

    public static final Color red         = new Color(255, 0, 0);

    public static final Color pink        = new Color(255, 175, 175);

    public static final Color orange      = new Color(255, 200, 0);

    public static final Color yellow      = new Color(255, 255, 0);

    public static final Color green       = new Color(0, 255, 0);

    public static final Color magenta     = new Color(255, 0, 255);

    public static final Color cyan        = new Color(0, 255, 255);

    public static final Color blue        = new Color(0, 0, 255);
    //@formatter:on

    private final int rgb;

    public Color(final int r, final int g, final int b) {
        this(r, g, b, 255);
    }

    public Color(final int r, final int g, final int b, final int a) {
        this(((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF));
    }

    public Color(final java.awt.Color jColor) {
        this(jColor.getRGB());
    }

    public Color(final int rgb) {
        this.rgb = rgb;
    }

    public int getRGB() {
        return rgb;
    }

    public int getRed() {
        return (getRGB() >> 16) & 0xFF;
    }

    public int getGreen() {
        return (getRGB() >> 8) & 0xFF;
    }

    public int getBlue() {
        return getRGB() & 0xFF;
    }

    public int getAlpha() {
        return (getRGB() >> 24) & 0xff;
    }

    public Color darker(final float factor) {
        return new Color(Math.max((int) (getRed() * factor), 0), Math.max((int) (getGreen() * factor), 0), Math.max((int) (getBlue() * factor), 0), getAlpha());
    }

    public Color brighter(final float factor) {
        int r = getRed();
        int g = getGreen();
        int b = getBlue();
        int alpha = getAlpha();
        final int i = (int) (1.0 / (1.0 - factor));

        if (r == 0 && g == 0 && b == 0) {
            return new Color(i, i, i, alpha);
        }

        if (r > 0 && r < i) r = i;
        if (g > 0 && g < i) g = i;
        if (b > 0 && b < i) b = i;

        return new Color(Math.min((int) (r * factor), 255),
                Math.min((int) (g * factor), 255),
                Math.min((int) (b * factor), 255),
                alpha);
    }
}
