package moe.queery.needle.type.tuple.c;

import org.jetbrains.annotations.NotNull;

public final class MutableTriplet<A, B, C> extends Triplet<@NotNull A, @NotNull B, @NotNull C> {
    private @NotNull A first;
    private @NotNull B second;
    private @NotNull C third;

    // @formatter:off
    @SuppressWarnings("all") MutableTriplet() { this(null, null, null); }
    // @formatter:on

    public MutableTriplet(final @NotNull A first, final @NotNull B second, final @NotNull C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()  { return this.first; }
    public @Override @NotNull B getSecond() { return this.second; }
    public @Override @NotNull C getThird()  { return this.third; }
    public @Override void setFirst  (final @NotNull A first)  { this.first = first; }
    public @Override void setSecond (final @NotNull B second) { this.second = second; }
    public @Override void setThird  (final @NotNull C third)  { this.third = third; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutableTriplet{first=%s, second=%s, third=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird()
        );
    }
}
