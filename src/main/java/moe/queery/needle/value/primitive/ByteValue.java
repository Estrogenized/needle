package moe.queery.needle.value.primitive;

import it.unimi.dsi.fastutil.bytes.ByteArrayList;
import moe.queery.needle.iface.INameable;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;

public final class ByteValue implements IValue, INameable {
    private final ByteArrayList values;

    private final String name;

    private byte value;

    public ByteValue(final String name, final byte value, final byte... values) {
        this.name = name;
        this.value = value;
        this.values = new ByteArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public byte getValue() {
        return this.value;
    }

    public void setValue(final byte value) {
        this.value = value;
    }

    public ByteArrayList getValues() {
        return this.values;
    }
}
