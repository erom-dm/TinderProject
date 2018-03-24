package ua.com.danit;

import org.junit.Assert;
import org.junit.Test;

public class TestMath {

    @Test
    public void test1() {
        MyXor myXor = new MyXor();

        Assert.assertEquals("010", myXor.xor("101", "111"));
    }


    @Test
    public void test11() {
        MyXor myXor = new MyXor();

        Assert.assertEquals("001", myXor.xor("111", "110"));
    }

    @Test
    public void test12() {
        MyXor myXor = new MyXor();

        Assert.assertEquals("111", myXor.xor("1", "110"));
    }

    @Test
    public void test13() {
        MyXor myXor = new MyXor();
        Assert.assertEquals("111", myXor.xor("10", "101"));
    }


    @Test
    public void test2() {
        MyXor myXor = new MyXor();

        Assert.assertEquals("111", myXor.xor(null, "111"));
    }

    @Test
    public void test3() {
        MyXor myXor = new MyXor();

        Assert.assertEquals("101", myXor.xor("101", null));
    }

    @Test
    public void test4() {
        MyXor myXor = new MyXor();
        Assert.assertEquals(null, myXor.xor(null, null));
    }

    @Test
    public void test5() {
        MyXor myXor = new MyXor();

        Assert.assertEquals("", myXor.xor("001", "gewgwe"));
    }

    @Test
    public void test6() {
        MyXor myXor = new MyXor();

        Assert.assertEquals("", myXor.xor("131535", "ewh3w47w3634w"));
    }
}
