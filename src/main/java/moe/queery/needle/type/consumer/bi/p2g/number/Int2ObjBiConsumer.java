package moe.queery.needle.type.consumer.bi.p2g.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Int2ObjBiConsumer<V> extends BiConsumer<@NotNull Integer, @NotNull V> {
    void acceptInt(final int left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Integer left, final @NotNull V right) {
        this.acceptInt(left, right);
    }

    default @Contract(pure = true) Int2ObjBiConsumer<V> andThenInt(final @NotNull Int2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptInt(l, r);
            after.acceptInt(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Integer, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Integer, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptInt(l, r);
            after.accept(l, r);
        };
    }
}
