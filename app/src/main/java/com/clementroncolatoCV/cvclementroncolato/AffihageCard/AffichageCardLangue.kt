package com.clementroncolatoCV.cvclementroncolato.AffihageCard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clementroncolatoCV.cvclementroncolato.EmplacementData.LangueParle
import com.clementroncolatoCV.cvclementroncolato.Fonction.NiveauRemplissage
import com.clementroncolatoCV.cvclementroncolato.ui.theme.CustomTheme

@Composable
fun AffichageCardLangue (
    langue : LangueParle
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Column (
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = langue.title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = langue.description,
                style = MaterialTheme.typography.bodyMedium,
                color = CustomTheme.colors.textClassique
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Column (
            modifier = Modifier
                .weight(3f) // ✅ Prend 3/5 de l'espace
                .fillMaxHeight()
                .align(Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            NiveauRemplissage(langue.maitrise)
        }
    }

}