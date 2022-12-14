package moe.queery.needle.type.consumer.bi.primitive.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface ShortBiConsumer extends BiConsumer<@NotNull Short, @NotNull Short> {
    void acceptShort(final short left, final short right);

    @Deprecated
    default @Override void accept(final @NotNull Short left, final @NotNull Short right) {
        this.acceptShort(left, right);
    }

    default @Contract(pure = true) ShortBiConsumer andThenShort(final @NotNull ShortBiConsumer after) {
        return (l, r) -> {
            this.acceptShort(l, r);
            after.acceptShort(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Short, @NotNull Short> andThen(final @NotNull BiConsumer<? super @NotNull Short, ? super @NotNull Short> after) {
        return (l, r) -> {
            this.acceptShort(l, r);
            after.accept(l, r);
        };
    }
}
