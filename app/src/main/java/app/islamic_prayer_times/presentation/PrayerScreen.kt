package app.islamic_prayer_times.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.islamic_prayer_times.data.model.PrayerCalculationMethod
import app.islamic_prayer_times.data.model.citiesByCountry
import app.islamic_prayer_times.data.model.countries
import app.islamic_prayer_times.data.model.toMap
import app.islamic_prayer_times.presentation.viewmodel.PrayerViewModel

@Composable
fun PrayerScreen(viewModel: PrayerViewModel = hiltViewModel()) {
    var selectedCountry by remember { mutableStateOf(countries[0]) }
    var selectedCity by remember { mutableStateOf(citiesByCountry[selectedCountry.nameEn]!!.first()) }
    var selectedMethod by remember { mutableStateOf<PrayerCalculationMethod?>(null) }

    val prayerState = viewModel.prayerState
    val isLoading = viewModel.isLoading

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEEDEB))
            .padding(16.dp)
            .then(Modifier.systemBarsPadding()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "\uD83D\uDD4C مواعيد الصلاة",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A4A4A)
        )

        Spacer(modifier = Modifier.height(16.dp))

        CountryDropdown(
            selectedCountry = selectedCountry,
            onCountrySelected = {
                selectedCountry = it
                selectedCity = citiesByCountry[it.nameEn]!!.first()
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CityDropdown(
            selectedCity = selectedCity,
            cities = citiesByCountry[selectedCountry.nameEn] ?: emptyList(),
            onCitySelected = { selectedCity = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        MethodDropdown(selectedMethod) {
            selectedMethod = it
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val methodId = selectedMethod?.id ?: 5
                viewModel.fetchPrayerTimes(
                    selectedCity.nameEn,
                    selectedCountry.nameEn,
                    methodId
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A4A4A))
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = Color.White)
            } else {
                Text("عرض المواقيت", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        prayerState?.data?.timings?.let { timings ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    timings.toMap().forEach { (name, time) ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = time, fontWeight = FontWeight.Bold)
                            Text(text = name, fontWeight = FontWeight.Medium)
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}

