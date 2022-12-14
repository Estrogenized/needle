package moe.queery.needle.type.consumer.bi.g2p.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Obj2FloatBiConsumer<V> extends BiConsumer<@NotNull V, @NotNull Float> {
    void acceptFloat(final V left, final float right);

    @Deprecated
    default @Override void accept(final @NotNull V left, final @NotNull Float right) {
        this.acceptFloat(left, right);
    }

    default @Contract(pure = true) Obj2FloatBiConsumer<V> andThenFloat(final @NotNull Obj2FloatBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptFloat(l, r);
            after.acceptFloat(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull V, @NotNull Float> andThen(final @NotNull BiConsumer<? super @NotNull V, ? super @NotNull Float> after) {
        return (l, r) -> {
            this.acceptFloat(l, r);
            after.accept(l, r);
        };
    }
}
