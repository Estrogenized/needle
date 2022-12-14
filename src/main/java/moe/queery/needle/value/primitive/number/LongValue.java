package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import moe.queery.needle.Nameable;
import moe.queery.needle.type.consumer.bi.primitive.number.LongBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LongValue implements IValue, Nameable {
    // @formatter:off
    private static final LongBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final LongBiConsumer change; // left: previous ; right: new
    private final @NotNull LongArrayList values;

    private final @NotNull String name;

    private long value;

    // @formatter:off
    LongValue() { this("Empty", 0L); }
    // @formatter:on

    public LongValue(final @NotNull String name, final long value,
                     final long @NotNull ... values) {
        this(name, value, null, values);
    }

    public LongValue(final @NotNull String name, final long value,
                     final @Nullable LongBiConsumer change,
                     final long @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new LongArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(final long value) {
        this.change.acceptLong(this.value, this.value = value);
    }

    public @NotNull LongArrayList getValues() {
        return this.values;
    }
}
