package moe.queery.needle.iface.consumer.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface IntConsumer extends Consumer<Integer> {
    void acceptInt(final int value);

    @Deprecated
    default @Override void accept(final @NotNull Integer value) {
        this.acceptInt(value);
    }

    default @Contract(pure = true) IntConsumer andThenInt(final @NotNull IntConsumer after) {
        return (value) -> {
            this.acceptInt(value);
            after.acceptInt(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Integer> andThen(final @NotNull Consumer<? super @NotNull Integer> after) {
        return (value) -> {
            this.acceptInt(value);
            after.accept(value);
        };
    }
}
