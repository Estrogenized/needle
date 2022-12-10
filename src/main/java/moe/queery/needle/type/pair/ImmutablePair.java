package moe.queery.needle.type.pair;

public class ImmutablePair<K, V> extends Pair<K, V> {
    private final K key;
    private final V value;

    public ImmutablePair(final K key, final V val) {
        super(key, val);
        this.key = key;
        this.value = val;
    }

    public @Override void setKey(final K key) {}
    public @Override K getKey() {
        return this.key;
    }

    public @Override final void setValue(final V value) {}
    public @Override V getValue() {
        return this.value;
    }
}
