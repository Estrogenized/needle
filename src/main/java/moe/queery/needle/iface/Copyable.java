package moe.queery.needle.iface;

import org.jetbrains.annotations.NotNull;

public interface Copyable<C extends Copyable<C>> {
    @NotNull C copy();
}
