package com.acme.edu;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoStubFilterBuilder {
    private String message;
    private boolean result;

    public MockitoStubFilterBuilder whenMessage(String message) {
        this.message = message;
        return this;
    }

    public MockitoStubFilterBuilder thenReturn(boolean result) {
        this.result = result;
        return this;
    }

    public LoggerFilter build() {
        LoggerFilter loggerFilterStub = mock(LoggerFilter.class);
        when(loggerFilterStub.filter(message)).thenReturn(result);
        return loggerFilterStub;
    }
}
