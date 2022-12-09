package moe.queery.needle.value.primitive.number.limited;

import de.liminal.base.value.primitive.number.FloatValue;

public final class LFloatValue extends FloatValue {
    private final float min, max;

    public LFloatValue(final String name, final float value, final float min, final float max, final float... values) {
        super(name, value, values);
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
