package moe.queery.needle.types;

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
}
