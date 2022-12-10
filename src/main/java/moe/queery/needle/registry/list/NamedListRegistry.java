package moe.queery.needle.registry.list;

import moe.queery.needle.Nameable;
import org.jetbrains.annotations.Nullable;

public class NamedListRegistry<V extends Nameable> extends ListRegistry<V> {
    public NamedListRegistry() {
        super();
    }

    @SuppressWarnings("unchecked") // it's checked ffs ._.
    public <T extends V> @Nullable T getValueByName(final String name, final boolean ignoreCase) {
        for (final V value : this.getValues()) {
            if (!(ignoreCase ? value.getName().equalsIgnoreCase(name) : value.getName().equals(name))) continue;
            return (T) value;
        }
        return null;
    }
}
