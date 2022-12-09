package moe.queery.needle.value.primitive.number;

import de.liminal.base.registry.interfaces.INameable;
import de.liminal.base.value.IValue;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
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
