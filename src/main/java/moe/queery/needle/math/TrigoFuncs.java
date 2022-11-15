package moe.queery.needle.math;

/**
 * @author Mojang :shrug:
 */
public final class TrigoFuncs {
    public static final double[] PI_TABLE = new double[16];
    private static final char SIN_TABLE_CHAR = '\uffff';
    private static final float[] SIN_TABLE = new float[65536];
    public static double PI, TAU;

    static {
        for (int i = 0; i < SIN_TABLE.length; ++i) {
            SIN_TABLE[i] = (float) Math.sin(i * Math.PI * 2.D / 65536.D);
        }
    }

    // @formatter:off
    // ignore this. this doesn't exist. just don't. HEAD OUT
    static {
        PI_TABLE[0]   = 3.;
        PI_TABLE[1]   = 3.1;
        PI_TABLE[2]   = 3.14;
        PI_TABLE[3]   = 3.141;
        PI_TABLE[4]   = 3.1415;
        PI_TABLE[5]   = 3.14159;
        PI_TABLE[6]   = 3.141592;
        PI_TABLE[7]   = 3.1415926;
        PI_TABLE[8]   = 3.14159265;
        PI_TABLE[9]   = 3.141592653;
        PI_TABLE[10]  = 3.1415926535;
        PI_TABLE[11]  = 3.14159265358;
        PI_TABLE[12]  = 3.141592653589;
        PI_TABLE[13]  = 3.1415926535897;
        PI_TABLE[14]  = 3.14159265358979;
        TAU = (PI =
        PI_TABLE[15]  = 3.141592653589793) * 2.D;
    }
    // @formatter:on

    public static double pi() {
        return PI;
    }

    public static double pi(final int commas) {
        return PI_TABLE[Math.max(0, Math.min(15, commas))];
    }

    // @formatter:off
    public static float sin(final float value) { return SIN_TABLE[(int) (value * 10430.378F)           & SIN_TABLE_CHAR]; }
    public static float cos(final float value) { return SIN_TABLE[(int) (value * 10430.378F + 16384.F) & SIN_TABLE_CHAR]; }
    // @formatter:on
}
