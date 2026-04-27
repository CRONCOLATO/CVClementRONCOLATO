package com.clementroncolatoCV.cvclementroncolato.AffihageCard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clementroncolatoCV.cvclementroncolato.data.Experience
import com.clementroncolatoCV.cvclementroncolato.ui.theme.CustomTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AffichageCardExperience(
    experience: Experience,
    pagerState: PagerState,
    selectedExperience: MutableState<String>, // ✅ Stocke l'expérience sélectionnée
    previousPage: MutableState<Int>
) {
    var isVisible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    val coroutineScope = rememberCoroutineScope()


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                coroutineScope.launch {
                    previousPage.value = pagerState.currentPage
                    selectedExperience.value = experience.title
                    pagerState.scrollToPage(4) // ✅ Va à `DetailScreen`
                }
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                contentAlignment = Alignment.Center)
            {
                Image(
                    painterResource(id = experience.logo),
                    contentDescription = "Logo Entreprise",
                    modifier = Modifier.size(32.dp)

                )

            }
            Column (modifier = Modifier.padding(8.dp)){
                Text(
                    text = experience.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = experience.company,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = experience.date,
                    fontSize = 14.sp,
                    color = CustomTheme.colors.textClassique
                )
            }
        }

    }

}
