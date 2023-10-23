package com.example.myapplication

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class LocalDateTimeAdapter {

    @FromJson
    fun fromJson(dateTime: String): LocalDateTime? =
        LocalDateTime.parse(
            dateTime,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
        )

    @ToJson
    fun toJson(dateTime: LocalDateTime): String =
        dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
}
