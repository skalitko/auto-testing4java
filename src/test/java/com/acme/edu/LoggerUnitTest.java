package com.acme.edu;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LoggerUnitTest {
    private LoggerFilter filterStub;


    @Test
    public void shouldDoLogWhenErrorMessage() {
        DataSource connectionFactoryStub =
                new ConnectionFactoryMockitoStubBuilder()
                    .withConnection()
                    .withStatement("SQL1")
                        .withResultSet()
                            .withRecord("column2:value1")
                            .withRecord("column3:value2")
                            .withRecord("column3:value3")
                .build();

        new BusinessLogicComponent(connectionFactoryStub);
    }
}

class BusinessLogicComponent {
    public BusinessLogicComponent(DataSource ds) {
    }
}

class ConnectionFactoryMockitoStubBuilder {
    private DataSource connectionFactoryStub;
    private Connection connectionStub;
    private Statement statementStub;
    private String sql;
    private ResultSet rsStub;
    private List<String> records = new LinkedList<>();
    private boolean hasRecords = true;

    public ConnectionFactoryMockitoStubBuilder withConnection() {
        connectionFactoryStub = mock(DataSource.class);
        connectionStub = mock(Connection.class);
        return this;
    }

    public ConnectionFactoryMockitoStubBuilder withStatement(String sql) {
        this.sql = sql;
        this.statementStub = mock(Statement.class);
        return this;
    }

    public ConnectionFactoryMockitoStubBuilder withResultSet() {
        rsStub = mock(ResultSet.class);
        return this;
    }

    public ConnectionFactoryMockitoStubBuilder withRecord(String record) {
        records.add(record);
        return this;
    }

    public DataSource build() {
        try {
            when(rsStub.next()).thenReturn(hasRecords);
            for (String record : records) {
                String[] fields = record.split(":");
                when(rsStub.getString(fields[0])).thenReturn(fields[1]);
            }

            when(statementStub.executeQuery(sql)).thenReturn(rsStub);

            when(connectionStub.createStatement()).thenReturn(statementStub);

            when(connectionFactoryStub.getConnection()).thenReturn(connectionStub);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connectionFactoryStub;
    }
}
