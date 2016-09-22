package com.wynyard.acta.training

import org.scalatest.FunSuite

/**
  * Created by wynrs5 on 22/09/2016.
  */
class ParserMainScalaTest extends FunSuite {

    test("testParse") {
        val fileLocation: String = "/AccessLogs.txt"
        val main: ParserMainScala = new ParserMainScala
        val allParsedEvents = main.Parse(fileLocation)
        assert(allParsedEvents.length == 16)
        assert(allParsedEvents(0).isInstanceOf[ParsedEventScala])
    }
}
