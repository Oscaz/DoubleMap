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
 * @param <K2> The inner key associated
 * @param <V> The value associated with the k1 and k2 mappings.
 */
public interface DoubleMap<K1, K2, V> extends Iterable<DoubleMap.Entry<K1, K2, V>> {
    /**
     * @return The amount of K -> Map<L, V> mappings
     */
    int size();

    int size(K1 k1);

    /**
     * @return The amount of L -> V mappings summed for each K -> Map<L, V> mapping
     */
    int innerSize();

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @param v The value to put in the map
     * @return V The previous mapping associated with k1 and k2, null if none found.
     */
    @SuppressWarnings("unchecked")
    V put(K1 k1, K2 k2, V v);

    void putAll(AbstractDoubleMap<? extends K1, ? extends K2, ? extends V> map);

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @return V The previous mapping associated with k1 and k2, null if none found.
     */
    V remove(K1 k1, K2 k2);

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @return The value associated or null if none found
     */
    V get(K1 k1, K2 k2);

    boolean isEmpty();

    /**
     * @param k1 The outer key of the map
     * @return If the inner map is empty / non-existent
     */
    boolean isEmpty(K1 k1);

    boolean containsKey(K1 key);

    /**
     * @param k1 The outer key of the map
     * @param k2 The inner key of the map
     * @return If the inner map contains k2
     */
    boolean containsKey(K1 k1, K2 k2);

    Map<K2, V> get(K1 key);

    Map<K2, V> put(K1 key, Map<K2, V> value);

    Map<K2, V> remove(K1 key);

    void putAll(Map<? extends K1, ? extends Map<K2, V>> m);

    void clear();

    Set<K1> keySet();

    Collection<Map<K2, V>> values();

    Set<Map.Entry<K1, Map<K2, V>>> entrySet();

    Iterator<DoubleMap.Entry<K1, K2, V>> iterator();

    void forEach(Consumer<? super DoubleMap.Entry<K1, K2, V>> action);

    Spliterator<DoubleMap.Entry<K1, K2, V>> spliterator();

    interface Entry<K1, K2, V> {

        /**
         * @return The first key in the double-map mapping
         */
        public K1 getK1();

        /**
         * @return The second key in the double-map mapping
         */
        public K2 getK2();

        /**
         * @return The value in the double-map mapping
         */
        public V getV();
    }

}
