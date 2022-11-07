package moe.queery.needle.math;

import moe.queery.needle.timer.MSTimer;

import static java.lang.Math.PI;

/**
 * @author lumii500pg
 */
public final class Easings {
    public static abstract class Easing {
        public final MSTimer timer = new MSTimer();

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
