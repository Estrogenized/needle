package moe.queery.needle.type.consumer.bi.p2g.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Long2ObjBiConsumer<V> extends BiConsumer<@NotNull Long, @NotNull V> {
    void acceptLong(final long left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Long left, final @NotNull V right) {
        this.acceptLong(left, right);
    }

    default @Contract(pure = true) Long2ObjBiConsumer<V> andThenLong(final @NotNull Long2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptLong(l, r);
            after.acceptLong(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Long, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Long, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptLong(l, r);
            after.accept(l, r);
        };
    }
}
