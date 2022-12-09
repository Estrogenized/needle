package moe.queery.needle.type;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(final K key, final V val) {
        this.key = key;
        this.value = val;
    }

    public K getKey() {
        return key;
    }

    public void setKey(final K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(final V value) {
        this.value = value;
    }

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
}
