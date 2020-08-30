package dev.oscaz.doublemap;

import java.util.*;
import java.util.function.Consumer;

/**
 * This class is essentially a wrapper for
 * a Map<K1, Map<K2, V>>, giving you helper methods
 * to make your code more clean.
 *
 * @author Oscaz
 *
 * @param <K1> The outer key associated
 * @param <K2>
 * @param <V>
 */
public class DoubleMap<K1, K2, V> implements Iterable<DoubleMap.Entry<K1, K2, V>> {

    private final MapType mapType;
    private final Map<K1, Map<K2, V>> map;

    public DoubleMap(MapType mapType) {
        this.mapType = mapType;
        this.map = mapType.create();
    }

    public static DoubleMap.Builder<Object, Object, Object> builder() {
        return new Builder<>();
    }

    /**
     * @return The amount of K -> Map<L, V> mappings
     */
    public int size() {
        return this.map.size();
    }

    public int size(K1 k1) {
        Map<K2, V> map = this.map.get(k1);
        if (map == null) return 0;
        return map.size();
    }

    /**
     * @return The amount of L -> V mappings summed for each K -> Map<L, V> mapping
     */
    public int innerSize() {
        MutableInt mutableInt = new MutableInt();
        this.map.values().stream().map(Map::size).forEach(mutableInt::add);
        return mutableInt.get();
    }

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @param v The value to put in the map
     * @return V The previous mapping associated with k1 and k2, null if none found.
     */
    public V put(K1 k1, K2 k2, V v) {
        return this.map.computeIfAbsent(k1, k -> this.mapType.createInner())
                .put(k2, v);
    }

    public void putAll(DoubleMap<? extends K1, ? extends K2, ? extends V> map) {
        map.map.forEach((k1, k1Map) -> {
            k1Map.forEach((k2, v) -> this.put(k1, k2, v));
        });
    }

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @return V The previous mapping associated with k1 and k2, null if none found.
     */
    public V remove(K1 k1, K2 k2) {
        V v = this.map.getOrDefault(k1, new HashMap<>()).remove(k2);
        if (this.map.containsKey(k1) && this.map.get(k1).size() == 0) {
            this.map.remove(k1);
        }
        return v;
    }

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @return The value associated or null if none found
     */
    public V get(K1 k1, K2 k2) {
        return this.map.getOrDefault(k1, new HashMap<>()).get(k2);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    /**
     * @param k1 The outer key of the map
     * @return If the inner map is empty / non-existent
     */
    public boolean isEmpty(K1 k1) {
        return this.size(k1) == 0;
    }

    public boolean containsKey(K1 key) {
        return this.map.containsKey(key);
    }

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @return If the inner map contains k2
     */
    public boolean containsKey(K1 k1, K2 k2) {
        return this.map.getOrDefault(k1, new HashMap<>()).containsKey(k2);
    }

    public Map<K2, V> get(K1 key) {
        return this.map.get(key);
    }

    public Map<K2, V> put(K1 key, Map<K2, V> value) {
        return this.map.put(key, value);
    }

    public Map<K2, V> remove(K1 key) {
        return this.map.remove(key);
    }

    public void putAll(Map<? extends K1, ? extends Map<K2, V>> m) {
        this.map.putAll(m);
    }

    public void clear() {
        this.map.clear();
    }

    public Set<K1> keySet() {
        return this.map.keySet();
    }

    public Collection<Map<K2, V>> values() {
        return this.map.values();
    }

    public Set<Map.Entry<K1, Map<K2, V>>> entrySet() {
        return this.map.entrySet();
    }

    @Override
    public Iterator<Entry<K1, K2, V>> iterator() {
        List<DoubleMap.Entry<K1, K2, V>> entries = new ArrayList<>();
        this.map.forEach((k1, k1Map) -> {
            k1Map.forEach((k2, v) -> {
                entries.add(new DoubleMap.Entry<>(k1, k2, v));
            });
        });
        return entries.iterator();
    }

    @Override
    public void forEach(Consumer<? super Entry<K1, K2, V>> action) {
        this.iterator().forEachRemaining(action);
    }

    @Override
    public Spliterator<Entry<K1, K2, V>> spliterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static final class Builder<K1, K2, V> {

        private MapType mapType = null;

        private Builder() {

        }

        public Builder<K1, K2, V> type(MapType mapType) {
            this.mapType = mapType;
            return this;
        }

        public <K11 extends K1, K21 extends K2, V1 extends V> DoubleMap<K11, K21, V1> build() {
            if (this.mapType == null) {
                throw new IllegalStateException("Cannot instantiate without a set type!");
            }
            return new DoubleMap<>(this.mapType);
        }

    }

    public static final class Entry<K1, K2, V> {

        private final K1 k1;
        private final K2 k2;
        private final V v;

        private Entry(K1 k1, K2 k2, V v) {
            this.k1 = k1;
            this.k2 = k2;
            this.v = v;
        }

        public K1 getK1() {
            return this.k1;
        }

        public K2 getK2() {
            return this.k2;
        }

        public V getV() {
            return this.v;
        }
    }
}
