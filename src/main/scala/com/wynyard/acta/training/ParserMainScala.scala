package com.wynyard.acta.training

import java.io.{BufferedReader, InputStream, InputStreamReader}
import java.time.LocalDateTime

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wynrs5 on 22/09/2016.
  */
class ParserMainScala {
    private var parsedEvents: ArrayBuffer[ParsedEventScala] = ArrayBuffer()

    private def GetSource(location: String): InputStream = {

        val readData: InputStream = this.getClass.getResourceAsStream(location)
        readData
    }

    @throws[Exception]
    def Parse(location: String): Array[ParsedEventScala] = {
        val readData: InputStream = GetSource(location)
        if (readData == null) throw new Exception("Error occured")

        val stream: BufferedReader = new BufferedReader(new InputStreamReader(readData))

        var isEmpty: Boolean = true

        while (isEmpty) {
            try{
                val line: String = stream.readLine
                if (filter(line)) {
                    val items: Array[String] = line.split(" ") // Space delimited
                    val event: ParsedEventScala = new ParsedEventScala().ConstructAndReturnParsedEvent(items)
                    if (event.timeStamp ne LocalDateTime.MIN) parsedEvents += event
                }
            }
            catch {
                case ex: Exception => {
                    isEmpty = false
                }
            }
        }
        parsedEvents.toArray
    }

    private def filter(line: String): Boolean = {

        if (line.startsWith("date") == true) false else true
    }
}
