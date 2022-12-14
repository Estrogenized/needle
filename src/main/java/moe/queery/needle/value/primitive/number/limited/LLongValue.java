package moe.queery.needle.value.primitive.number.limited;

import moe.queery.needle.type.consumer.bi.primitive.number.Long2LongBiConsumer;
import moe.queery.needle.value.primitive.number.LongValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LLongValue extends LongValue {
    private final long min, max;

    // @formatter:off
    LLongValue() { this("Empty", 0L, 0L, 0L); }
    // @formatter:on

    public LLongValue(final @NotNull String name, final long value,
                      final long min, final long max,
                      final long @NotNull ... values) {
        this(name, value, min, max, null, values);
    }

    public LLongValue(final @NotNull String name, final long value,
                      final long min, final long max,
                      final @Nullable Long2LongBiConsumer change,
                      final long @NotNull ... values) {
        super(name, value, change, values);
        this.min = min;
        this.max = max;
    }

    public long getMin() {
        return this.min;
    }

    public long getMax() {
        return this.max;
    }
}
