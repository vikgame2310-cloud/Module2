
package com.example.module2

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    // Тест 1. Добавление воды
    @Test
    fun testAddWater() {
        rule.onNodeWithText("0 мл").assertIsDisplayed()

        rule.onNodeWithText("+250 мл").performClick()

        rule.onNodeWithText("250 мл").assertIsDisplayed()
    }

    // Тест 2. Завершение дня
    @Test
    fun testFinishDay() {
        repeat(6) {
            rule.onNodeWithText("+250 мл").performClick()
        }

        rule.onNodeWithText("1500 мл").assertIsDisplayed()

        rule.onNodeWithText("Завершить день").performClick()

        rule.onNodeWithText("0 мл").assertIsDisplayed()
        rule.onNodeWithText("Дней подряд: 1").assertIsDisplayed()
    }

    // Тест 3. Счётчик дней подряд
    @Test
    fun testDaysCount() {
        rule.onNodeWithText("Дней подряд: 0")
            .assertIsDisplayed()

        repeat(6) {
            rule.onNodeWithText("+250 мл").performClick()
        }

        rule.onNodeWithText("Завершить день").performClick()

        rule.onNodeWithText("Дней подряд: 1")
            .assertIsDisplayed()

        // Следующий день: выпито меньше 1500 мл
        rule.onNodeWithText("+250 мл").performClick()
        rule.onNodeWithText("Завершить день").performClick()

        rule.onNodeWithText("Дней подряд: 0")
            .assertIsDisplayed()
    }
}
