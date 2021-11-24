package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.compose.rally.ui.overview.OverviewBody
import org.junit.Rule
import org.junit.Test

/**
 * Created by Yeji on 2021/11/25.
 */
class OverviewScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun overviewScreen_alertsDisplayed() {
        composeTestRule.setContent {
            OverviewBody()
        }

        // 정확한 테스트를 위해 화면이 다 그려진 뒤 Idle 상태가 되면 테스트를 실행한다.
        // 즉, 화면을 구성중인 경우엔 테스트를 실행하지 않는다.
        // 그런데 Overview에는 infinite flashing animation이 있어 idle 상태가 되지 않기 때문에,
        // 테스트는 진행하지 못하고 timeout으로 실패한다.

        // 첫 번째 방법은 개발자 옵션에서 애니메이션을 off 시킨 뒤 테스트를 진행하는 것이다. (View를 테스트할 때 사용하던 방법)
        // 두 번째 방법은 animationDpAsState 대신 infinite animation을 사용하는 것이다.
        // Infinite animations are a special case that Compose tests understand so they're not going to keep the test busy.
        composeTestRule
            .onNodeWithText("Alerts")
            .assertIsDisplayed()
    }
}