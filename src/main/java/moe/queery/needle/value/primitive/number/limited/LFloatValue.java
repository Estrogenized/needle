package moe.queery.needle.value.primitive.number.limited;

import moe.queery.needle.type.consumer.bi.primitive.number.FloatBiConsumer;
import moe.queery.needle.value.primitive.number.FloatValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LFloatValue extends FloatValue {
    private final float min, max;

    // @formatter:off
    LFloatValue() { this("Empty", .0F, .0F, .0F); }
    // @formatter:on

    public LFloatValue(final @NotNull String name, final float value,
                       final float min, final float max,
                       final float @NotNull ... values) {
        this(name, value, min, max, null, values);
    }

    public LFloatValue(final @NotNull String name, final float value,
                       final float min, final float max,
                       final @Nullable FloatBiConsumer change,
                       final float @NotNull ... values) {
        super(name, value, change, values);
        this.min = min;
        this.max = max;
    }

    public float getMin() {
        return this.min;
    }

    public float getMax() {
        return this.max;
    }
}
