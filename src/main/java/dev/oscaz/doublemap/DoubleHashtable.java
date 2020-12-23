package dev.oscaz.doublemap;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Supplier;

public class DoubleHashtable<K1, K2, V> extends AbstractDoubleMap<K1, K2, V> {

    public DoubleHashtable() {
        super(Hashtable::new, Hashtable::new);
    }

}
