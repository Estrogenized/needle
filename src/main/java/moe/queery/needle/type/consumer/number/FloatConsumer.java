package moe.queery.needle.type.consumer.number;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface FloatConsumer extends Consumer<Float> {
    void acceptFloat(final float value);

    @Deprecated
    default @Override void accept(final @NotNull Float value) {
        this.acceptFloat(value);
    }

    default @Contract(pure = true) FloatConsumer andThenFloat(final @NotNull FloatConsumer after) {
        return (value) -> {
            this.acceptFloat(value);
            after.acceptFloat(value);
        };
    }

    @Deprecated
    @Contract(pure = true)
    default @Override Consumer<@NotNull Float> andThen(final @NotNull Consumer<? super @NotNull Float> after) {
        return (value) -> {
            this.acceptFloat(value);
            after.accept(value);
        };
    }
}
