package moe.queery.needle.type.tuple.g;

import org.jetbrains.annotations.NotNull;

public final class MutableSeptet<A, B, C, D, E, F, G> extends Septet<@NotNull A, @NotNull B, @NotNull C, @NotNull D, @NotNull E, @NotNull F, @NotNull G> {
    private @NotNull A first;
    private @NotNull B second;
    private @NotNull C third;
    private @NotNull D fourth;
    private @NotNull E fifth;
    private @NotNull F sixth;
    private @NotNull G seventh;

    // @formatter:off
    @SuppressWarnings("all") MutableSeptet() { this(null, null, null, null, null, null, null); }
    // @formatter:on

    public MutableSeptet(final @NotNull A first, final @NotNull B second,
                         final @NotNull C third, final @NotNull D fourth,
                         final @NotNull E fifth, final @NotNull F sixth, final @NotNull G seventh) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()   { return this.first; }
    public @Override @NotNull B getSecond()  { return this.second; }
    public @Override @NotNull C getThird()   { return this.third; }
    public @Override @NotNull D getFourth()  { return this.fourth; }
    public @Override @NotNull E getFifth()   { return this.fifth; }
    public @Override @NotNull F getSixth()   { return this.sixth; }
    public @Override @NotNull G getSeventh() { return this.seventh; }
    public @Override void setFirst   (final @NotNull A first)   { this.first = first; }
    public @Override void setSecond  (final @NotNull B second)  { this.second = second; }
    public @Override void setThird   (final @NotNull C third)   { this.third = third; }
    public @Override void setFourth  (final @NotNull D fourth)  { this.fourth = fourth; }
    public @Override void setFifth   (final @NotNull E fifth)   { this.fifth = fifth; }
    public @Override void setSixth   (final @NotNull F sixth)   { this.sixth = sixth; }
    public @Override void setSeventh (final @NotNull G seventh) { this.seventh = seventh; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutableSeptet{first=%s, second=%s, third=%s, fourth=%s, fifth=%s, sixth=%s, seventh=%s}",
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
