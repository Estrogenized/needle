package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import moe.queery.needle.iface.INameable;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;

public class DoubleValue implements IValue, INameable {
    private final DoubleArrayList values;

    private final String name;

    private double value;

    public DoubleValue(final String name, final double value, final double... values) {
        this.name = name;
        this.value = value;
        this.values = new DoubleArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public DoubleArrayList getValues() {
        return this.values;
    }
}
