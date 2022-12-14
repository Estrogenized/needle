package moe.queery.needle.type.consumer.bi.primitive.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Long2LongBiConsumer extends BiConsumer<@NotNull Long, @NotNull Long> {
    void acceptLong(final long left, final long right);

    @Deprecated
    default @Override void accept(final @NotNull Long left, final @NotNull Long right) {
        this.acceptLong(left, right);
    }

    default @Contract(pure = true) Long2LongBiConsumer andThenLong(final @NotNull Long2LongBiConsumer after) {
        return (l, r) -> {
            this.acceptLong(l, r);
            after.acceptLong(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Long, @NotNull Long> andThen(final @NotNull BiConsumer<? super @NotNull Long, ? super @NotNull Long> after) {
        return (l, r) -> {
            this.acceptLong(l, r);
            after.accept(l, r);
        };
    }
}
