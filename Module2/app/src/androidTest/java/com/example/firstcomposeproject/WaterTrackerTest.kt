package com.example.firstcomposeproject

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertExists
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent { WaterTracker() }
    }

    // 1. Кнопка добавления жидкости
    @Test
    fun addButton_exists_and_increasesWater() {
        composeTestRule.onNodeWithText("+250 мл")
            .assertExists().assertHasClickAction()
        composeTestRule.onNodeWithText("0 мл").assertExists()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("500 мл").assertExists()
    }

    // 2. Кнопка «Завершить день» сбрасывает счётчик воды
    @Test
    fun finishDayButton_exists_and_resetsWater() {
        composeTestRule.onNodeWithText("Завершить день")
            .assertExists().assertHasClickAction()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()

        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertExists()
    }

    // 3. Текст со счётчиком дней подряд
    @Test
    fun streakText_updatesCorrectly() {
        composeTestRule
            .onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertExists()

        // день с нормой: 6 x 250 = 1500
        repeat(6) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule
            .onNodeWithText("Дней подряд с 1500 мл и больше: 1").assertExists()

        // день без нормы: серия обнуляется
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule
            .onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertExists()
    }
}
