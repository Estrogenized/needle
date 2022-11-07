package moe.queery.needle.timer;

public class MSTimer extends Timer {
    // @formatter:off
    private long millis = System.currentTimeMillis();
    public @Override void reset()                       { this.millis = System.currentTimeMillis(); }
    public @Override long getTime()                     { return this.millis; }
    public @Override void setTime(final long millis)      { this.millis = millis; }
    public @Override long getElapsedTime()              { return System.currentTimeMillis() - this.millis; }
    public @Override boolean elapsed(final long millis)   { return System.currentTimeMillis() - this.millis > millis; }
    // @formatter:on
}
