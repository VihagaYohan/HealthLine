package com.techtribeservices.helathline.utils

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass

@Composable
fun ScreenSize(): ScreenSize {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val configuration = LocalConfiguration.current

    // device screen width and screen height
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    // device type
    val type = when(windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> WindowType.COMPACT
        WindowWidthSizeClass.MEDIUM -> WindowType.MEDIUM
        else -> WindowType.EXPANDED
    }

    return ScreenSize(screenHeight, screenWidth, type)
}

enum class WindowType {
    COMPACT, MEDIUM, EXPANDED
}

data class ScreenSize(
    val width: Dp,
    val height: Dp,
    val type: WindowType
)