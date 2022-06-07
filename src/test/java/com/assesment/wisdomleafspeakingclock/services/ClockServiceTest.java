package com.assesment.wisdomleafspeakingclock.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClockServiceTest {

    @InjectMocks
    private ClockService service;

    @Mock
    private Logger logger;

    @BeforeEach
    void setUp(){
        ReflectionTestUtils.setField(service, "logger", logger);
    }

    @Test
    void willReturnTimeInWords_whenItIsAnyTimeOtherThanMidNightOrNoon(){
        //given
        LocalTime time = LocalTime.of(3, 9);

        //when
        String timeInWords = service.returnCurrentTimeInWords(time);

        //then
        assertEquals("it's Three Nine", timeInWords);
        Mockito.verify(logger, Mockito.times(1)).info("It is Three Nine");
    }

    @Test
    void willReturnTimeInWords_whenItIsMidnight(){
        //given
        LocalTime time = LocalTime.of(0, 0);

        //when
        String timeInWords = service.returnCurrentTimeInWords(time);

        //then
        assertEquals("it's Midnight", timeInWords);
        Mockito.verify(logger, Mockito.times(1)).info("It is Midnight");
    }

    @Test
    void willReturnTimeInWords_whenItIsNoon(){
        //given
        LocalTime time = LocalTime.of(12, 0);

        //when
        String timeInWords = service.returnCurrentTimeInWords(time);

        //then
        assertEquals("it's Noon", timeInWords);
        Mockito.verify(logger, Mockito.times(1)).info("It is Noon");
    }

    @Test
    void willReturnTimeInWords_whenItIsNull(){

        //when
        String timeInWords = service.returnCurrentTimeInWords(null);

        //then
        assertNull(timeInWords);
        Mockito.verify(logger, Mockito.times(1)).error("The LocalTime object is null");
    }

}