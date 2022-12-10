package moe.queery.needle.type.consumer.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface LongConsumer extends Consumer<Long> {
    void acceptLong(final long value);

    @Deprecated
    default @Override void accept(final @NotNull Long value) {
        this.acceptLong(value);
    }

    default @Contract(pure = true) LongConsumer andThenLong(final @NotNull LongConsumer after) {
        return (value) -> {
            this.acceptLong(value);
            after.acceptLong(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Long> andThen(final @NotNull Consumer<? super @NotNull Long> after) {
        return (value) -> {
            this.acceptLong(value);
            after.accept(value);
        };
    }
}
