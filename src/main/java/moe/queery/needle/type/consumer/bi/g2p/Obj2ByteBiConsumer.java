package moe.queery.needle.type.consumer.bi.g2p;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2ByteBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Byte> {
    void acceptByte(final V left, final byte right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Byte right) {
        this.acceptByte(left, right);
    }

    default @Contract(pure = true) Obj2ByteBiConsumer<V> andThenByte(final @NotNull Obj2ByteBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptByte(l, r);
            after.acceptByte(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Byte> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Byte> after) {
        return (l, r) -> {
            this.acceptByte(l, r);
            after.accept(l, r);
        };
    }
}
