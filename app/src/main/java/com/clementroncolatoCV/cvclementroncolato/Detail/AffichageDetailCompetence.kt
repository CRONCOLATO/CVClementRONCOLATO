package com.clementroncolatoCV.cvclementroncolato.details

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.clementroncolatoCV.cvclementroncolato.Fonction.CercleProgression
import com.clementroncolatoCV.cvclementroncolato.Fonction.NiveauRemplissage
import kotlinx.coroutines.launch
import com.clementroncolatoCV.cvclementroncolato.data.Competence

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AffichageDetailCompetence(
    competence: Competence,
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
                painterResource(id = competence.logo),
                contentDescription = "Logo Compétence",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = competence.title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        competence.description.split("\n").forEach { line ->
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(bottom = 4.dp)
            ) {
                Text(
                    text = line,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ✅ Ajout du niveau de maîtrise sous forme de 5 cercles
        Text(
            text = "Niveau de maîtrise :",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        NiveauRemplissage(competence.mastery)

        Spacer(modifier = Modifier.height(8.dp))

        // ✅ Indications sous les cercles
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Notions de base",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).fillMaxWidth().align(Alignment.CenterVertically),
                maxLines = 2
            )
            Text(
                text = "Autonome",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).fillMaxWidth().align(Alignment.CenterVertically),
                maxLines = 2
            )
            Text(
                text = "Maîtrise sans être expert",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).fillMaxWidth().align(Alignment.CenterVertically),
                maxLines = 2
            )
        }
    }
    Spacer(modifier = Modifier.height(64.dp))
}





