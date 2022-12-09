package moe.queery.needle.iface.consumer.bi;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface CharBiConsumer extends BiConsumer<@NotNull Character, @NotNull Character> {
    void acceptChar(final char left, final char right);

    @Deprecated
    default @Override void accept(final @NotNull Character left, final @NotNull Character right) {
        this.acceptChar(left, right);
    }

    default @Contract(pure = true) CharBiConsumer andThenChar(final @NotNull CharBiConsumer after) {
        return (l, r) -> {
            this.acceptChar(l, r);
            after.acceptChar(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Character, @NotNull Character> andThen(final @NotNull BiConsumer<? super @NotNull Character, ? super @NotNull Character> after) {
        return (l, r) -> {
            this.acceptChar(l, r);
            after.accept(l, r);
        };
    }
}
