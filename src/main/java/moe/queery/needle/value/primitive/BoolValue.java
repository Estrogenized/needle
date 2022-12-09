package moe.queery.needle.value.primitive;

import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import moe.queery.needle.iface.Nameable;
import moe.queery.needle.iface.consumer.bi.BoolBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BoolValue implements IValue, Nameable {
    // @formatter:off
    private static final BoolBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final BoolBiConsumer change; // left: previous ; right: new
    private final @NotNull BooleanArrayList values;

    private final @NotNull String name;

    private boolean value;

    // @formatter:off
    BoolValue() { this("Empty", false); }
    // @formatter:on

    public BoolValue(final @NotNull String name, final boolean value,
                     final boolean @NotNull ... values) {
        this(name, value, null, values);
    }

    public BoolValue(final @NotNull String name, final boolean value,
                     final @Nullable BoolBiConsumer change,
                     final boolean @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new BooleanArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(final boolean value) {
        this.change.accept(this.value, this.value = value);
    }

    public @NotNull BooleanArrayList getValues() {
        return this.values;
    }
}
