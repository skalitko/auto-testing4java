package com.acme.edu;


import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListTest {
    @Test(timeout = 10000)
    public void shouldSizeIncrementedWhenElementAddAndSutIsEmpty() {
        //region Given
        ArrayList<Object> sut = new ArrayList<Object>();
        Object dummy = new Object();
        //endregion

        assumeTrue(sut.isEmpty());

        //region When
        sut.add(dummy);
        //endregion

        //region Then
        assertEquals(1, sut.size()); //AssertionError
        //endregion
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateWhenCapacityIsNegative() {
        new ArrayList(-1);
    }

    @Test @Ignore
    public void shouldSizeBeZeroWhenCreated() { }

    @Test
    public void shouldUseElementsToStringWhenToString() {
        //region Given
        ArrayList<Object> sut = new ArrayList<Object>();
        Object stub = mock(Object.class);
        when(stub.toString())
            .thenReturn("test string 1")
            .thenReturn("test string 2");
        sut.add(stub);
        //endregion

        //region When
        String result = sut.toString();
        //endregion

        //region Then
        assertTrue(result.contains("test string"));
        //endregion
    }
}

class My {
    public String m() {
        return "1";
    }
}
