package com.acme.edu;

import org.hamcrest.CoreMatchers.*;
import org.fest.assertions.api.Assertions;
import org.junit.*;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.core.StringContains.*;
import static junit.framework.TestCase.assertTrue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import static org.fest.assertions.api.Assertions.assertThat;

public class ArrayListTest {
    private ArrayList<Object> sut;

    @BeforeClass @AfterClass
    public static void globalSetUp() {

    }

    @Before @After
    public void setUp() {
        sut = new ArrayList<>(); //Diamond operator
    }

    @Test
    public void shouldSizeIncrementedWhenAddElementNotNull() {
        //region Given
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

    @Test//(expected = Throwable.class)
    public void shouldThrowExceptionWhenAddNullElement() {
        //region When
        sut.add(null);
        //endregion
    }

    @Test
    public void shouldGetStringRepresentationFromElementsWhenToString() {
        //region Given
        sut.add("test 1");
        sut.add(2);
        //endregion

        //region When
        String result = sut.toString();
        //endregion

        //region Then
        assertTrue(
                result.contains("test 1") &&
                result.contains("2")
        );

        String str;
        Assert.assertThat(
                result,
                allOf(
                        containsString("2"),
                        containsString("test 1")
                )
        );

        Assertions.assertThat(result)
            .contains("2")
            .contains("test 1");
        //endregion
    }
}
