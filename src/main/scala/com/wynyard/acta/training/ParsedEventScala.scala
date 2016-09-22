package com.wynyard.acta.training

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ParsedEventScala {
    private var timeTaken : Option[String]= None

    private var ipAddress: Option[String]= None
    private var username: Option[String]= None
    private var status: String = ""
    var timeStamp: LocalDateTime = LocalDateTime.MIN
    var dateTime: String = ""

    /**
      * Accepts parsed strings from current line and converts into a valid ParsedEventScala
      * @param parsedItems String of arrays
      * @return ParsedEventScala
      */
    def ConstructAndReturnParsedEvent(parsedItems: Array[String]): ParsedEventScala = {
//        var i: Int = 0
        for ((singleItem, counter) <- parsedItems.zipWithIndex){
            counter match {
                case 0 => dateTime =  singleItem
                case 1 => {
                    dateTime += " " +   singleItem
                    timeStamp = TryParseDateTime(dateTime)
                }
                case 2 => timeTaken =  Some(singleItem)
                case 3 => ipAddress =  Some(singleItem)
                case 4 => username =  Some(singleItem)
                case 5 => status =  singleItem
            }
        }
        this
    }

    @throws[Exception]
    private def TryParseDateTime(dateTime: String): LocalDateTime = {
        val dateTimeFormatTobeUsed: String = "yyyy-MM-dd HH:mm:ss"
        try
            LocalDateTime.parse(dateTime.trim, DateTimeFormatter.ofPattern(dateTimeFormatTobeUsed))

        catch {
            case ex: Exception => {
                throw new Exception("Unable to parse date time")
            }
        }
    }
}
