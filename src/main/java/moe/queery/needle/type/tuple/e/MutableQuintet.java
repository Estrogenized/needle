package moe.queery.needle.type.tuple.e;

import org.jetbrains.annotations.NotNull;

public final class MutableQuintet<A, B, C, D, E> extends Quintet<@NotNull A, @NotNull B, @NotNull C, @NotNull D, @NotNull E> {
    private @NotNull A first;
    private @NotNull B second;
    private @NotNull C third;
    private @NotNull D fourth;
    private @NotNull E fifth;

    // @formatter:off
    @SuppressWarnings("all") MutableQuintet() { this(null, null, null, null, null); }
    // @formatter:on

    public MutableQuintet(final @NotNull A first, final @NotNull B second,
                          final @NotNull C third, final @NotNull D fourth, final @NotNull E fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()  { return this.first; }
    public @Override @NotNull B getSecond() { return this.second; }
    public @Override @NotNull C getThird()  { return this.third; }
    public @Override @NotNull D getFourth() { return this.fourth; }
    public @Override @NotNull E getFifth()  { return this.fifth; }
    public @Override void setFirst  (final @NotNull A first)  { this.first = first; }
    public @Override void setSecond (final @NotNull B second) { this.second = second; }
    public @Override void setThird  (final @NotNull C third)  { this.third = third; }
    public @Override void setFourth (final @NotNull D fourth) { this.fourth = fourth; }
    public @Override void setFifth  (final @NotNull E fifth) { this.fifth = fifth; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutableQuintet{first=%s, second=%s, third=%s, fourth=%s, fifth=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth(),
                this.getFifth()
        );
    }
}
