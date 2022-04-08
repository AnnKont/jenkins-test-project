package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testFirst() {
        var one = 1;
        var two = 2;
        var actual = one +two;
        var expected = 3;
        Assertions.assertEquals(expected, actual, "error");
    }

}
