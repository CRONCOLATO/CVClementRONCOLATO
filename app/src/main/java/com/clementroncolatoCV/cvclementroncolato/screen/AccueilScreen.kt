package com.clementroncolatoCV.cvclementroncolato.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clementroncolatoCV.cvclementroncolato.AffihageCard.AffichageCardLangue
import com.clementroncolatoCV.cvclementroncolato.EmplacementData.LangueList
import com.clementroncolatoCV.cvclementroncolato.R
import com.clementroncolatoCV.cvclementroncolato.ui.theme.CustomTheme
import java.util.Calendar

@Composable
fun AccueilScreen() {
    val scrollState = rememberScrollState()

    var isVisible by remember {
        mutableStateOf(false)
    }

    val age = remember { calculateAge(2001, Calendar.JANUARY, 21) }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AnimatedVisibility(visible = isVisible, enter = fadeIn() + scaleIn()) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(id = R.drawable.profile_picture),
                    contentDescription = "photo de profil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(240.dp) // ✅ Évite que l'image dépasse du cadre
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = isVisible, enter = slideInVertically() + fadeIn()) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = "Clément RONCOLATO",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Développeur Android & Web",
                    style = MaterialTheme.typography.bodyMedium,
                    color = CustomTheme.colors.textClassique
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = isVisible, enter = slideInVertically() + fadeIn()) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                    contentAlignment = Alignment.Center)
                {
                    Image(
                        painterResource(id = R.drawable.logo_epf),
                        contentDescription = "image EPF",
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "EPF école d'ingénieur, Promo 2025",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Majeur Ingénieurie Numérique",
                        style = MaterialTheme.typography.bodyMedium,
                        color = CustomTheme.colors.textClassique
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = isVisible, enter = slideInVertically() + fadeIn()) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Filled.Cake,
                    contentDescription = "icone d'anniversaire",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "21 janvier 2001, " + age + " ans",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(visible = isVisible, enter = slideInVertically() + fadeIn()) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Row (){
                    Icon(
                        imageVector = Icons.Filled.Language,
                        contentDescription = "icone Langues",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Langues",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))


                Column (
                    modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    LangueList.forEach{
                        LangueParle ->
                        AffichageCardLangue(LangueParle)
                    }
                }



            }
        }



        Spacer(modifier = Modifier.height(80.dp))
    }

}

private fun calculateAge(year: Int, month: Int, day: Int): Int {
    val today = Calendar.getInstance()
    val birthday = Calendar.getInstance().apply {
        set(year, month, day)
    }

    var age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR)
    if (today.get(Calendar.DAY_OF_YEAR) < birthday.get(Calendar.DAY_OF_YEAR)) {
        age--
    }
    return age
}
