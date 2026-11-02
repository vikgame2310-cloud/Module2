package com.example.module2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme

// Задание 7: два варианта Column и один вариант Row.
@Composable
fun Task7First() {
    Column {
        Text("Имя: Виктор")
        Text("Фамилия: Бондарев")
        Text("Отчество: Артемович")
        Text("Телефон: +7 999 123-45-67")
        Text("Адрес: Москва")
    }
}

@Composable
fun Task7Second() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (i in 1..3) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Имя: Виктор")
                Text("Фамилия: Бондарев")
                Text("Отчество: Артемович")
                Text("Телефон: +7 999 123-45-67")
                Text("Карточка №$i")
            }
        }
    }
}

@Composable
fun Task7Third() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Имя: Виктор")
            Text("Фамилия: Бондарев")
            Text("Отчество: Артемович")
            Text("Телефон: +7 999 123-45-67")
            Text("Адрес: Москва")
        }
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Изображение",
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun Task7() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Task7First()
        Task7Second()
        Task7Third()
    }
}

@Preview(showBackground = true, name = "Column 1")
@Composable
fun PreviewFirst() {
    Task7First()
}

@Preview(showBackground = true, name = "Column 2")
@Composable
fun PreviewSecond() {
    Task7Second()
}

@Preview(showBackground = true, name = "Row")
@Composable
fun PreviewThird() {
    Task7Third()
}
