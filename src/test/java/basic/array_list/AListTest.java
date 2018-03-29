package basic.array_list;

import org.junit.Test;
import static org.junit.Assert.*;

public class AListTest {

    @Test
    public void addTest1() {
        AList<Integer> list = new AList <Integer> (10);
        list.add(10);
        list.add(15);
        list.add(20);

        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals((Integer) 15, list.get(1));
        assertEquals(new Integer(20), list.get(2));
    }

    @Test
    public void resizeTest(){
        AList list = new AList(10);
        for (int i = 0; i < list.size(); i++) {
            list.add(i*12);
        }

        list.add(133);

        //assertEquals(133, list.get(10));
    }
    @Test
    public void otherTest(){
        AList list = new AList(10);
        for (int i = 0; i < list.size(); i++) {
            list.add(i*12);
        }

        list.add(133);

        //assertEquals(133, list.get(10));
    }

    @Test
    public void zeroTest(){
        AList list = new AList(10);
        for (int i = 0; i < list.size(); i++) {
            list.add(i*12);
        }

        assertEquals(null, list.get(15));
    }

    @Test
    public void emptyValueTest(){
        AList list = new AList(10);
        for (int i = 0; i < list.size(); i++) {
            list.add(i*12);
        }

        assertEquals(null, list.get(15));

    }    @Test
    public void emptyValueTestString(){
        AList<String> list = new AList<String>(10);
        for (int i = 0; i < list.size(); i++) {
            list.add("Name " + i);
        }

        assertEquals("Name 0", list.get(0));
    }
    @Test
    public void emptyValueTestAlist(){
        AList<AList<String>> list = new AList<>(10);
        for (int i = 0; i < list.size(); i++) {
            list.add(new AList<String>(i));
        }

        assertEquals(new AList<>(0), list.get(0));
    }
}
