package moe.queery.needle.iface.consumer.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface DoubleConsumer extends Consumer<Double> {
    void acceptDouble(final double value);

    @Deprecated
    default @Override void accept(final @NotNull Double value) {
        this.acceptDouble(value);
    }

    default @Contract(pure = true) DoubleConsumer andThenDouble(final @NotNull DoubleConsumer after) {
        return (value) -> {
            this.acceptDouble(value);
            after.acceptDouble(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Double> andThen(final @NotNull Consumer<? super @NotNull Double> after) {
        return (value) -> {
            this.acceptDouble(value);
            after.accept(value);
        };
    }
}
