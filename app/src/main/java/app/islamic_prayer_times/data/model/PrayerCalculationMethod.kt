package app.islamic_prayer_times.data.model

data class PrayerCalculationMethod(
    val id: Int,
    val name: String,
    val description: String
)

val calculationMethods = listOf(
    PrayerCalculationMethod(0, "الشيعة", "Shia Ithna-Ashari"),
    PrayerCalculationMethod(1, "جامعة كراتشي", "University of Islamic Sciences, Karachi"),
    PrayerCalculationMethod(2, "ISNA", "Islamic Society of North America"),
    PrayerCalculationMethod(3, "رابطة العالم الإسلامي", "Muslim World League"),
    PrayerCalculationMethod(4, "أم القرى", "Umm Al-Qura University, Makkah"),
    PrayerCalculationMethod(5, "الهيئة المصرية", "Egyptian General Authority of Survey"),
    PrayerCalculationMethod(8, "الخليج", "Gulf Region"),
    PrayerCalculationMethod(12, "فرنسا", "Union Organization islamic de France"),
    PrayerCalculationMethod(13, "تركيا", "Diyanet İşleri Başkanlığı")
)
