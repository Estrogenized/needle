package moe.queery.needle.timer;

/**
 * @author Lilly Hense (FooFieOwO)
 * @since 12/10/2022 - 20:25
 */
public abstract class Timer {
    //@formatter:off
    public abstract void reset();

    public abstract long getTime();

    public abstract void setTime(final long time);

    public abstract long getElapsedTime();

    public abstract boolean elapsed(final long time);
    //@formatter:on
}
