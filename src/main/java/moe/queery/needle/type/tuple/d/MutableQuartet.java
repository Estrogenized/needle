package moe.queery.needle.type.tuple.d;

import org.jetbrains.annotations.NotNull;

public final class MutableQuartet<A, B, C, D> extends Quartet<@NotNull A, @NotNull B, @NotNull C, @NotNull D> {
    private @NotNull A first;
    private @NotNull B second;
    private @NotNull C third;
    private @NotNull D fourth;

    // @formatter:off
    @SuppressWarnings("all") MutableQuartet() { this(null, null, null, null); }
    // @formatter:on

    public MutableQuartet(final @NotNull A first, final @NotNull B second, final @NotNull C third, final @NotNull D fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()  { return this.first; }
    public @Override @NotNull B getSecond() { return this.second; }
    public @Override @NotNull C getThird()  { return this.third; }
    public @Override @NotNull D getFourth() { return this.fourth; }
    public @Override void setFirst  (final @NotNull A first)  { this.first = first; }
    public @Override void setSecond (final @NotNull B second) { this.second = second; }
    public @Override void setThird  (final @NotNull C third)  { this.third = third; }
    public @Override void setFourth (final @NotNull D fourth) { this.fourth = fourth; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutableQuartet{first=%s, second=%s, third=%s, fourth=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth()
        );
    }
}
