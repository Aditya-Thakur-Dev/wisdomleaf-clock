package com.assesment.wisdomleafspeakingclock.controllers;

import com.assesment.wisdomleafspeakingclock.services.ClockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.time.Clock;
import java.time.LocalTime;
import java.util.Objects;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class MainController {
    private final ClockService service;

    @GetMapping(path = "/getTime")
    public ResponseEntity<String> getCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        String currTime = service.returnCurrentTimeInWords(currentTime);
        if(currTime !=null){
            return new ResponseEntity<>(currTime, HttpStatus.OK);
        }
        return new ResponseEntity<>("Unable to complete thr request at this time",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
