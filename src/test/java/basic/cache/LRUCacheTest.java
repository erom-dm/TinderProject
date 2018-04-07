package basic.cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void verifayThatCachCanContainsValue(){
        LRUCache<Integer, Integer> cache = new LRUCache<>();
        cache.put(1, 2);

        assertNotNull(cache.get(1));
        assertEquals(2, (int)cache.get(1));
    }

    @Test
    public void verifyThatRemoveLeastElement(){
        LRUCache<String, Integer> cache = new LRUCache<>(2);
        cache.put("A", 1);
        cache.put("B", 2);

        assertEquals(1, (int)cache.get("A"));
        assertEquals(2, (int)cache.get("B"));

        cache.put("C", 3);

        assertNull(cache.get("A"));
        assertEquals(2, (int)cache.get("B"));
        assertEquals(3, (int)cache.get("C"));

    }

    @Test
    public void verifyThatRemoveLeastElementWithGetOperation(){
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        assertEquals(1, (int)cache.get("A"));
        assertEquals(2, (int)cache.get("B"));
        assertEquals(3, (int)cache.get("C"));

        cache.get("A");
        cache.put("D", 4);


        assertNull(cache.get("B"));
        assertEquals(1, (int)cache.get("A"));
        assertEquals(3, (int)cache.get("C"));
        assertEquals(4, (int)cache.get("D"));

    }

}