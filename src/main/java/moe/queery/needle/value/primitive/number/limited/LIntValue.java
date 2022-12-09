package moe.queery.needle.value.primitive.number.limited;

import moe.queery.needle.value.primitive.number.IntValue;

public final class LIntValue extends IntValue {
    private final int min, max;

    public LIntValue(final String name, final int value, final int min, final int max, final int... values) {
        super(name, value, values);
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
