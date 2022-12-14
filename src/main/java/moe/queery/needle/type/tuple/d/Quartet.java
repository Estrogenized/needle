package moe.queery.needle.type.tuple.d;

import org.jetbrains.annotations.NotNull;

public abstract class Quartet<A, B, C, D> {
    // @formatter:off
    public abstract @NotNull A getFirst();
    public abstract @NotNull B getSecond();
    public abstract @NotNull C getThird();
    public abstract @NotNull D getFourth();
    public abstract void setFirst  (final @NotNull A first);
    public abstract void setSecond (final @NotNull B second);
    public abstract void setThird  (final @NotNull C third);
    public abstract void setFourth (final @NotNull D fourth);
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "Quartet{first=%s, second=%s, third=%s, fourth=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth()
        );
    }
}
