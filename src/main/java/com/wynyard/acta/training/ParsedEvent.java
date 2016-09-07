package com.wynyard.acta.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParsedEvent {

    String timeTaken, ipAddress, username, status;
    LocalDateTime timeStamp = LocalDateTime.MIN;

    public ParsedEvent ConstructAndReturnParsedEvent(String[] parsedItems){

        String dateTime = "";

        for (int i =0; i < parsedItems.length; i ++) {
            switch (i){
                case 0: dateTime = parsedItems[i];
                    break;
                case 1: {
                    dateTime += " " + parsedItems[i];
                    try {
                        timeStamp = TryParseDateTime(dateTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return this;
                    }
                }
                    break;
                case 2: timeTaken = parsedItems[i];
                    break;
                case 3: ipAddress = parsedItems[i];
                    break;
                case 4: username = parsedItems[i];
                    break;
                case 5: status = parsedItems[i];
                    break;
            }
        }
        return this;
    }

    private LocalDateTime TryParseDateTime(String dateTime) throws Exception {

        String dateTimeFormatTobeUsed = "yyyy-MM-dd HH:mm:ss";
        try {

            return LocalDateTime.parse(dateTime.trim(), DateTimeFormatter.ofPattern(dateTimeFormatTobeUsed));

        } catch (Exception ex) {

            throw new Exception("Unable to parse date time");
        }
    }
}
