package moe.queery.needle.type.consumer.bi.p2g;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Byte2ObjBiConsumer<V> extends BiConsumer<@NotNull Byte, @NotNull V> {
    void acceptByte(final byte left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Byte left, final @NotNull V right) {
        this.acceptByte(left, right);
    }

    default @Contract(pure = true) Byte2ObjBiConsumer<V> andThenByte(final @NotNull Byte2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptByte(l, r);
            after.acceptByte(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Byte, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Byte, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptByte(l, r);
            after.accept(l, r);
        };
    }
}
