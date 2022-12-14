package moe.queery.needle.type.tuple.h;

import org.jetbrains.annotations.NotNull;

public final class MutableOctet<A, B, C, D, E, F, G, H> extends Octet<@NotNull A, @NotNull B, @NotNull C, @NotNull D, @NotNull E, @NotNull F, @NotNull G, @NotNull H> {
    private @NotNull A first;
    private @NotNull B second;
    private @NotNull C third;
    private @NotNull D fourth;
    private @NotNull E fifth;
    private @NotNull F sixth;
    private @NotNull G seventh;
    private @NotNull H eight;

    // @formatter:off
    @SuppressWarnings("all") MutableOctet() { this(null, null, null, null, null, null, null, null); }
    // @formatter:on

    public MutableOctet(final @NotNull A first, final @NotNull B second,
                        final @NotNull C third, final @NotNull D fourth,
                        final @NotNull E fifth, final @NotNull F sixth,
                        final @NotNull G seventh, final @NotNull H eight) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eight = eight;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()   { return this.first; }
    public @Override @NotNull B getSecond()  { return this.second; }
    public @Override @NotNull C getThird()   { return this.third; }
    public @Override @NotNull D getFourth()  { return this.fourth; }
    public @Override @NotNull E getFifth()   { return this.fifth; }
    public @Override @NotNull F getSixth()   { return this.sixth; }
    public @Override @NotNull G getSeventh() { return this.seventh; }
    public @Override @NotNull H getEight()   { return this.eight; }
    public @Override void setFirst   (final @NotNull A first)   { this.first = first; }
    public @Override void setSecond  (final @NotNull B second)  { this.second = second; }
    public @Override void setThird   (final @NotNull C third)   { this.third = third; }
    public @Override void setFourth  (final @NotNull D fourth)  { this.fourth = fourth; }
    public @Override void setFifth   (final @NotNull E fifth)   { this.fifth = fifth; }
    public @Override void setSixth   (final @NotNull F sixth)   { this.sixth = sixth; }
    public @Override void setSeventh (final @NotNull G seventh) { this.seventh = seventh; }
    public @Override void setEight   (final @NotNull H eight)   { this.eight = eight; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutableOctet{first=%s, second=%s, third=%s, fourth=%s, fifth=%s, sixth=%s, seventh=%s, eight=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth(),
                this.getFifth(),
                this.getSixth(),
                this.getSeventh(),
                this.getEight()
        );
    }
}
