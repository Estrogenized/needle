package moe.queery.needle.value.primitive.number.limited;

import de.liminal.base.value.primitive.number.DoubleValue;

public final class LDoubleValue extends DoubleValue {
    private final double min, max;

    public LDoubleValue(final String name, final double value, final double min, final double max, final double... values) {
        super(name, value, values);
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
