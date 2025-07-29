package app.islamic_prayer_times.data.model

data class Country(val nameAr: String, val nameEn: String, val flag: String)
data class City(val nameAr: String, val nameEn: String)

val countries = listOf(
    Country("مصر", "Egypt", "🇪🇬"),
    Country("السعودية", "Saudi Arabia", "🇸🇦"),
    Country("الإمارات", "United Arab Emirates", "🇦🇪"),
    Country("المغرب", "Morocco", "🇲🇦"),
    Country("الجزائر", "Algeria", "🇩🇿"),
    Country("العراق", "Iraq", "🇮🇶"),
    Country("تركيا", "Turkey", "🇹🇷"),
    Country("الأردن", "Jordan", "🇯🇴"),
    Country("تونس", "Tunisia", "🇹🇳"),
    Country("قطر", "Qatar", "🇶🇦"),
    Country("عمان", "Oman", "🇴🇲"),
    Country("الكويت", "Kuwait", "🇰🇼"),
    Country("لبنان", "Lebanon", "🇱🇧"),
    Country("السودان", "Sudan", "🇸🇩"),
    Country("البحرين", "Bahrain", "🇧🇭")
)

val citiesByCountry = mapOf(
    "Egypt" to listOf(
        City("القاهرة", "Cairo"),
        City("الإسكندرية", "Alexandria"),
        City("أسوان", "Aswan")
    ),
    "Saudi Arabia" to listOf(
        City("مكة", "Mecca"),
        City("الرياض", "Riyadh"),
        City("المدينة", "Medina")
    ),
    "United Arab Emirates" to listOf(
        City("دبي", "Dubai"),
        City("أبو ظبي", "Abu Dhabi"),
        City("الشارقة", "Sharjah")
    ),
    "Morocco" to listOf(
        City("الرباط", "Rabat"),
        City("الدار البيضاء", "Casablanca"),
        City("مراكش", "Marrakesh")
    ),
    "Algeria" to listOf(
        City("الجزائر", "Algiers"),
        City("وهران", "Oran")
    ),
    "Iraq" to listOf(
        City("بغداد", "Baghdad"),
        City("الموصل", "Mosul")
    ),
    "Turkey" to listOf(
        City("إسطنبول", "Istanbul"),
        City("أنقرة", "Ankara")
    ),
    "Jordan" to listOf(
        City("عمان", "Amman"),
        City("الزرقاء", "Zarqa")
    ),
    "Tunisia" to listOf(
        City("تونس", "Tunis"),
        City("صفاقس", "Sfax")
    ),
    "Qatar" to listOf(
        City("الدوحة", "Doha")
    ),
    "Oman" to listOf(
        City("مسقط", "Muscat")
    ),
    "Kuwait" to listOf(
        City("مدينة الكويت", "Kuwait City")
    ),
    "Lebanon" to listOf(
        City("بيروت", "Beirut")
    ),
    "Sudan" to listOf(
        City("الخرطوم", "Khartoum")
    ),
    "Bahrain" to listOf(
        City("المنامة", "Manama")
    )
)
