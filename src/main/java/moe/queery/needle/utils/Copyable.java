package moe.queery.needle.utils;

import org.jetbrains.annotations.NotNull;

interface Copyable<C extends Copyable<C>> {
    @NotNull C copy();
}
