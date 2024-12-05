package com.example.financetracker.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Define colors directly with Color() and hex values
val Purple80 = Color(0xFF9B4D96)
val PurpleGrey80 = Color(0xFF6A4D7B)
val Pink80 = Color(0xFFF06292)

val Purple40 = Color(0xFF9C27B0)
val PurpleGrey40 = Color(0xFF6200EE)
val Pink40 = Color(0xFFF06292)

// Define the Dark Color Scheme
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Define the Light Color Scheme
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun FinanceTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Get the current context
    val context = LocalContext.current

    // Select the color scheme based on system theme and dynamic color support
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            // Use dynamic color scheme for devices supporting it (Android 12+)
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Apply MaterialTheme with selected color scheme and typography
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,  // Use the custom Typography here
        content = content  // The content will be wrapped with this theme
    )
}
