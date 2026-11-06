package com.example.firstcomposeproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val primaryColor = Color(0xFF41649A)
private val secondaryColor = Color(0xFF555D6E)
private val buttonTextColor = Color.White

@Composable
fun WaterTracker() {
    var waterCount by remember { mutableStateOf(0) }
    var streakDays by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += 250 }
        ) {
            Text("+250 мл", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                 color = buttonTextColor)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = {
                streakDays = if (waterCount >= 1500) streakDays + 1 else 0
                waterCount = 0
            }
        ) {
            Text("Завершить день", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                 color = buttonTextColor)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text("Дней подряд с 1500 мл и больше: $streakDays", fontSize = 16.sp)
    }
}

@Preview(showSystemUi = true)
@Composable
fun WaterTrackerPreview() {
    WaterTracker()
}
