package com.example.module2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme

// Задание 2: три Preview одной и той же функции Hello из задания 1.
@Composable
fun Task2Screen() {
    Box(modifier = Modifier.padding(top = 32.dp)) {
        Hello("Виктор")
    }
}

@Preview(
    name = "Portrait",
    showSystemUi = true,
    device = "spec:width=400dp,height=800dp,orientation=portrait"
)
@Composable
fun PortraitPreview() {
    Module2Theme { Task2Screen() }
}

@Preview(
    name = "Landscape",
    showSystemUi = true,
    device = "spec:width=800dp,height=400dp,orientation=landscape"
)
@Composable
fun LandscapePreview() {
    Module2Theme { Task2Screen() }
}

@Preview(
    name = "Round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00,
    device = "spec:width=200dp,height=200dp,isRound=true"
)
@Composable
fun RoundPreview() {
    Module2Theme { Task2Screen() }
}
