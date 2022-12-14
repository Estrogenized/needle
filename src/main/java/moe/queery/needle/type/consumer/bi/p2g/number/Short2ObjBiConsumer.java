package moe.queery.needle.type.consumer.bi.p2g.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Short2ObjBiConsumer<V> extends BiConsumer<@NotNull Short, @NotNull V> {
    void acceptShort(final short left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Short left, final @NotNull V right) {
        this.acceptShort(left, right);
    }

    default @Contract(pure = true) Short2ObjBiConsumer<V> andThenShort(final @NotNull Short2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptShort(l, r);
            after.acceptShort(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Short, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Short, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptShort(l, r);
            after.accept(l, r);
        };
    }
}
