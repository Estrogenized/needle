package moe.queery.needle.type.consumer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface BoolConsumer extends Consumer<Boolean> {
    void acceptBool(final boolean value);

    @Deprecated
    default @Override void accept(final @NotNull Boolean value) {
        this.acceptBool(value);
    }

    default @Contract(pure = true) BoolConsumer andThenBool(final @NotNull BoolConsumer after) {
        return (value) -> {
            this.acceptBool(value);
            after.acceptBool(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Boolean> andThen(final @NotNull Consumer<? super @NotNull Boolean> after) {
        return (value) -> {
            this.acceptBool(value);
            after.accept(value);
        };
    }
}
