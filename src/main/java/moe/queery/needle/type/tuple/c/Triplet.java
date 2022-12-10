package moe.queery.needle.type.tuple.c;

import org.jetbrains.annotations.NotNull;

public abstract class Triplet<A, B, C> {
    public abstract @NotNull A getFirst();
    public abstract void setFirst(final @NotNull A first);
    public abstract @NotNull B getSecond();
    public abstract void setSecond(final @NotNull B second);
    public abstract @NotNull C getThird();
    public abstract void setThird(final @NotNull C third);

    public @Override String toString() {
        return String.format("Triplet{first=%s, second=%s, third=%s}", this.getFirst(), this.getSecond(), this.getThird());
    }
}
