package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.shorts.ShortArrayList;
import moe.queery.needle.Nameable;
import moe.queery.needle.type.consumer.bi.primitive.number.ShortBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ShortValue implements IValue, Nameable {
    // @formatter:off
    private static final ShortBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final ShortBiConsumer change; // left: previous ; right: new
    private final @NotNull ShortArrayList values;

    private final @NotNull String name;

    private short value;

    // @formatter:off
    ShortValue() { this("Empty", (short) 0); }
    // @formatter:on

    public ShortValue(final @NotNull String name, final short value,
                      final short @NotNull ... values) {
        this(name, value, null, values);
    }

    public ShortValue(final @NotNull String name, final short value,
                      final @Nullable ShortBiConsumer change,
                      final short @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new ShortArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public short getValue() {
        return this.value;
    }

    public void setValue(final short value) {
        this.change.acceptShort(this.value, this.value = value);
    }

    public @NotNull ShortArrayList getValues() {
        return this.values;
    }
}
