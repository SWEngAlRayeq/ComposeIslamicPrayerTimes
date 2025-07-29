package app.islamic_prayer_times.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.islamic_prayer_times.data.model.PrayerTimingsResponse
import app.islamic_prayer_times.domain.repo.PrayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrayerViewModel @Inject constructor(
    private val repository: PrayerRepository
): ViewModel() {

    var prayerState by mutableStateOf<PrayerTimingsResponse?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchPrayerTimes(city: String , country: String , method: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                prayerState = repository.getPrayerTimings(city, country, method)
            } catch (e: Exception) {
                Log.e("PrayerViewModel", "Error fetching times", e)
            }
            isLoading = false
        }
    }

}