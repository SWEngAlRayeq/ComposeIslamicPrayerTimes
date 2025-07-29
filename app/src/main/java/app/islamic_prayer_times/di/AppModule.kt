package app.islamic_prayer_times.di

import app.islamic_prayer_times.data.remote.PrayerApi
import app.islamic_prayer_times.domain.repo.PrayerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private val BASE_URL = "https://api.aladhan.com/v1/"

    @Provides
    @Singleton
    fun provideApi(): PrayerApi {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PrayerApi::class.java)
    }



    @Provides
    @Singleton
    fun providePrayerRepository(api: PrayerApi): PrayerRepository {
        return PrayerRepository(api)
    }


}