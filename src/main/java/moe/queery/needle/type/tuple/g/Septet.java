package moe.queery.needle.type.tuple.g;

import org.jetbrains.annotations.NotNull;

public abstract class Septet<A, B, C, D, E, F, G> {
    // @formatter:off
    public abstract @NotNull A getFirst();
    public abstract @NotNull B getSecond();
    public abstract @NotNull C getThird();
    public abstract @NotNull D getFourth();
    public abstract @NotNull E getFifth();
    public abstract @NotNull F getSixth();
    public abstract @NotNull G getSeventh();
    public abstract void setFirst   (final @NotNull A first);
    public abstract void setSecond  (final @NotNull B second);
    public abstract void setThird   (final @NotNull C third);
    public abstract void setFourth  (final @NotNull D third);
    public abstract void setFifth   (final @NotNull E fifth);
    public abstract void setSixth   (final @NotNull F sixth);
    public abstract void setSeventh (final @NotNull G sixth);
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "Septet{first=%s, second=%s, third=%s, fourth=%s, fifth=%s, sixth=%s, seventh=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth(),
                this.getFifth(),
                this.getSixth(),
                this.getSeventh()
        );
    }
}
