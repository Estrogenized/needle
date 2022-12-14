package moe.queery.needle.type.consumer.bi.g2p.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2ShortBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Short> {
    void acceptShort(final V left, final short right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Short right) {
        this.acceptShort(left, right);
    }

    default @Contract(pure = true) Obj2ShortBiConsumer<V> andThenShort(final @NotNull Obj2ShortBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptShort(l, r);
            after.acceptShort(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Short> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Short> after) {
        return (l, r) -> {
            this.acceptShort(l, r);
            after.accept(l, r);
        };
    }
}
