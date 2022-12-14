package moe.queery.needle.type.tuple.h;

import org.jetbrains.annotations.NotNull;

public final class ImmutableOctet<A, B, C, D, E, F, G, H> extends Octet<@NotNull A, @NotNull B, @NotNull C, @NotNull D, @NotNull E, @NotNull F, @NotNull G, @NotNull H> {
    private static final UnsupportedOperationException COULD_NOT_SET = new UnsupportedOperationException("immutable pair-values aren't re-assignable!");
    private final @NotNull A first;
    private final @NotNull B second;
    private final @NotNull C third;
    private final @NotNull D fourth;
    private final @NotNull E fifth;
    private final @NotNull F sixth;
    private final @NotNull G seventh;
    private final @NotNull H eight;

    // @formatter:off
    @SuppressWarnings("all") ImmutableOctet() { this(null, null, null, null, null, null, null, null); }
    // @formatter:on

    public ImmutableOctet(final @NotNull A first, final @NotNull B second,
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
    public @Override void setFirst   (final @NotNull A first)   throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setSecond  (final @NotNull B second)  throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setThird   (final @NotNull C third)   throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setFourth  (final @NotNull D fourth)  throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setFifth   (final @NotNull E fifth)   throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setSixth   (final @NotNull F sixth)   throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setSeventh (final @NotNull G seventh) throws UnsupportedOperationException { throw COULD_NOT_SET; }
    public @Override void setEight   (final @NotNull H eight)   throws UnsupportedOperationException { throw COULD_NOT_SET; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "ImmutableOctet{first=%s, second=%s, third=%s, fourth=%s, fifth=%s, sixth=%s, seventh=%s, eight=%s}",
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
