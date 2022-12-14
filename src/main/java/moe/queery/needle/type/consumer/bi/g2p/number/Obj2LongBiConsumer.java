package moe.queery.needle.type.consumer.bi.g2p.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2LongBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Long> {
    void acceptLong(final V left, final long right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Long right) {
        this.acceptLong(left, right);
    }

    default @Contract(pure = true) Obj2LongBiConsumer<V> andThenLong(final @NotNull Obj2LongBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptLong(l, r);
            after.acceptLong(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Long> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Long> after) {
        return (l, r) -> {
            this.acceptLong(l, r);
            after.accept(l, r);
        };
    }
}
