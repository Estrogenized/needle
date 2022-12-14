package moe.queery.needle.value.primitive.number.limited;

import moe.queery.needle.type.consumer.bi.primitive.number.DoubleBiConsumer;
import moe.queery.needle.value.primitive.number.DoubleValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LDoubleValue extends DoubleValue {
    private final double min, max;

    // @formatter:off
    LDoubleValue() { this("Empty", .0D, .0D, .0D); }
    // @formatter:on


    public LDoubleValue(final @NotNull String name, final double value,
                        final double min, final double max,
                        final double @NotNull ... values) {
        this(name, value, min, max, null, values);
    }

    public LDoubleValue(final @NotNull String name, final double value,
                        final double min, final double max,
                        final @Nullable DoubleBiConsumer change,
                        final double @NotNull ... values) {
        super(name, value, change, values);
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }
}
