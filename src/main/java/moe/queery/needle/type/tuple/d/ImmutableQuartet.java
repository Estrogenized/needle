package moe.queery.needle.type.tuple.d;

import org.jetbrains.annotations.NotNull;

public final class ImmutableQuartet<A, B, C, D> extends Quartet<@NotNull A, @NotNull B, @NotNull C, @NotNull D> {
    private static final UnsupportedOperationException COULD_NOT_SET = new UnsupportedOperationException("immutable pair-values aren't re-assignable!");
    private final @NotNull A first;
    private final @NotNull B second;
    private final @NotNull C third;
    private final @NotNull D fourth;

    // @formatter:off
    @SuppressWarnings("all") ImmutableQuartet() { this(null, null, null, null); }
    // @formatter:on

    public ImmutableQuartet(final @NotNull A first, final @NotNull B second,
                            final @NotNull C third, final @NotNull D fourth) {
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
    public @Override void setFirst  (final @NotNull A first)  throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setSecond (final @NotNull B second) throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setThird  (final @NotNull C third)  throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setFourth (final @NotNull D fourth) throws UnsupportedOperationException { throw COULD_NOT_SET; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "ImmutableQuartet{first=%s, second=%s, third=%s, fourth=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth()
        );
    }
}
