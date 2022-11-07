package moe.queery.needle;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import moe.queery.needle.timer.MSTimer;
import moe.queery.needle.timer.Timer;
import moe.queery.needle.types.Pair;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public final class Maths {
    public static final double[] PI_TABLE = new double[16];
    private static final float[] SIN_TABLE = new float[65536];
    private static final char SIN_TABLE_CHAR = '\uffff';
    public static double PI;

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
        PI =
        PI_TABLE[15]  = 3.141592653589793;
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

    // @formatter:off
    public static int floor(final int value) { return (int) (value + 1024.F) - 1024; }
    public static int floor(final float value) { return (int) (value + 1024.F) - 1024; }
    public static int floor(final double value) { return (int) (value + 1024.F) - 1024; }
    // @formatter:on

    public static double kurtosis(final Collection<? extends Number> data) {
        final int count = data.size();
        if (count < 3.0) return 0.0;
        final double sum = sum(data);

        final double efficiencyFirst = count * (count + 1.0) / ((count - 1.0) * (count - 2.0) * (count - 3.0));
        final double efficiencySecond = 3.0 * Math.pow(count - 1.0, 2.0) / ((count - 2.0) * (count - 3.0));
        final double average = sum / count;

        double variance = 0.0;
        double varianceSquared = 0.0;

        for (final Number number : data) {
            variance += Math.pow(average - number.doubleValue(), 2.0);
            varianceSquared += Math.pow(average - number.doubleValue(), 4.0);
        }

        return efficiencyFirst * (varianceSquared / Math.pow(variance / sum, 2.0)) - efficiencySecond;
    }

    public static double skewness(final Collection<? extends Number> data) {
        final int count = data.size();
        final DoubleArrayList numbers = new DoubleArrayList();

        double sum = 0.0;

        for (final Number number : data) {
            sum += number.doubleValue();
            numbers.add(number.doubleValue());
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

    public static double variance(final Collection<? extends Number> data) {
        final int count = data.size();
        final double sum = sum(data);
        final double average = sum / count;
        double variance = 0.0;
        for (final Number number : data) variance += Math.pow(number.doubleValue() - average, 2.0);
        return variance / count;
    }

    public static Pair<DoubleArrayList, DoubleArrayList> outliers(final Collection<? extends Number> collection) {
        final DoubleArrayList values = new DoubleArrayList();
        for (final Number number : collection) values.add(number.doubleValue());

        final double q1 = median(values.subList(0, values.size() / 2));
        final double q3 = median(values.subList(values.size() / 2, values.size()));

        final double iqr = Math.abs(q1 - q3);
        final double lowThreshold = q1 - 1.5 * iqr, highThreshold = q3 + 1.5 * iqr;

        final Pair<DoubleArrayList, DoubleArrayList> tuple = new Pair<>(new DoubleArrayList(), new DoubleArrayList());
        for (final double value : values) {
            if (value < lowThreshold) tuple.getKey().add(value);
            else if (value > highThreshold) tuple.getValue().add(value);
        }
        return tuple;
    }

    private static double median(final Double... data) {
        return median(Arrays.asList(data));
    }

    private static double median(final List<Double> data) {
        return ((data.size() % 2) == 0) ?
                ((data.get(data.size() / 2) + data.get(data.size() / 2 - 1)) / 2) :
                data.get(data.size() / 2);
    }

    private static double median(final DoubleArrayList data) {
        return ((data.size() % 2) == 0) ?
                ((data.getDouble(data.size() / 2)
                        + data.getDouble(data.size() / 2 - 1)) / 2) :
                data.getDouble(data.size() / 2);
    }

    public static double sum(final Collection<? extends Number> values) {
        double sum = 0.0;
        for (final Number number : values) sum += number.doubleValue();
        return sum;
    }

    public static double avg(final Collection<? extends Number> data) {
        return sum(data) / data.size();
    }

    public static int duplicates(final Collection<? extends Number> data) {
        return (int) (data.size() - data.stream().distinct().count());
    }

    public static int distinct(final Collection<? extends Number> data) {
        return (int) data.stream().distinct().count();
    }

    public static double standardDeviation(final Collection<? extends Number> data) {
        return Math.sqrt(variance(data));
    }

    public static final class Easings {
        public static abstract class Easing {
            public final Timer timer = new MSTimer();

            protected final int duration;
            protected final double end;
            protected boolean backwards;

            public Easing(final int millis, final double end) {
                this(millis, end, false);
            }

            public Easing(final int millis, final double end, final boolean backwards) {
                this.duration = millis;
                this.end = end;
                this.backwards = backwards;
            }

            public boolean isBackwards() {
                return backwards;
            }

            public void setBackwards(final boolean backwards) {
                if (backwards != this.backwards) {
                    this.backwards = backwards;
                    timer.setTime(System.currentTimeMillis() - (duration - Math.min(duration, timer.getElapsedTime())));
                }
            }

            public boolean done() {
                return this.timer.elapsed(duration);
            }

            public double output() {
                return !this.backwards ?
                        this.done() ? this.end
                                : this.equation(this.timer.getElapsedTime()) * this.end :
                        this.done() ? 0
                                : (1 - this.equation(this.timer.getElapsedTime())) * this.end;
            }

            protected abstract double equation(final double value);
        }

        public static final class In {
            public static final class Back extends Easing {
                public Back(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    final double c1 = 1.70158, c3 = c1 + 1;
                    return (c3 * Math.pow(x, 3)) - c1 * Math.pow(x, 2);
                }
            }

            public static final class Bounce extends Easing {
                public Bounce(final int millis, final double end) {
                    super(millis, end);
                }

                private double out(final double value) {
                    double x = value / this.duration;
                    final double n1 = 7.5625;
                    final double d1 = 2.75;
                    return x < 1 / d1 ? n1 * x * x :
                            x < 2 / d1 ? n1 * (x -= 1.5 / d1) * x + 0.75 :
                                    x < 2.5 / d1 ? n1 * (x -= 2.25 / d1) * x + 0.9375 :
                                            n1 * (x -= 2.625 / d1) * x + 0.984375;
                }

                protected @Override double equation(final double value) {
                    return 1 - out(1 - (value / this.duration));
                }
            }

            public static final class Circ extends Easing {
                public Circ(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return 1 - Math.sqrt(1 - Math.pow(value / this.duration, 2));
                }
            }

            public static final class Cubic extends Easing {
                public Cubic(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return Math.pow(value / this.duration, 3);
                }
            }

            public static final class Elastic extends Easing {
                public Elastic(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    return x == 0 ? 0 : x == 1 ? 1 : -Math.pow(2, 10 * x - 10)
                            * Math.sin((x * 10 - 10.75) * ((2 * Math.PI) / 3));
                }
            }

            public static final class Expo extends Easing {
                public Expo(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    return x == 0 ? 0 : Math.pow(2, 10 * x - 10);
                }
            }

            public static final class Quad extends Easing {
                public Quad(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return Math.pow(value / this.duration, 2);
                }
            }

            public static final class Quart extends Easing {
                public Quart(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return Math.pow(value / this.duration, 4);
                }
            }

            public static final class Quint extends Easing {
                public Quint(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return Math.pow(value / this.duration, 5);
                }
            }

            public static final class Sine extends Easing {
                public Sine(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return 1 - Math.cos(((value / this.duration) * PI) / 2);
                }
            }
        }

        public static final class Out {
            public static final class Bounce extends Easing {
                public Bounce(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    double x = value / this.duration;
                    final double n1 = 7.5625;
                    final double d1 = 2.75;
                    return x < 1 / d1 ? n1 * x * x :
                            x < 2 / d1 ? n1 * (x -= 1.5 / d1) * x + 0.75 :
                                    x < 2.5 / d1 ? n1 * (x -= 2.25 / d1) * x + 0.9375 :
                                            n1 * (x -= 2.625 / d1) * x + 0.984375;

                }
            }

            public static final class Back extends Easing {
                public Back(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    final double c1 = 1.70158, c3 = c1 + 1;
                    return 1 + c3 * Math.pow(x - 1, 3) + c1 * Math.pow(x - 1, 2);
                }
            }

            public static final class Circ extends Easing {
                public Circ(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return Math.sqrt(1 - Math.pow(value / this.duration - 1, 2));
                }
            }

            public static final class Cubic extends Easing {
                public Cubic(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return 1 - Math.pow(1 - (value / this.duration), 3);
                }
            }

            public static final class Elastic extends Easing {
                public Elastic(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    return x == 0 ? 0 : x == 1 ? 1 : Math.pow(2, -10 * x) * Math.sin((x * 10 - 0.75) * ((2 * Math.PI) / 3)) + 1;
                }
            }

            public static final class Expo extends Easing {
                public Expo(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    return x == 1 ? 1 : 1 - Math.pow(2, -10 * x);
                }
            }

            public static final class Quad extends Easing {
                public Quad(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return 1 - Math.pow(1 - (value / this.duration), 2);
                }
            }

            public static final class Quart extends Easing {
                public Quart(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return 1 - Math.pow(1 - (value / this.duration), 4);
                }
            }

            public static final class Quint extends Easing {
                public Quint(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return 1 - Math.pow(1 - (value / this.duration), 6);
                }
            }

            public static final class Sine extends Easing {
                public Sine(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return Math.sin(((value / this.duration) * PI) / 2);
                }
            }
        }

        public static final class InOut {
            public static final class Bounce extends Easing {
                public Bounce(final int millis, final double end) {
                    super(millis, end);
                }

                private double out(double value) {
                    final double n1 = 7.5625;
                    final double d1 = 2.75;
                    return value < 1 / d1 ? n1 * value * value :
                            value < 2 / d1 ? n1 * (value -= 1.5 / d1) * value + 0.75 :
                                    value < 2.5 / d1 ? n1 * (value -= 2.25 / d1) * value + 0.9375 :
                                            n1 * (value -= 2.625 / d1) * value + 0.984375;
                }

                protected @Override double equation(final double value) {
                    double x = value / this.duration;
                    return x < 0.5
                            ? (1 - out(1 - 2 * x)) / 2
                            : (1 + out(2 * x - 1)) / 2;
                }
            }

            public static final class Back extends Easing {
                public Back(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    final double c1 = 1.70158, c2 = c1 * 1.525;
                    return x < 0.5
                            ? (Math.pow(2 * x, 2) * ((c2 + 1) * 2 * x - c2)) / 2
                            : (Math.pow(2 * x - 2, 2) * ((c2 + 1) * (x * 2 - 2) + c2) + 2) / 2;
                }
            }

            public static final class Circ extends Easing {
                public Circ(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    return x < 0.5
                            ? (1 - Math.sqrt(1 - Math.pow(2 * x, 2))) / 2
                            : (Math.sqrt(1 - Math.pow(-2 * x + 2, 2)) + 1) / 2;
                }
            }

            public static final class Cubic extends Easing {
                public Cubic(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    return x < 0.5 ? 4 * Math.pow(x, 3) : 1 - Math.pow(-2 * x + 2, 3) / 2;
                }
            }

            public static final class Elastic extends Easing {
                public Elastic(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    final double c5 = (2 * Math.PI) / 4.5;
                    final double sin = Math.sin((20 * x - 11.125) * c5);
                    return x == 0 ? 0 : x == 1 ? 1 : x < 0.5
                            ? -(Math.pow(2, 20 * x - 10) * sin) / 2
                            : (Math.pow(2, -20 * x + 10) * sin) / 2 + 1;
                }
            }

            public static final class Expo extends Easing {
                public Expo(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    final double x = value / this.duration;
                    return x == 0 ? 0 : x == 1 ? 1
                            : x < 0.5 ? Math.pow(2, 20 * x - 10) / 2
                            : (2 - Math.pow(2, -20 * x + 10)) / 2;
                }
            }

            public static final class Quad extends Easing {
                public Quad(final int millis, final double end) {
                    super(millis, end, false);
                }

                public Quad(final int millis, final double end, final boolean backwards) {
                    super(millis, end, backwards);
                }

                protected @Override double equation(final double value) {
                    final double x = value / duration;
                    return x < 0.5 ? 2 * Math.pow(x, 2) : 1 - Math.pow(-2 * x + 2, 2) / 2;
                }
            }

            public static final class Quart extends Easing {
                public Quart(final int millis, final double end) {
                    super(millis, end, false);
                }

                public Quart(final int millis, final double end, final boolean backwards) {
                    super(millis, end, backwards);
                }

                protected @Override double equation(final double value) {
                    final double x = value / duration;
                    return x < 0.5 ? 8 * Math.pow(x, 4) : 1 - Math.pow(-2 * x + 2, 4) / 2;
                }
            }

            public static final class Quint extends Easing {
                public Quint(final int millis, final double end) {
                    super(millis, end, false);
                }

                public Quint(final int millis, final double end, final boolean backwards) {
                    super(millis, end, backwards);
                }

                protected @Override double equation(final double value) {
                    final double x = value / duration;
                    return x < 0.5 ? 16 * Math.pow(x, 5) : 1 - Math.pow(-2 * x + 2, 5) / 2;
                }
            }

            public static final class Sine extends Easing {
                public Sine(final int millis, final double end) {
                    super(millis, end);
                }

                protected @Override double equation(final double value) {
                    return -(Math.cos(PI * (value / this.duration)) - 1) / 2;
                }
            }
        }
    }

    public static final class Randoms {
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
}
