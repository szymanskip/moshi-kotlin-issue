package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.time.LocalDateTime

data class Model(
    val id: String,
    val date: LocalDateTime? = null,
)

class MainActivity : Activity() {

    private val moshi: Moshi = Moshi.Builder()
        .add(LocalDateTimeAdapter())
        .add(KotlinJsonAdapterFactory())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val modelObject = Model("123", LocalDateTime.now())

        moshi.adapter<Model>(modelObject::class.java)
            .toJson(modelObject)
    }
}
