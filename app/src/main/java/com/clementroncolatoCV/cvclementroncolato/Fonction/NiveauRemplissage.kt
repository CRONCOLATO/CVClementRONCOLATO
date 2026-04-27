package com.clementroncolatoCV.cvclementroncolato.Fonction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NiveauRemplissage(maitrise: Float) {
    val totalCercles = 5
    val cercleRempli = maitrise.toInt()
    val cerclePartiel = maitrise - cercleRempli

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until totalCercles) {
            val fillRatio = when {
                i < cercleRempli -> 1f // Cercle complètement rempli
                i == cercleRempli && cerclePartiel > 0 -> cerclePartiel // Cercle partiellement rempli
                else -> 0f // Cercle vide
            }

            CercleProgression(fillRatio)
            if (i < totalCercles - 1) Spacer(modifier = Modifier.width(8.dp))
        }
    }
}