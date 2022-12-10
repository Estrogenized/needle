package moe.queery.needle.type.consumer.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface ShortConsumer extends Consumer<Short> {
    void acceptShort(final short value);

    @Deprecated
    default @Override void accept(final @NotNull Short value) {
        this.acceptShort(value);
    }

    default @Contract(pure = true) ShortConsumer andThenShort(final @NotNull ShortConsumer after) {
        return (value) -> {
            this.acceptShort(value);
            after.acceptShort(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Short> andThen(final @NotNull Consumer<? super @NotNull Short> after) {
        return (value) -> {
            this.acceptShort(value);
            after.accept(value);
        };
    }
}
