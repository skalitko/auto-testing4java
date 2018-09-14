package com.acme.edu;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import org.junit.Assume;

public class ArrayListTest {
    @Test
    public void shouldSizeIncrementedWhenAddElementNotNull() {
        //region Given
        ArrayList<Object> sut = new ArrayList<>();
        Object dummy = new Object();
        assumeTrue(sut.size() == 0);
        //endregion

        //region When
        sut.add(dummy);
        if (1 != 1) throw new RuntimeException("test");
        //endregion

        //region Then
        assertEquals(1, sut.size());
        //endregion
    }
}
