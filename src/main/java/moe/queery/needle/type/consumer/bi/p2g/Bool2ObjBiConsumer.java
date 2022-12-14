package moe.queery.needle.type.consumer.bi.p2g;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Bool2ObjBiConsumer<V> extends BiConsumer<@NotNull Boolean, @NotNull V> {
    void acceptBool(final boolean left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Boolean left, final @NotNull V right) {
        this.acceptBool(left, right);
    }

    default @Contract(pure = true) Bool2ObjBiConsumer<V> andThenBool(final @NotNull Bool2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptBool(l, r);
            after.acceptBool(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Boolean, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Boolean, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptBool(l, r);
            after.accept(l, r);
        };
    }
}
