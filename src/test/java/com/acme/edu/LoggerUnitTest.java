package com.acme.edu;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class LoggerUnitTest {
    private LoggerFilter filterStub;

    public void setUp(boolean filter) throws SQLException {
        ResultSet rsStub = mock(ResultSet.class);
        when(rsStub.next()).thenReturn(true);
        when(rsStub.getString("column1")).thenReturn("value1");
        when(rsStub.getString("column2")).thenReturn("value2");

        Statement statementStub = mock(Statement.class);
        when(statementStub.executeQuery("SELECT * FROM table")).thenReturn(rsStub);

        Connection connectionStub = mock(Connection.class);
        when(connectionStub.createStatement(0, 0))
                .thenReturn(statementStub);

        DataSource connectionFactoryStub = mock(DataSource.class);
        when(connectionFactoryStub.getConnection()).thenReturn(connectionStub);
    }

    @Test
    public void shouldDoLogWhenErrorMessage() {
        LoggerSaver saverMock = mock(LoggerSaver.class);

        Logger sut = new Logger(filterStub, saverMock);
        sut.log("ERROR");

        verify(saverMock, times(2)).save("ERROR");
    }
}
