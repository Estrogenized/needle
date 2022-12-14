package moe.queery.needle.type.consumer.bi.g2p.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2IntBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Integer> {
    void acceptInt(final V left, final int right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Integer right) {
        this.acceptInt(left, right);
    }

    default @Contract(pure = true) Obj2IntBiConsumer<V> andThenInt(final @NotNull Obj2IntBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptInt(l, r);
            after.acceptInt(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Integer> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Integer> after) {
        return (l, r) -> {
            this.acceptInt(l, r);
            after.accept(l, r);
        };
    }
}
