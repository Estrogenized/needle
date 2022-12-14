package moe.queery.needle.type.consumer.bi.p2g;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Char2ObjBiConsumer<V> extends BiConsumer<@NotNull Character, @NotNull V> {
    void acceptChar(final char left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Character left, final @NotNull V right) {
        this.acceptChar(left, right);
    }

    default @Contract(pure = true) Char2ObjBiConsumer<V> andThenChar(final @NotNull Char2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptChar(l, r);
            after.acceptChar(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Character, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Character, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptChar(l, r);
            after.accept(l, r);
        };
    }
}
