package moe.queery.needle.value.primitive;

import it.unimi.dsi.fastutil.chars.CharArrayList;
import moe.queery.needle.iface.INameable;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;

public final class CharValue implements IValue, INameable {
    private final CharArrayList values;

    private final String name;

    private char value;

    public CharValue(final String name, final char value, final char... values) {
        this.name = name;
        this.value = value;
        this.values = new CharArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public char getValue() {
        return this.value;
    }

    public void setValue(final char value) {
        this.value = value;
    }

    public CharArrayList getValues() {
        return this.values;
    }
}
