package moe.queery.needle.type.tuple.f;

import org.jetbrains.annotations.NotNull;

public final class MutableSextet<A, B, C, D, E, F> extends Sextet<@NotNull A, @NotNull B, @NotNull C, @NotNull D, @NotNull E, @NotNull F> {
    private @NotNull A first;
    private @NotNull B second;
    private @NotNull C third;
    private @NotNull D fourth;
    private @NotNull E fifth;
    private @NotNull F sixth;

    // @formatter:off
    @SuppressWarnings("all") MutableSextet() { this(null, null, null, null, null, null); }
    // @formatter:on

    public MutableSextet(final @NotNull A first, final @NotNull B second,
                         final @NotNull C third, final @NotNull D fourth,
                         final @NotNull E fifth, final @NotNull F sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    // @formatter:off
    public @Override @NotNull A getFirst()  { return this.first; }
    public @Override @NotNull B getSecond() { return this.second; }
    public @Override @NotNull C getThird()  { return this.third; }
    public @Override @NotNull D getFourth() { return this.fourth; }
    public @Override @NotNull E getFifth()  { return this.fifth; }
    public @Override @NotNull F getSixth()  { return this.sixth; }
    public @Override void setFirst  (final @NotNull A first)  { this.first = first; }
    public @Override void setSecond (final @NotNull B second) { this.second = second; }
    public @Override void setThird  (final @NotNull C third)  { this.third = third; }
    public @Override void setFourth (final @NotNull D fourth) { this.fourth = fourth; }
    public @Override void setFifth  (final @NotNull E fifth)  { this.fifth = fifth; }
    public @Override void setSixth  (final @NotNull F sixth)  { this.sixth = sixth; }
    // @formatter:on

    public @Override String toString() {
        return String.format(
                "MutableSextet{first=%s, second=%s, third=%s, fourth=%s, fifth=%s, sixth=%s}",
                this.getFirst(),
                this.getSecond(),
                this.getThird(),
                this.getFourth(),
                this.getFifth(),
                this.getSixth()
        );
    }
}
