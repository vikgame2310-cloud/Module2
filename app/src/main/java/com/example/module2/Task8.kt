package com.example.module2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2.ui.theme.Module2Theme

// Задание 8: трекер воды. Используется также в тестах задания 9.
@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }
    var daysCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF415F91)
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { waterCount += 250 }) {
            Text("+250 мл")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (waterCount >= 1500) {
                daysCount++
            } else {
                daysCount = 0
            }
            waterCount = 0
        }) {
            Text("Завершить день")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Дней подряд: $daysCount",
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WaterTrackerPreview() {
    Module2Theme { WaterTracker() }
}
