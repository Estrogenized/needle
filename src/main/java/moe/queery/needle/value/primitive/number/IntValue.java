package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import moe.queery.needle.Nameable;
import moe.queery.needle.type.consumer.bi.primitive.number.IntBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IntValue implements IValue, Nameable {
    // @formatter:off
    private static final IntBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final IntBiConsumer change; // left: previous ; right: new
    private final @NotNull IntArrayList values;

    private final @NotNull String name;

    private int value;

    // @formatter:off
    IntValue() { this("Empty", 0); }
    // @formatter:on

    public IntValue(final @NotNull String name, final int value,
                    final int @NotNull ... values) {
        this(name, value, null, values);
    }

    public IntValue(final @NotNull String name, final int value,
                    final @Nullable IntBiConsumer change,
                    final int @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new IntArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.change.acceptInt(this.value, this.value = value);
    }

    public @NotNull IntArrayList getValues() {
        return this.values;
    }
}
