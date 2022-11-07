package moe.queery.needle.timer;

public abstract class Timer {
    //@formatter:off
    public abstract void reset();
    public abstract long getTime();
    public abstract void setTime(final long time);
    public abstract long getElapsedTime();
    public abstract boolean elapsed(final long time);
    //@formatter:on
}
