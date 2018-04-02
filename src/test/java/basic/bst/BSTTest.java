package basic.bst;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
/*
    @Before
    public void beforeEach() {
        System.out.println("before");
    }

*/
    @Test
    public void testSimpleOne() {
        BST bst = new BST();
        bst.add(8);

        assertTrue(bst.contains(8));
    }
    @Test
    public void testSimpleTwo() {
        BST bst = new BST();
        bst.add(8);

        assertFalse(bst.contains(1));
    }

    @Test
    public void testMoreDifficultOne() {
        BST bst = new BST();
        int[] keys = {1, 4, 5, 8, 7, 3, 2};
        for (int k : keys) {
            bst.add(k);
        }
        for (int k : keys) {
            assertTrue(bst.contains(k));
        }
    }

    @Test
    public void testMoreDifficultTwo() {
        BST bst = new BST();
        int[] keys = {1, 4, 5, 8, 7, 3, 2};
        int[] keysAbsent = {10, 11, 20, 6, 9};
        for (int k : keys) {
            bst.add(k);
        }
        for (int k : keysAbsent) {
            assertFalse(bst.contains(k));
        }
    }

/*
    @After
    public void afterEach() {
        System.out.println("after");
    }
*/
}