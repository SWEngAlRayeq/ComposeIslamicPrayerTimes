package app.islamic_prayer_times.data.model


data class PrayerTimingsResponse(
    val data: PrayerData
)

data class PrayerData(
    val timings: Timings,
    val date: DateInfo
)

data class Timings(
    val Fajr: String,
    val Dhuhr: String,
    val Asr: String,
    val Maghrib: String,
    val Isha: String,
    val Sunrise: String,
    val Sunset: String,
    val Imsak: String,
    val Midnight: String,
    val Firstthird: String,
    val Lastthird: String
)

fun Timings.toMap(): Map<String, String> {
    return mapOf(
        "الفجر" to Fajr,
        "الشروق" to Sunrise,
        "الظهر" to Dhuhr,
        "العصر" to Asr,
        "المغرب" to Maghrib,
        "العشاء" to Isha,
        "الإمساك" to Imsak,
        "الغروب" to Sunset,
        "منتصف الليل" to Midnight,
        "الثلث الأول" to Firstthird,
        "الثلث الأخير" to Lastthird
    )
}

data class DateInfo(
    val gregorian: GregorianDate,
    val hijri: HijriDate
)

data class GregorianDate(
    val date: String,
)

data class HijriDate(
    val date: String
)