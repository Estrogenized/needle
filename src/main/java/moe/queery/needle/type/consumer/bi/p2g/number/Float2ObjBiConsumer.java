package moe.queery.needle.type.consumer.bi.p2g.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Float2ObjBiConsumer<V> extends BiConsumer<@NotNull Float, @NotNull V> {
    void acceptFloat(final float left, final V right);

    @Deprecated
    default @Override void accept(final @NotNull Float left, final @NotNull V right) {
        this.acceptFloat(left, right);
    }

    default @Contract(pure = true) Float2ObjBiConsumer<V> andThenFloat(final @NotNull Float2ObjBiConsumer<V> after) {
        return (l, r) -> {
            this.acceptFloat(l, r);
            after.acceptFloat(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Float, @NotNull V> andThen(final @NotNull BiConsumer<? super @NotNull Float, ? super @NotNull V> after) {
        return (l, r) -> {
            this.acceptFloat(l, r);
            after.accept(l, r);
        };
    }
}
