package com.example.module2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme

// Задание 6: векторное изображение circle.xml.
@Composable
fun Task6First() {
    Box(
        modifier = Modifier
            .width(240.dp)
            .height(120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Оранжевый круг"
        )
    }
}

@Composable
fun Task6Second() {
    Box(
        modifier = Modifier
            .width(240.dp)
            .height(120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Фиолетовый круг",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color.Magenta)
        )
    }
}

@Composable
fun Task6() {
    Column(
        modifier = Modifier.padding(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Task6First()
        Task6Second()
    }
}

@Preview(showBackground = true)
@Composable
fun Task6Preview() {
    Module2Theme { Task6() }
}
