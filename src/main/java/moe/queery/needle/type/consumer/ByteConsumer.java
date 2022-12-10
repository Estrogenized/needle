package moe.queery.needle.type.consumer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface ByteConsumer extends Consumer<Byte> {
    void acceptByte(final byte value);

    @Deprecated
    default @Override void accept(final @NotNull Byte value) {
        this.acceptByte(value);
    }

    default @Contract(pure = true) ByteConsumer andThenByte(final @NotNull ByteConsumer after) {
        return (value) -> {
            this.acceptByte(value);
            after.acceptByte(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Byte> andThen(final @NotNull Consumer<? super @NotNull Byte> after) {
        return (value) -> {
            this.acceptByte(value);
            after.accept(value);
        };
    }
}
