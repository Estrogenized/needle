package moe.queery.needle.value.primitive.number.limited;

import moe.queery.needle.value.primitive.number.ShortValue;

public final class LShortValue extends ShortValue {
    private final short min, max;

    public LShortValue(final String name, final short value, final short min, final short max, final short... values) {
        super(name, value, values);
        this.min = min;
        this.max = max;
    }

    public short getMin() {
        return this.min;
    }

    public short getMax() {
        return this.max;
    }
}
