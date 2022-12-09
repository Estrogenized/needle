package moe.queery.needle.registry.list;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class ListRegistry<V> {
    // @formatter:off
    private static final UnsupportedOperationException
            UNLOCK_REGISTER    = new UnsupportedOperationException("unlock, before registering values!"),
            UNLOCK_UNREGISTER  = new UnsupportedOperationException("unlock, before unregistering values!");
    // @formatter:on
    public boolean initialized = false;
    private ObjectList<V> values, preLockedValues;
    private boolean locked = false;

    public ListRegistry(final int capacity) {
        this.values = new ObjectArrayList<>();
    }

    public final void lock() {
        if (!this.locked) {
            this.locked = true;
            this.values = ObjectLists.unmodifiable(this.preLockedValues = this.values);
        }
    }

    public final void unlock() {
        if (this.locked) {
            this.values = this.preLockedValues;
            this.locked = false;
        }
    }

    @SafeVarargs
    public final void register(final @NotNull V... values) {
        if (this.locked) throw UNLOCK_REGISTER;
        if (values.length > 1) this.values.addAll(Arrays.asList(values));
        else this.values.add(values[0]);
    }

    @SafeVarargs
    public final void unregister(final @NotNull V... values) {
        if (this.locked) throw UNLOCK_UNREGISTER;
        if (values.length > 1) this.values.removeAll(Arrays.asList(values));
        else this.values.remove(values[0]);
    }

    @SuppressWarnings("unchecked") // it's checked ffs ._.
    public final <T extends V> @Nullable T getValueByClass(final Class<? extends V> clazz) {
        for (final V value : this.getValues()) {
            if (!value.getClass().equals(clazz)) continue;
            return (T) value;
        }
        return null;
    }

    public final ObjectList<V> getValues() {
        return values;
    }
}
