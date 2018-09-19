package com.acme.edu;

import org.apache.commons.lang3.ObjectUtils;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class LoggerTest1 {

    private Logger sut;

    @Before
    public void setUp(){

        //1

    }

    @Test
    public void shouldCreateLoggerWhenFilterAndSaverAreOk(){

        //region Given
        LoggerSaver saverStub = mock(LoggerSaver.class);
        LoggerFilter filterStub = mock(LoggerFilter.class);
        //endregion

        //region When
        sut = new Logger(filterStub, saverStub);
        //endregion


        //region Then
//        Assertions.assertThat(sut).isNotNull();
        //endregion
    }

    @Test
    public void shouldLogWhenFilterisTrue(){

        //region Given
        LoggerSaver saverStub = mock(LoggerSaver.class);


        LoggerFilter filterStub = mock(LoggerFilter.class);
        when(filterStub.filter(anyString()) ).thenReturn(true);

        String testString = "Test 1";
        //endregion

        //region When
        sut = new Logger(filterStub, saverStub);
        //endregion

        sut.log(testString);
        //region Then
                verify(saverStub).save(testString);
        //endregion
    }

    @Test
    public void shouldNotLogWhenFilterisFalse(){


        //region Given
        LoggerSaver saverStub = mock(LoggerSaver.class);


        LoggerFilter filterStub = mock(LoggerFilter.class);
        when(filterStub.filter(anyString())).thenReturn(false);

        String testString = "Test 1";
        //endregion

        //region When
        sut = new Logger(filterStub, saverStub);
        //endregion

        sut.log(anyString());
        //region Then
        verify(saverStub,times(0)).save(anyString());
        //endregion
    }

    @Test
    public void shouldNotLogWhenStringIsNull(){


        //region Given
        LoggerSaver saverStub = mock(LoggerSaver.class);


        LoggerFilter filterStub = mock(LoggerFilter.class);
        when(filterStub.filter(anyString())).thenReturn(true);

        String testString = "";
        //endregion

        //region When
        sut = new Logger(filterStub, saverStub);
        //endregion

        sut.log(testString);
        //region Then
        verify(saverStub).save(testString);
        //endregion
    }


}
