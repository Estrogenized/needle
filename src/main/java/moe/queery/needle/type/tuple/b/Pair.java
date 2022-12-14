package moe.queery.needle.type.tuple.b;

import org.jetbrains.annotations.NotNull;

public abstract class Pair<A, B> {
    // @formatter:off
    public abstract @NotNull A getFirst();
    public abstract @NotNull B getSecond();
    public abstract void setFirst  (final @NotNull A first);
    public abstract void setSecond (final @NotNull B second);
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "Pair{first=%s, second=%s}",
                this.getFirst(),
                this.getSecond()
        );
    }
}
