package moe.queery.needle.type.consumer.bi.primitive;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface ByteBiConsumer extends BiConsumer<@NotNull Byte, @NotNull Byte> {
    void acceptByte(final byte left, final byte right);

    @Deprecated
    default @Override void accept(final @NotNull Byte left, final @NotNull Byte right) {
        this.acceptByte(left, right);
    }

    default @Contract(pure = true) ByteBiConsumer andThenByte(final @NotNull ByteBiConsumer after) {
        return (l, r) -> {
            this.acceptByte(l, r);
            after.acceptByte(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Byte, @NotNull Byte> andThen(final @NotNull BiConsumer<? super @NotNull Byte, ? super @NotNull Byte> after) {
        return (l, r) -> {
            this.acceptByte(l, r);
            after.accept(l, r);
        };
    }
}
