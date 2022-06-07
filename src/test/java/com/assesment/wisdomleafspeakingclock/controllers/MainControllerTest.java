package com.assesment.wisdomleafspeakingclock.controllers;

import com.assesment.wisdomleafspeakingclock.services.ClockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @InjectMocks
    private MainController controller;

    @Mock
    private ClockService service;

    @Mock
    private Clock clock;

    @Mock
    private Logger logger;

    @Test
    public void whenTimeReturnedFromServiceIsAnyTimeOtherThanMidnightOrNoon(){
        //given

        Mockito.when(service.returnCurrentTimeInWords(Mockito.any(LocalTime.class))).
                thenReturn("It's Twelve Thirty");

        //when
        ResponseEntity<String> response = controller.getCurrentTime();

        //then
        assertEquals(200, response.getStatusCode().value());
        assertEquals("It's Twelve Thirty", response.getBody());
    }

    @Test
    public void whenTimeReturnedFromServiceIsMidnight(){
        //given

        Mockito.when(service.returnCurrentTimeInWords(Mockito.any(LocalTime.class))).
                thenReturn("It's Midnight");

        //when
        ResponseEntity<String> response = controller.getCurrentTime();

        //then
        assertEquals(200, response.getStatusCode().value());
        assertEquals("It's Midnight", response.getBody());

    }

    @Test
    public void whenTimeReturnedFromServiceIsNoon(){
        //given

        Mockito.when(service.returnCurrentTimeInWords(Mockito.any(LocalTime.class))).
                thenReturn("It's Noon");

        //when
        ResponseEntity<String> response = controller.getCurrentTime();

        //then
        assertEquals(200, response.getStatusCode().value());
        assertEquals("It's Noon", response.getBody());

    }

    @Test
    public void whenTimeReturnedFromServiceIsNull(){
        //given

        Mockito.when(service.returnCurrentTimeInWords(Mockito.any(LocalTime.class))).
                thenReturn(null);

        //when
        ResponseEntity<String> response = controller.getCurrentTime();

        //then
        assertEquals(500, response.getStatusCode().value());
        assertEquals("Unable to complete thr request at this time", response.getBody());

    }
}