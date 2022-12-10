package moe.queery.needle.collection.evicting;

import java.util.Collection;
import java.util.Collections;

public final class EvictingCollection<V> {
    private final Collection<V> collection;

    private final int maxSize;

    // @formatter:off
    EvictingCollection() { this(Collections.emptyList(), 0); }
    // @formatter:off

    public EvictingCollection(final Collection<V> collection, final int maxSize) {
        this.collection = collection;
        this.maxSize = maxSize;
    }

    public @SuppressWarnings("all") boolean add(final V value) {
        final boolean removedFirstEntry;
        if (this.isFull()) {
            this.collection.remove(this.collection.toArray()[0]);
            removedFirstEntry = true;
        } else removedFirstEntry = false;
        this.collection.add(value);
        return removedFirstEntry;
    }

    public boolean isFull() {
        return this.collection.size() >= this.maxSize;
    }

    public Collection<V> getNormalCollection() {
        return this.collection;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
