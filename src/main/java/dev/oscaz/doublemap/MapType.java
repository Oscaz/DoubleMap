package dev.oscaz.doublemap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public enum MapType {

    HASH(HashMap.class),
    WEAK_HASH(WeakHashMap.class),
    CONCURRENT_HASH(ConcurrentHashMap.class)
    ;

    private final Class<? extends Map> type;

    MapType(Class<? extends Map> type) {
        this.type = type;
    }

    <K1, K2, V> Map<K1, Map<K2, V>> create() {
        try {
            return (Map<K1, Map<K2, V>>) type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    <K2, V> Map<K2, V> createInner() {
        try {
            return (Map<K2, V>) type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    Class<? extends Map> getType() {
        return this.type;
    }

}