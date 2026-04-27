package com.clementroncolatoCV.cvclementroncolato.details

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.unit.sp
import com.clementroncolatoCV.cvclementroncolato.data.Experience
import com.clementroncolatoCV.cvclementroncolato.ui.theme.CustomTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AffichageDetailExperience(
    experience: Experience,
    isVisible: Boolean,
    pagerState: PagerState,
    previousPage: MutableState<Int>,
    resetExperience: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var swipeOffset by remember { mutableStateOf(0f) }
    val swipeThreshold = 100f

    // ✅ Gestion du bouton retour physique
    BackHandler {
        coroutineScope.launch {
            pagerState.scrollToPage(previousPage.value)
            resetExperience()
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    swipeOffset += dragAmount
                    if (swipeOffset > swipeThreshold || swipeOffset < -swipeThreshold) {
                        coroutineScope.launch {
                            pagerState.scrollToPage(previousPage.value)
                            resetExperience()
                        }
                    }
                }
            }
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Image(
                painterResource(id = experience.logo),
                contentDescription = "Logo Expérience",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = experience.title,
            fontWeight = FontWeight.Bold,
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

        Spacer(modifier = Modifier.height(16.dp))

        experience.description.split("\n").forEach { line ->
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(bottom = 4.dp)
            ) {
                Text(
                    text = "•",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = line,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(64.dp))
}
