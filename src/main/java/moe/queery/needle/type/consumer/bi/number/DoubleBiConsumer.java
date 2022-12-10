package moe.queery.needle.type.consumer.bi.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface DoubleBiConsumer extends BiConsumer<@NotNull Double, @NotNull Double> {
    void acceptDouble(final double left, final double right);

    @Deprecated
    default @Override void accept(final @NotNull Double left, final @NotNull Double right) {
        this.acceptDouble(left, right);
    }

    default @Contract(pure = true) DoubleBiConsumer andThenDouble(final @NotNull DoubleBiConsumer after) {
        return (l, r) -> {
            this.acceptDouble(l, r);
            after.acceptDouble(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Double, @NotNull Double> andThen(final @NotNull BiConsumer<? super @NotNull Double, ? super @NotNull Double> after) {
        return (l, r) -> {
            this.acceptDouble(l, r);
            after.accept(l, r);
        };
    }
}
