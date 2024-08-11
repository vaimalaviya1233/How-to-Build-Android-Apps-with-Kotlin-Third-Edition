package com.example.tvguide

import android.app.Application
import com.example.tvguide.database.TVShowDatabase
import com.example.tvguide.network.TVShowService

class TVShowApplication : Application() {
    private val apiKey = "your_api_key_here"

    private val tvShowService: TVShowService by lazy {
        TVShowService(apiKey = apiKey)
    }

    lateinit var tvShowRepository: TVShowRepository

    override fun onCreate() {
        super.onCreate()

        val tvShowDatabase = TVShowDatabase.getInstance(applicationContext)

        tvShowRepository =
            TVShowRepository(tvShowService = tvShowService, tvShowDatabase = tvShowDatabase)
    }
}