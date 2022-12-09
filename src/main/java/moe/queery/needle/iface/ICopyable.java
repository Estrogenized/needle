package moe.queery.needle.iface;

import org.jetbrains.annotations.NotNull;

public interface ICopyable<C extends ICopyable<C>> {
    @NotNull C copy();
}
