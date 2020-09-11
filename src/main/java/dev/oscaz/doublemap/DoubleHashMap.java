package dev.oscaz.doublemap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DoubleHashMap<K1, K2, V> extends AbstractDoubleMap<K1, K2, V> {

    public DoubleHashMap() {
        super(HashMap::new);
    }

}
