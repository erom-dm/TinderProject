package basic.binary_heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class PQueueTest {
    @Test
    public void testSimpleOne() {
        PQueue queue = new PQueue(10);
        queue.add(123);
        int max = queue.removeMax();
        assertEquals(123, max);
    }

    @Test
    public void testMoreDifficultOne() {
        PQueue queue = new PQueue(10);
        queue.add(123);
        queue.add(5);
        queue.add(300);
        int max;
        max = queue.removeMax();
        assertEquals(300, max);
        max = queue.removeMax();
        assertEquals(123, max);
    }

}