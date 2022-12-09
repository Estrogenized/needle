package moe.queery.needle.value;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import moe.queery.needle.iface.INameable;
import org.jetbrains.annotations.NotNull;

public final class GenericValue<V> implements IValue, INameable {
    private final ObjectList<V> values;

    private final String name;

    private V value;

    public @SafeVarargs GenericValue(final String name, final V value, final V... values) {
        this.name = name;
        this.value = value;
        this.values = new ObjectArrayList<>(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(final V value) {
        this.value = value;
    }

    public ObjectList<V> getValues() {
        return this.values;
    }
}
