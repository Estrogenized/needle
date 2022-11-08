package moe.queery.needle.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public final class Sneaky {
    @Contract("null->null;!null->!null")
    @SuppressWarnings("unchecked")
    public @Nullable
    static <T> T cast(final @Nullable Object object) {
        return (T) object;
    }

    public interface ThrowingRunnable<E extends Throwable> {
        void run() throws E;
    }

    public interface ThrowingConsumer<T, E extends Throwable> {
        void accept(final T throwing) throws E;
    }
}
