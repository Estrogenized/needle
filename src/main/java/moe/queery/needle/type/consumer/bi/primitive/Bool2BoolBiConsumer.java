package moe.queery.needle.type.consumer.bi.primitive;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Bool2BoolBiConsumer extends BiConsumer<@NotNull Boolean, @NotNull Boolean> {
    void acceptBool(final boolean left, final boolean right);

    @Deprecated
    default @Override void accept(final @NotNull Boolean left, final @NotNull Boolean right) {
        this.acceptBool(left, right);
    }

    default @Contract(pure = true) Bool2BoolBiConsumer andThenBool(final @NotNull Bool2BoolBiConsumer after) {
        return (l, r) -> {
            this.acceptBool(l, r);
            after.acceptBool(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Boolean, @NotNull Boolean> andThen(final @NotNull BiConsumer<? super @NotNull Boolean, ? super @NotNull Boolean> after) {
        return (l, r) -> {
            this.acceptBool(l, r);
            after.accept(l, r);
        };
    }
}
