package moe.queery.needle.type.consumer.bi.primitive.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Int2IntBiConsumer extends BiConsumer<@NotNull Integer, @NotNull Integer> {
    void acceptInt(final int left, final int right);

    @Deprecated
    default @Override void accept(final @NotNull Integer left, final @NotNull Integer right) {
        this.acceptInt(left, right);
    }

    default @Contract(pure = true) Int2IntBiConsumer andThenInt(final @NotNull Int2IntBiConsumer after) {
        return (l, r) -> {
            this.acceptInt(l, r);
            after.acceptInt(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Integer, @NotNull Integer> andThen(final @NotNull BiConsumer<? super @NotNull Integer, ? super @NotNull Integer> after) {
        return (l, r) -> {
            this.acceptInt(l, r);
            after.accept(l, r);
        };
    }
}
