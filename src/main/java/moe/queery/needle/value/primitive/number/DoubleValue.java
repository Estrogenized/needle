package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import moe.queery.needle.Nameable;
import moe.queery.needle.type.consumer.bi.primitive.number.Double2DoubleBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DoubleValue implements IValue, Nameable {
    // @formatter:off
    private static final Double2DoubleBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final Double2DoubleBiConsumer change; // left: previous ; right: new
    private final @NotNull DoubleArrayList values;

    private final @NotNull String name;

    private double value;

    // @formatter:off
    DoubleValue() { this("Empty", .0D); }
    // @formatter:on

    public DoubleValue(final @NotNull String name, final double value,
                      final double @NotNull ... values) {
        this(name, value, null, values);
    }

    public DoubleValue(final @NotNull String name, final double value,
                      final @Nullable Double2DoubleBiConsumer change,
                      final double @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new DoubleArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(final double value) {
        this.change.acceptDouble(this.value, this.value = value);
    }

    public @NotNull DoubleArrayList getValues() {
        return this.values;
    }
}
