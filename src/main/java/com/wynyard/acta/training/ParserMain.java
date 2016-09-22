package com.wynyard.acta.training;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParserMain {

    private ArrayList<ParsedEvent> parsedEvents;

    ParserMain(){

        parsedEvents = new ArrayList<>();
    }

    private InputStream GetSource(String location){

        InputStream readData = this.getClass().getResourceAsStream(location);
        return readData;
    }

    public ArrayList<ParsedEvent> Parse(String location) throws Exception {

        InputStream readData = GetSource(location);
        if (readData == null){

            throw new Exception("Error occured");
        }

        BufferedReader stream = new BufferedReader(new InputStreamReader(readData));

        Boolean isEmpty= true;
        while (isEmpty){

            try{

                String line = stream.readLine();
                if(filter(line)){

                    String[] items = line.split(" "); // Space delimited

                    ParsedEvent event = new ParsedEvent().ConstructAndReturnParsedEvent(items);
                    if(event.timeStamp != LocalDateTime.MIN){
                        parsedEvents.add(event);
                    }

                }

            }catch (Exception ex){

                isEmpty = false;
            }
        }
        return parsedEvents;
    }

    private boolean filter(String line){

        return line.startsWith("date") == true ? false : true;
    }

}
