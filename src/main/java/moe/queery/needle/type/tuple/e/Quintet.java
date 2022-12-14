package moe.queery.needle.type.tuple.e;

import org.jetbrains.annotations.NotNull;

public abstract class Quintet<A, B, C, D, E> {
    // @formatter:off
    public abstract @NotNull A getFirst();
    public abstract @NotNull B getSecond();
    public abstract @NotNull C getThird();
    public abstract @NotNull D getFourth();
    public abstract @NotNull E getFifth();
    public abstract void setFirst  (final @NotNull A first);
    public abstract void setSecond (final @NotNull B second);
    public abstract void setThird  (final @NotNull C third);
    public abstract void setFourth (final @NotNull D third);
    public abstract void setFifth  (final @NotNull E fifth);
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "Quintet{first=%s, second=%s, third=%s, fourth=%s, fifth=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth(),
                this.getFifth()
        );
    }
}
