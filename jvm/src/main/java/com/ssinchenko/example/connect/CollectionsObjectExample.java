package com.ssinchenko.example.connect;

import java.util.List;
import java.util.Map;

/**
 * This class represents the simple tool that should make some computations
 * and return java collections. In Python-JVM interoperability working with
 * JVM collections is one of the most painful process.
 * 
 * This class may mimic examples from OSS projects which returns some
 * meta-information.
 */
public class CollectionsObjectExample {
    public static List<String> getListOfString() {
        return List.of("a", "b", "c");
    }

    public static Map<Long, Long> getMapOfLongs() {
        return Map.of(1L, 4L, 2L, 6L);
    }
}
