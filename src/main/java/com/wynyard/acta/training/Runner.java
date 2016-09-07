package com.wynyard.acta.training;

public class Runner {

    public static void main(String [] args) throws Exception {
        String fileLocation = "/AccessLogs.txt";
        ParserMain main = new ParserMain();
        main.Parse(fileLocation);
    }
}
