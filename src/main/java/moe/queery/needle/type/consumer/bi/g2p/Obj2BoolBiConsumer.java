package moe.queery.needle.type.consumer.bi.g2p;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2BoolBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Boolean> {
    void acceptBool(final V left, final boolean right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Boolean right) {
        this.acceptBool(left, right);
    }

    default @Contract(pure = true) Obj2BoolBiConsumer<V> andThenBool(final @NotNull Obj2BoolBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptBool(l, r);
            after.acceptBool(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Boolean> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Boolean> after) {
        return (l, r) -> {
            this.acceptBool(l, r);
            after.accept(l, r);
        };
    }
}
