package app.islamic_prayer_times.data.remote

import app.islamic_prayer_times.data.model.PrayerTimingsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerApi {

    @GET("timingsByCity")
    suspend fun getPrayerTimings(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int = 5
    ): PrayerTimingsResponse


}