package moe.queery.needle.type;

import java.util.Collection;
import java.util.LinkedList;

public class EvictingList<T> extends LinkedList<T> {
    private final int maxSize;

    public EvictingList(final int maxSize) {
        this.maxSize = maxSize;
    }

    public EvictingList(final Collection<? extends T> c, final int maxSize) {
        super(c);
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean add(final T t) {
        if (this.isFull()) this.removeFirst();
        return super.add(t);
    }

    public boolean addAll(final Collection<? extends T> c) {
        return c.stream().anyMatch(this::add);
    }

    public boolean isFull() {
        return this.size() >= this.maxSize;
    }
}
