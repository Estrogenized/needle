package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.shorts.ShortArrayList;
import moe.queery.needle.iface.INameable;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;

public class ShortValue implements IValue, INameable {
    private final ShortArrayList values;

    private final String name;

    private short value;

    public ShortValue(final String name, final short value, final short... values) {
        this.name = name;
        this.value = value;
        this.values = new ShortArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public short getValue() {
        return this.value;
    }

    public void setValue(final short value) {
        this.value = value;
    }

    public ShortArrayList getValues() {
        return this.values;
    }
}
