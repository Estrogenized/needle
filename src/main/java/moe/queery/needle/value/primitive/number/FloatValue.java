package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.floats.FloatArrayList;
import moe.queery.needle.iface.INameable;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;

public class FloatValue implements IValue, INameable {
    private final FloatArrayList values;

    private final String name;

    private float value;

    public FloatValue(final String name, final float value, final float... values) {
        this.name = name;
        this.value = value;
        this.values = new FloatArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(final float value) {
        this.value = value;
    }

    public FloatArrayList getValues() {
        return this.values;
    }
}
