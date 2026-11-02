package com.example.module2

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.module2.ui.theme.Module2Theme

// Задание 1: приветствие с nullable-параметром.
@Composable
fun Hello(name: String?) {
    Text(text = if (name == null) "Имя не задано" else "Привет, $name!")
}

@Preview(showBackground = true, name = "Имя задано")
@Composable
fun HelloPreview() {
    Module2Theme { Hello("Виктор") }
}

@Preview(showBackground = true, name = "Имя равно null")
@Composable
fun HelloNullPreview() {
    Module2Theme { Hello(null) }
}
