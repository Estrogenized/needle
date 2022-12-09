package moe.queery.needle.value.primitive.number;

import de.liminal.base.registry.interfaces.INameable;
import de.liminal.base.value.IValue;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.jetbrains.annotations.NotNull;

public class IntValue implements IValue, INameable {
    private final IntArrayList values;

    private final String name;

    private int value;

    public IntValue(final String name, final int value, final int... values) {
        this.name = name;
        this.value = value;
        this.values = new IntArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public IntArrayList getValues() {
        return this.values;
    }
}
