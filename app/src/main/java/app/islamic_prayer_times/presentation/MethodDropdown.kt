package app.islamic_prayer_times.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.islamic_prayer_times.data.model.PrayerCalculationMethod
import app.islamic_prayer_times.data.model.calculationMethods

@Composable
fun MethodDropdown(
    selectedMethod: PrayerCalculationMethod?,
    onMethodSelected: (PrayerCalculationMethod) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl)
    {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFE0E0E0))
                .clickable { expanded = true }
                .padding(16.dp)
        ) {
            Text(
                text = selectedMethod?.name ?: "اختر طريقة الحساب",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E342E)
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                calculationMethods.forEach { method ->
                    DropdownMenuItem(
                        text = {
                            Column {
                                Text(text = method.name, fontWeight = FontWeight.SemiBold)
                                Text(
                                    text = method.description,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                        },
                        onClick = {
                            onMethodSelected(method)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
