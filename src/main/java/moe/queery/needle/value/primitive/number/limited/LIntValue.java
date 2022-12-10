package moe.queery.needle.value.primitive.number.limited;

import moe.queery.needle.type.consumer.bi.number.IntBiConsumer;
import moe.queery.needle.value.primitive.number.IntValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LIntValue extends IntValue {
    private final int min, max;

    // @formatter:off
    LIntValue() { this("Empty", 0, 0, 0); }
    // @formatter:on

    public LIntValue(final @NotNull String name, final int value,
                     final int min, final int max,
                     final int @NotNull ... values) {
        this(name, value, min, max, null, values);
    }

    public LIntValue(final @NotNull String name, final int value,
                     final int min, final int max,
                     final @Nullable IntBiConsumer change,
                     final int @NotNull ... values) {
        super(name, value, change, values);
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }
}
