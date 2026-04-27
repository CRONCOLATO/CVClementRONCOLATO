package com.clementroncolatoCV.cvclementroncolato.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.clementroncolatoCV.cvclementroncolato.data.competencesList
import com.clementroncolatoCV.cvclementroncolato.data.experienceList
import com.clementroncolatoCV.cvclementroncolato.details.AffichageDetailExperience
import com.clementroncolatoCV.cvclementroncolato.details.AffichageDetailCompetence
import com.clementroncolatoCV.cvclementroncolato.details.AffichageDetailFonctionnalite

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    title: String,
    pagerState: PagerState,
    previousPage: MutableState<Int>,
    resetExperience: () -> Unit
) {
    val scrollState = rememberScrollState()
    var isVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { isVisible = true }

    val coroutineScope = rememberCoroutineScope()
    var swipeOffset by remember { mutableStateOf(0f) }
    val swipeThreshold = 100f

    // ✅ Déterminer si c'est une expérience, une compétence ou une fonctionnalité
    val experience = experienceList.find { it.title == title }
    val competence = competencesList.find { it.title == title }
    val isFonctionnalites = experience == null && competence == null

    // ✅ Gestion du bouton retour physique (uniquement si ce n'est pas une fonctionnalité)
    if (!isFonctionnalites) {
        BackHandler {
            coroutineScope.launch {
                pagerState.scrollToPage(previousPage.value)
                resetExperience()
            }
        }
    }

    // ✅ Ajout du swipe pour revenir en arrière (uniquement pour expérience et compétence)
    val modifier = if (!isFonctionnalites) {
        Modifier.pointerInput(Unit) {
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
    } else Modifier

    // ✅ Gestion de l'affichage en fonction du type de contenu
    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier) // ✅ Ajout du swipe uniquement si ce n'est pas une fonctionnalité
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            when {
                experience != null -> AffichageDetailExperience(
                    experience = experience,
                    isVisible = isVisible,
                    pagerState,
                    previousPage,
                    resetExperience
                )

                competence != null -> AffichageDetailCompetence(
                    competence = competence,
                    isVisible = isVisible,
                    pagerState,
                    previousPage,
                    resetExperience
                )

                else -> AffichageDetailFonctionnalite()
            }
        }
    }
}
