package moe.queery.needle.value.primitive.number.limited;

import moe.queery.needle.value.primitive.number.LongValue;

public final class LLongValue extends LongValue {
    private final long min, max;

    public LLongValue(final String name, final long value, final long min, final long max, final long... values) {
        super(name, value, values);
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
