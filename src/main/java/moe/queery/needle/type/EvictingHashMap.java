package moe.queery.needle.type;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EvictingHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public EvictingHashMap(final int maxSize) {
        this.maxSize = maxSize;
    }

    public EvictingHashMap(final HashMap<? extends K, ? extends V> map, final int maxSize) {
        super(map);
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean isFull() {
        return this.size() >= this.maxSize;
    }

    @Override
    protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
        return this.size() > this.maxSize;
    }
}
