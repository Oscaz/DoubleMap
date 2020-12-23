package dev.oscaz.doublemap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class DoubleConcurrentHashMap<K1, K2, V> extends AbstractDoubleMap<K1, K2, V> {

    public DoubleConcurrentHashMap() {
        super(ConcurrentHashMap::new, ConcurrentHashMap::new);
    }

}
