package moe.queery.needle.type.tuple.b;

import org.jetbrains.annotations.NotNull;

public final class ImmutablePair<A, B> extends Pair<@NotNull A, @NotNull B> {
    private static final UnsupportedOperationException COULD_NOT_SET = new UnsupportedOperationException("immutable pair-values aren't re-assignable!");

    private final @NotNull A first;
    private final @NotNull B second;

    // @formatter:off
    @SuppressWarnings("all") ImmutablePair() { this(null, null); }
    // @formatter:on

    public ImmutablePair(final @NotNull A first, final @NotNull B second) {
        this.first = first;
        this.second = second;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()  { return this.first; }
    public @Override @NotNull B getSecond() { return this.second; }
    public @Override void setFirst (final @NotNull A first)  throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setSecond(final @NotNull B second) throws UnsupportedOperationException { throw COULD_NOT_SET; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "ImmutablePair{first=%s, second=%s}",
                this.getFirst(),
                this.getSecond()
        );
    }
}
