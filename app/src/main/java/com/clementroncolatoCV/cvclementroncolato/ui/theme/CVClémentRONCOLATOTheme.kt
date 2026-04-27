package com.clementroncolatoCV.cvclementroncolato.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun CVClémentRONCOLATOTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Détecte si le mode sombre est activé
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
            background = Color(0xFF121212),
            surface = Color(0xFF1E1E1E),
            onPrimary = Color.White,
            onBackground = Color.White,
            onSurface = Color.White
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF6200EE),
            background = Color.White,
            surface = Color(0xFFF5F5F5),
            onPrimary = Color.White,
            onBackground = Color.Black,
            onSurface = Color.Black
        )
    }

    val customColors = CustomColors(
        textClassique = if (darkTheme) DarkTextClassique else LightTextClassique
    )

    ProvideCustomColors(customColors) {
        MaterialTheme(
            colorScheme = colors,
            typography = Typography, // Si tu as défini une typographie
            content = content
        )
    }
}


@Immutable
data class CustomColors(
    val textClassique: Color
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(textClassique = LightTextClassique) // Valeur par défaut
}

@Composable
fun ProvideCustomColors(
    colors: CustomColors,
    content: @Composable () -> Unit
) {
    val colorPalette = colors
    CompositionLocalProvider(LocalCustomColors provides colorPalette, content = content)
}

// Accès simplifié à `textClassique`
object CustomTheme {
    val colors: CustomColors
        @Composable
        get() = LocalCustomColors.current
}
