package moe.queery.needle.type.consumer.bi.p2g.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Double2ObjBiConsumer<V> extends BiConsumer<@NotNull Double, @NotNull V> {
    void acceptDouble(final double left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Double left, final @NotNull V right) {
        this.acceptDouble(left, right);
    }

    default @Contract(pure = true) Double2ObjBiConsumer<V> andThenDouble(final @NotNull Double2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptDouble(l, r);
            after.acceptDouble(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Double, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Double, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptDouble(l, r);
            after.accept(l, r);
        };
    }
}
