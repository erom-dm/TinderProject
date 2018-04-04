package basic.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTest {
    @Test
    public void testCollisionsResolved() {
        Hash hash = new Hash();
        hash.put(10,"10");
        hash.put(99,"99");
        hash.put(999,"999");
        hash.put(15,"ABC");
        hash.put(123,"HELLO");
        hash.put(217,"CAT");
        hash.put(666,"DOG");
        hash.put(999999157,"HELL ;)");

        assertEquals("ABC", hash.get(15));
        assertEquals("HELL ;)", hash.get(999999157));
        assertEquals("CAT", hash.get(217));
        assertEquals("10", hash.get(10));
        assertEquals("99", hash.get(99));
        assertEquals("999", hash.get(999));
    }

}