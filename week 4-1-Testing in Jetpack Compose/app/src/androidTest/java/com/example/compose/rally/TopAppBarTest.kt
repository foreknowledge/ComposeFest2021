package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

/**
 * Created by Yeji on 2021/11/22.
 */
class TopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest_currentTabSelected() {
        composeTestRule.setContent {
            val allScreen = RallyScreen.values().toList()
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreen,
                    onTabSelected = {},
                    currentScreen = RallyScreen.Accounts
                )
            }
        }
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        // UnmergedTree에서 원하는 element를 찾는 방법
        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.toUpperCase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }
}