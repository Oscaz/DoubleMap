package dev.oscaz.doublemap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MutableIntTest {

    @Test
    public void test_add() {
        MutableInt mutableInt = new MutableInt();
        mutableInt.add(5);
        Assertions.assertEquals(5, mutableInt.get());
        mutableInt.add(7);
        Assertions.assertEquals(12, mutableInt.get());
        mutableInt.add(4);
        Assertions.assertEquals(16, mutableInt.get());
    }

    @Test
    public void test_sub() {
        MutableInt mutableInt = new MutableInt();
        mutableInt.sub(5);
        Assertions.assertEquals(-5, mutableInt.get());
        mutableInt.sub(8);
        Assertions.assertEquals(-13, mutableInt.get());
        mutableInt.sub(10);
        Assertions.assertEquals(-23, mutableInt.get());
    }

    @Test
    public void test_mul() {
        MutableInt mutableInt = new MutableInt();
        mutableInt.mul(10);
        Assertions.assertEquals(0, mutableInt.get());
        mutableInt.add(3);
        mutableInt.mul(4);
        Assertions.assertEquals(12, mutableInt.get());
        mutableInt.mul(4);
        Assertions.assertEquals(48, mutableInt.get());
    }

    @Test
    public void test_div() {
        MutableInt mutableInt = new MutableInt();
        mutableInt.add(10);
        mutableInt.div(2);
        Assertions.assertEquals(5, mutableInt.get());
        mutableInt.div(5);
        Assertions.assertEquals(1, mutableInt.get());
        mutableInt.div(2);
        Assertions.assertEquals(0, mutableInt.get());
    }

    @Test
    public void test_mod() {
        MutableInt mutableInt = new MutableInt();
        mutableInt.add(30);
        mutableInt.mod(3);
        Assertions.assertEquals(0, mutableInt.get());
        mutableInt.add(15);
        mutableInt.mod(4);
        Assertions.assertEquals(3, mutableInt.get());
        mutableInt.mod(2);
        Assertions.assertEquals(1, mutableInt.get());
    }

}
