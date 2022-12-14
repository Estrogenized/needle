package moe.queery.needle.type.tuple.j;

import org.jetbrains.annotations.NotNull;

public final class MutableDecade<A, B, C, D, E, F, G, H, I, J> extends Decade<@NotNull A, @NotNull B, @NotNull C, @NotNull D, @NotNull E, @NotNull F, @NotNull G, @NotNull H, @NotNull I, @NotNull J> {
    private @NotNull A first;
    private @NotNull B second;
    private @NotNull C third;
    private @NotNull D fourth;
    private @NotNull E fifth;
    private @NotNull F sixth;
    private @NotNull G seventh;
    private @NotNull H eight;
    private @NotNull I ninth;
    private @NotNull J tenth;

    // @formatter:off
    @SuppressWarnings("all") MutableDecade() { this(null, null, null, null, null, null, null, null, null, null); }
    // @formatter:on

    public MutableDecade(final @NotNull A first, final @NotNull B second,
                         final @NotNull C third, final @NotNull D fourth,
                         final @NotNull E fifth, final @NotNull F sixth,
                         final @NotNull G seventh, final @NotNull H eight,
                         final @NotNull I ninth, final @NotNull J tenth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eight = eight;
        this.ninth = ninth;
        this.tenth = tenth;
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
    public @Override @NotNull I getNinth()   { return this.ninth; }
    public @Override @NotNull J getTenth()   { return this.tenth; }
    public @Override void setFirst   (final @NotNull A first)   { this.first = first; }
    public @Override void setSecond  (final @NotNull B second)  { this.second = second; }
    public @Override void setThird   (final @NotNull C third)   { this.third = third; }
    public @Override void setFourth  (final @NotNull D fourth)  { this.fourth = fourth; }
    public @Override void setFifth   (final @NotNull E fifth)   { this.fifth = fifth; }
    public @Override void setSixth   (final @NotNull F sixth)   { this.sixth = sixth; }
    public @Override void setSeventh (final @NotNull G seventh) { this.seventh = seventh; }
    public @Override void setEight   (final @NotNull H eight)   { this.eight = eight; }
    public @Override void setNinth   (final @NotNull I ninth)   { this.ninth = ninth; }
    public @Override void setTenth   (final @NotNull J tenth)   { this.tenth = tenth; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutableDecade{first=%s, second=%s, third=%s, fourth=%s, fifth=%s, sixth=%s, seventh=%s, eight=%s, ninth=%s, tenth=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth(),
                this.getFifth(),
                this.getSixth(),
                this.getSeventh(),
                this.getEight(),
                this.getNinth(),
                this.getTenth()
        );
    }
}
