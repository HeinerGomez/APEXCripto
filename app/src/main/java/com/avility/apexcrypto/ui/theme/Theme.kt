package com.avility.apexcrypto.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.avility.shared.ui.constants.black800
import com.avility.shared.ui.constants.indigo500
import com.avility.shared.ui.constants.indigo700
import com.avility.shared.ui.constants.indigo900
import com.avility.shared.ui.constants.orange500
import com.avility.shared.ui.constants.pink500
import com.avility.shared.ui.constants.white100
import com.avility.shared.ui.constants.white50

private val lightColorScheme = lightColorScheme(
    primary = orange500,
    secondary = pink500,
    background = indigo900,
    surface = indigo700,
    primaryContainer = white50,
    onPrimary = black800,
    onSecondary = white100,
    onBackground = white50,
    onSurface = black800,
    onPrimaryContainer = black800,
    tertiary = pink500,
)

@Composable
fun APEXTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> lightColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = indigo900.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}