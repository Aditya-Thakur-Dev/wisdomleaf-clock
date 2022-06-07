package com.assesment.wisdomleafspeakingclock.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ClockService {

   private final Logger logger = LoggerFactory.getLogger(ClockService.class);
   private final Map<Integer, String> timeInWords = new HashMap(){{
       put(1, "One");
       put(2, "Two");
       put(3, "Three");
       put(4, "Four");
       put(5, "Five");
       put(6, "Six");
       put(7, "Seven");
       put(8, "Eight");
       put(9, "Nine");
       put(10, "Ten");
       put(11, "Eleven");
       put(12, "Twelve");
       put(13, "Thirteen");
       put(14, "Fourteen");
       put(15, "Fifteen");
       put(16, "Sixteen");
       put(17, "Seventeen");
       put(18, "Eighteen");
       put(19, "Nineteen");
       put(20, "Twenty");
       put(21, "Twenty One");
       put(22, "Twenty Two");
       put(23, "Twenty Three");
       put(24, "Twenty Four");
       put(25, "Twenty Five");
       put(26, "Twenty Six");
       put(27, "Twenty Seven");
       put(28, "Twenty Eight");
       put(29, "Twenty Nine");
       put(30, "Thirty");
       put(31, "Thirty One");
       put(32, "Thirty Two");
       put(33, "Thirty Three");
       put(34, "Thirty Four");
       put(35, "Thirty Five");
       put(36, "Thirty Six");
       put(37, "Thirty Seven");
       put(38, "Thirty Eight");
       put(39, "Thirty Nine");
       put(40, "Forty");
       put(41, "Forty One");
       put(42, "Forty Two");
       put(43, "Forty Three");
       put(44, "Forty Four");
       put(45, "Forty Five");
       put(46, "Forty Six");
       put(47, "Forty Seven");
       put(48, "Forty Eight");
       put(49, "Forty Nine");
       put(50, "Fifty");
       put(52, "Fifty One");
       put(53, "Fifty Two");
       put(54, "Fifty Three");
       put(55, "Fifty Four");
       put(56, "Fifty Five");
       put(57, "Fifty Six");
       put(58, "Fifty Seven");
       put(59, "Fifty Eight");
       put(60, "Sixty");
    }};

    public String returnCurrentTimeInWords(LocalTime currentTime){
       if (Objects.nonNull(currentTime)) {
          if(currentTime.equals(LocalTime.MIDNIGHT)){
             logger.info("It is Midnight");
             return "it's Midnight";
          } else if(currentTime.equals(LocalTime.NOON)){
             logger.info("It is Noon");
             return "it's Noon";
          }
          String hour = timeInWords.get(currentTime.getHour());
          String minutes = timeInWords.get(currentTime.getMinute());
          logger.info("It is " + hour + " "+ minutes);
          return "it's " + hour + " " + minutes;
       }
       logger.error("The LocalTime object is null");
       return null;
    }
}
