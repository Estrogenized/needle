package moe.queery.needle.type.tuple.b;

import org.jetbrains.annotations.NotNull;

public final class MutablePair<A, B> extends Pair<@NotNull A, @NotNull B> {
    private @NotNull A first;
    private @NotNull B second;

    // @formatter:off
    @SuppressWarnings("all") MutablePair() { this(null, null); }
    // @formatter:on

    public MutablePair(final @NotNull A first, final @NotNull B second) {
        this.first = first;
        this.second = second;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()  { return this.first; }
    public @Override @NotNull B getSecond() { return this.second; }
    public @Override void setFirst (final @NotNull A first)  { this.first = first; }
    public @Override void setSecond(final @NotNull B second) { this.second = second; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutablePair{first=%s, second=%s}",
                this.getFirst(),
                this.getSecond()
        );
    }
}
