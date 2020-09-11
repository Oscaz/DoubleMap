package dev.oscaz.doublemap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DoubleLinkedHashMap<K1, K2, V> extends AbstractDoubleMap<K1, K2, V> {

    public DoubleLinkedHashMap() {
        super(LinkedHashMap::new);
    }

}
