package app.islamic_prayer_times.domain.repo

import app.islamic_prayer_times.data.remote.PrayerApi
import javax.inject.Inject

class PrayerRepository @Inject constructor(
    private val prayerApi: PrayerApi
) {
    suspend fun getPrayerTimings(city: String, country: String, method: Int) =
        prayerApi.getPrayerTimings(city, country, method)


}