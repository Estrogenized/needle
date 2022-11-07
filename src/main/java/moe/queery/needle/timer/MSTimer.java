package moe.queery.needle.timer;

/**
 * @author Lilly Hense (FooFieOwO)
 * @since 12/10/2022 - 20:29
 */
public class MSTimer extends Timer {

    private long millis = System.currentTimeMillis();

    @Override
    public void reset() {
        this.millis = System.currentTimeMillis();
    }

    @Override
    public long getTime() {
        return this.millis;
    }

    @Override
    public void setTime(final long time) {
        this.millis = time;
    }

    @Override
    public long getElapsedTime() {
        return System.currentTimeMillis() - this.millis;
    }

    @Override
    public boolean elapsed(final long time) {
        return System.currentTimeMillis() - this.millis > time;
    }

}
