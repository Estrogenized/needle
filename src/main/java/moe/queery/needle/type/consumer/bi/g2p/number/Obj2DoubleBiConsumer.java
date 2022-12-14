package moe.queery.needle.type.consumer.bi.g2p.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2DoubleBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Double> {
    void acceptDouble(final V left, final double right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Double right) {
        this.acceptDouble(left, right);
    }

    default @Contract(pure = true) Obj2DoubleBiConsumer<V> andThenDouble(final @NotNull Obj2DoubleBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptDouble(l, r);
            after.acceptDouble(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Double> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Double> after) {
        return (l, r) -> {
            this.acceptDouble(l, r);
            after.accept(l, r);
        };
    }
}
