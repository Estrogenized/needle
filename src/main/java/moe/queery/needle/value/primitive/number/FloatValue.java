package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.floats.FloatArrayList;
import moe.queery.needle.Nameable;
import moe.queery.needle.type.consumer.bi.primitive.number.Float2FloatBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FloatValue implements IValue, Nameable {
    // @formatter:off
    private static final Float2FloatBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final Float2FloatBiConsumer change; // left: previous ; right: new
    private final @NotNull FloatArrayList values;

    private final @NotNull String name;

    private float value;

    // @formatter:off
    FloatValue() { this("Empty", .0F); }
    // @formatter:on

    public FloatValue(final @NotNull String name, final float value,
                      final float @NotNull ... values) {
        this(name, value, null, values);
    }

    public FloatValue(final @NotNull String name, final float value,
                      final @Nullable Float2FloatBiConsumer change,
                      final float @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new FloatArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(final float value) {
        this.change.acceptFloat(this.value, this.value = value);
    }

    public @NotNull FloatArrayList getValues() {
        return this.values;
    }
}
