package com.example.module2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme

// Задание 5: серый контейнер и круг с инициалами.
@Composable
fun Task5() {
    Column(modifier = Modifier.fillMaxSize().padding(top = 32.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .background(Color(0xFFFF5722), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("ВА")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task5Preview() {
    Module2Theme { Task5() }
}
