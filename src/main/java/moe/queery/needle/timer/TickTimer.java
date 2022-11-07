package moe.queery.needle.timer;

public class TickTimer extends Timer {
    // @formatter:off
    private long ticks = 0;
    public @Override void reset()                       { this.ticks = 0; }
    public @Override long getTime()                     { return this.ticks++; }
    public @Override void setTime(final long ticks)     { this.ticks = ticks; }
    public @Override long getElapsedTime()              { return this.getTime(); }
    public @Override boolean elapsed(final long ticks)  { return this.getTime() > ticks; }
    // @formatter:on
}
