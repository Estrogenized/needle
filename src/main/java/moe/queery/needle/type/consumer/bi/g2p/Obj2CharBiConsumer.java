package moe.queery.needle.type.consumer.bi.g2p;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2CharBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Character> {
    void acceptChar(final V left, final char right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Character right) {
        this.acceptChar(left, right);
    }

    default @Contract(pure = true) Obj2CharBiConsumer<V> andThenChar(final @NotNull Obj2CharBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptChar(l, r);
            after.acceptChar(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Character> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Character> after) {
        return (l, r) -> {
            this.acceptChar(l, r);
            after.accept(l, r);
        };
    }
}
