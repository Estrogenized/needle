package moe.queery.needle.value.primitive;

import de.liminal.base.registry.interfaces.INameable;
import de.liminal.base.value.IValue;
import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import org.jetbrains.annotations.NotNull;

public final class BoolValue implements IValue, INameable {
    private final BooleanArrayList values;

    private final String name;

    private boolean value;

    public BoolValue(final String name, final boolean value, final boolean... values) {
        this.name = name;
        this.value = value;
        this.values = new BooleanArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(final boolean value) {
        this.value = value;
    }

    public BooleanArrayList getValues() {
        return this.values;
    }
}
