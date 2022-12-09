package moe.queery.needle.iface.consumer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface CharConsumer extends Consumer<Character> {
    void acceptChar(final char value);

    @Deprecated
    default @Override void accept(final @NotNull Character value) {
        this.acceptChar(value);
    }

    default @Contract(pure = true) CharConsumer andThenChar(final @NotNull CharConsumer after) {
        return (value) -> {
            this.acceptChar(value);
            after.acceptChar(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Character> andThen(final @NotNull Consumer<? super @NotNull Character> after) {
        return (value) -> {
            this.acceptChar(value);
            after.accept(value);
        };
    }
}
