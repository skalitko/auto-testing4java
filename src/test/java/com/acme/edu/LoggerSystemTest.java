package com.acme.edu;

import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;
import static org.fest.assertions.Assertions.*;

public class LoggerSystemTest {
    //region Fixture
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();

    private Logger sut;
//    private static Browser xxx;

    @BeforeClass
    public static void setUpXXX() {
        //
    }

    @AfterClass
    public static void closeXXX() {

    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Before
    public void setUpLoggerSut() {
        sut = new Logger(
                new MessageContentLoggerFilter(),
                new ConsoleLoggerSaver()
        );
    }
    //endregion

    @Test
    public void shouldLogToConsoleWhenErrorMessage() {
        //region When
        sut.log("ERROR: test message");
        //endregion

        //region Then
//        assertThat(
//                out.toString(),
//                containsString("ERROR: test message")
//        );

        assertThat(out.toString())
                .contains("ERROR: test message")
                .startsWith("Wed")
                .endsWith("message");

        //endregion
    }
}
