package moe.queery.needle.value.primitive.number;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import moe.queery.needle.iface.INameable;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;

public class LongValue implements IValue, INameable {
    private final LongArrayList values;

    private final String name;

    private long value;

    public LongValue(final String name, final long value, final long... values) {
        this.name = name;
        this.value = value;
        this.values = new LongArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(final long value) {
        this.value = value;
    }

    public LongArrayList getValues() {
        return this.values;
    }
}
