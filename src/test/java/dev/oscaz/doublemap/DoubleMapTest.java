package dev.oscaz.doublemap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class DoubleMapTest {

    @Test
    public void test_put() {
        DoubleMap<UUID, String, Integer> map = DoubleMap.builder()
                .type(MapType.HASH)
                .build();
        UUID uuid = UUID.fromString("cf102beb-970a-46d6-ab71-4140581a5505");
        String k2 = "AAAAA";
        Integer val = 400;
        map.put(uuid, k2, val);
        Assertions.assertEquals(map.get(uuid, k2), val);

        Assertions.assertNull(map.get(uuid, "IIIII"));
    }

    @Test
    public void test_putAll() {
        DoubleMap<UUID, String, Integer> map = DoubleMap.builder()
                .type(MapType.HASH)
                .build();
        UUID uuid = UUID.fromString("cf102beb-970a-46d6-ab71-4140581a5505");
        String k2 = "AAAAA";
        Integer val = 400;
        map.put(uuid, k2, val);
        Assertions.assertEquals(map.get(uuid, k2), val);

        DoubleMap<UUID, String, Integer> map2 = DoubleMap.builder()
                .type(MapType.HASH)
                .build();

        map2.putAll(map);

        Assertions.assertEquals(map2.get(uuid, k2), val);
    }

    @Test
    public void test_remove() {
        DoubleMap<UUID, String, Integer> map = DoubleMap.builder()
                .type(MapType.HASH)
                .build();
        UUID uuid = UUID.fromString("cf102beb-970a-46d6-ab71-4140581a5505");
        String k2 = "AAAAA";
        Integer val = 400;
        map.put(uuid, k2, val);
        Assertions.assertEquals(map.get(uuid, k2), val);

        map.remove(uuid, k2);
        Assertions.assertNull(map.get(uuid, k2));
    }

    @Test
    public void test_size() {
        DoubleMap<UUID, String, Integer> map = DoubleMap.builder()
                .type(MapType.HASH)
                .build();
        UUID uuid = UUID.fromString("cf102beb-970a-46d6-ab71-4140581a5505");
        String k2a = "AAAAA";
        String k2b = "BBBBB";
        String k2c = "CCCCC";
        Integer val = 400;

        map.put(uuid, k2a, val);
        Assertions.assertEquals(map.size(), 1);
        Assertions.assertEquals(map.innerSize(), 1);
        Assertions.assertEquals(map.size(uuid), 1);

        map.put(uuid, k2b, val);
        Assertions.assertEquals(map.size(), 1);
        Assertions.assertEquals(map.innerSize(), 2);
        Assertions.assertEquals(map.size(uuid), 2);

        map.put(uuid, k2c, val);
        Assertions.assertEquals(map.size(), 1);
        Assertions.assertEquals(map.innerSize(), 3);
        Assertions.assertEquals(map.size(uuid), 3);
    }

    @Test
    public void test_isEmpty() {
        DoubleMap<UUID, String, Integer> map = DoubleMap.builder()
                .type(MapType.HASH)
                .build();
        UUID uuid = UUID.fromString("cf102beb-970a-46d6-ab71-4140581a5505");
        UUID fakeUUID = UUID.fromString("e83cd394-8fe0-4588-8336-e8ab88b673aa");
        String k2 = "AAAAA";
        Integer val = 400;

        Assertions.assertTrue(map.isEmpty());
        Assertions.assertTrue(map.isEmpty(uuid));

        map.put(uuid, k2, val);

        Assertions.assertFalse(map.isEmpty());
        Assertions.assertFalse(map.isEmpty(uuid));
        Assertions.assertTrue(map.isEmpty(fakeUUID));

        map.remove(uuid, k2);

        Assertions.assertTrue(map.isEmpty());
        Assertions.assertTrue(map.isEmpty(uuid));
    }

}
