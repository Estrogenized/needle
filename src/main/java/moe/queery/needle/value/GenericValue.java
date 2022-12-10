package moe.queery.needle.value;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import moe.queery.needle.Sneaky;
import moe.queery.needle.Nameable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public final class GenericValue<V> implements IValue, Nameable {
    // @formatter:off
    private static final BiConsumer<Object, Object> EMPTY_CHANGE = (prevV, newV) -> {};
    // @formatter:on
    private final BiConsumer<V, V> change; // left: previous ; right: new
    private final @NotNull ObjectList<@NotNull V> values;
    private final @NotNull String name;
    private @NotNull V value;

    // @formatter:off
    @SuppressWarnings("all") GenericValue() { this("Empty", null); }
    // @formatter:on

    public @SafeVarargs GenericValue(final @NotNull String name, final @NotNull V value,
                                     final @NotNull V @NotNull ... values) {
        this(name, value, null, values);
    }

    public @SafeVarargs GenericValue(final @NotNull String name, final @NotNull V value,
                                     final @Nullable BiConsumer<@NotNull V, @NotNull V> change,
                                     final @NotNull V @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? Sneaky.cast(EMPTY_CHANGE) : change;
        this.values = new ObjectArrayList<>(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public @NotNull V getValue() {
        return this.value;
    }

    public void setValue(final @NotNull V value) {
        this.change.accept(this.value, this.value = value);
    }

    public @NotNull ObjectList<@NotNull V> getValues() {
        return this.values;
    }
}
