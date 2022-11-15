package moe.queery.needle.utils;

import org.jetbrains.annotations.NotNull;

public interface Copyable<C extends Copyable<C>> {
    @NotNull C copy();
}
