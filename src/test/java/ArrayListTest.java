import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;

public class ArrayListTest {
    @Test
    public void shouldSizeIncrementedAndElementIsAvailableWhenAddElement() {
        //region Given
        ArrayList sut = new ArrayList();
        Object dummy = new Object();

        assumeTrue(sut.size() == 0);
        assumeThat(sut.size(), is(0));
        //endregion

        //region When
        sut.add(dummy);
        //endregion

        //region Then
        assertEquals(1, sut.size());
        assertEquals(dummy, sut.get(0));
        //endregion
    }

    @Test
    public void shouldBeEmptyWhenCreated() {
        ArrayList sut;
        sut = new ArrayList();
        assertEquals(0, sut.size());
    }

    @Test(timeout = 3_000)
    public void shouldFailWithTimeout() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldFailWhenGetNonExistingElement() {
        ArrayList sut = new ArrayList();
        sut.get(1);
    }
}
