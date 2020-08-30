# DoubleMap
A simple wrapper class for double maps in Java.

For example `Map<K1, Map<K2, V>>` can be reduced to `DoubleMap<K1, K2, V>` using this library and a variety of helper methods are added to help your code look more clean.

#Usage

```java

DoubleMap<UUID, String, Integer> map = DoubleMap.builder().
                                          .type(MapType.HASH)
                                          .build();

UUID uuid = UUID.fromString("cf102beb-970a-46d6-ab71-4140581a5505");
String k2 = "AAAAA";
Integer val = 400;

map.put(uuid, k2, val);
Integer val = map.get(uuid, k2);
map.remove(uuid, k2);
```

#Installation

Currently you may copy the files into your project, a Maven repository will be available soon for use.

#Features

If you have a feature request open an issue, if you are a developer and want to add additional functionality, please open a pull request.
