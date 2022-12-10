package moe.queery.needle.type.consumer.bi.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface FloatBiConsumer extends BiConsumer<@NotNull Float, @NotNull Float> {
    void acceptFloat(final float left, final float right);

    @Deprecated
    default @Override void accept(final @NotNull Float left, final @NotNull Float right) {
        this.acceptFloat(left, right);
    }

    default @Contract(pure = true) FloatBiConsumer andThenFloat(final @NotNull FloatBiConsumer after) {
        return (l, r) -> {
            this.acceptFloat(l, r);
            after.acceptFloat(l, r);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override BiConsumer<@NotNull Float, @NotNull Float> andThen(final @NotNull BiConsumer<? super @NotNull Float, ? super @NotNull Float> after) {
        return (l, r) -> {
            this.acceptFloat(l, r);
            after.accept(l, r);
        };
    }
}
