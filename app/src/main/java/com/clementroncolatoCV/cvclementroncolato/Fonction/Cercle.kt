package com.clementroncolatoCV.cvclementroncolato.Fonction

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CercleProgression(remplissage: Float) {
    val primaryColor = MaterialTheme.colorScheme.primary // ✅ Extraction de la couleur avant Canvas
    val backgroundColor = Color.Gray.copy(alpha = 0.3f)

    Canvas(
        modifier = Modifier.size(24.dp)
    ) {
        Offset(size.width / 2, size.height / 2)
        val radius = size.width / 2

        // ✅ Cercle de fond (grisé)
        drawCircle(
            color = backgroundColor,
            radius = radius
        )

        // ✅ Cercle rempli (partiel ou complet)
        if (remplissage > 0) {
            drawArc(
                color = primaryColor, // ✅ Utilisation de la variable définie en dehors du Canvas
                startAngle = 90f,
                sweepAngle = 360 * remplissage,
                useCenter = true,
                size = size,
                topLeft = Offset.Zero
            )
        }
    }
}