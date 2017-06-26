package com.acme.edu;

import org.junit.Test;

public class LoggerTest {
    @Test
    public void shouldLogErrorWhenErrorMessage() {
        LoggerFilter filterStub = new MockitoStubFilterBuilder()
                .whenMessage("ERROR1")
                .thenReturn(false)
            .build();
        Logger sut = new Logger();
    }
}

