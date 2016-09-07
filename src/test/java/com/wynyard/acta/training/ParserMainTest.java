package com.wynyard.acta.training;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserMainTest {

    @Test
    public void parse() throws Exception {

        String fileLocation = "/AccessLogs.txt";
        ParserMain main = new ParserMain();
        ArrayList<ParsedEvent> events = main.Parse(fileLocation);
        assertThat("Testing type",  events.get(0), instanceOf(ParsedEvent.class));
        assertTrue(events.size() == 16);
    }
}