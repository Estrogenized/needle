package moe.queery.needle.value.primitive;

import it.unimi.dsi.fastutil.chars.CharArrayList;
import moe.queery.needle.iface.Nameable;
import moe.queery.needle.iface.consumer.bi.CharBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CharValue implements IValue, Nameable {
    // @formatter:off
    private static final CharBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final CharBiConsumer change; // left: previous ; right: new
    private final @NotNull CharArrayList values;

    private final @NotNull String name;

    private char value;

    // @formatter:off
    CharValue() { this("Empty", ' '); }
    // @formatter:on

    public CharValue(final @NotNull String name, final char value,
                     final char @NotNull ... values) {
        this(name, value, null, values);
    }

    public CharValue(final @NotNull String name, final char value,
                     final @Nullable CharBiConsumer change,
                     final char @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new CharArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public char getValue() {
        return this.value;
    }

    public void setValue(final char value) {
        this.change.acceptChar(this.value, this.value = value);
    }

    public @NotNull CharArrayList getValues() {
        return this.values;
    }
}
