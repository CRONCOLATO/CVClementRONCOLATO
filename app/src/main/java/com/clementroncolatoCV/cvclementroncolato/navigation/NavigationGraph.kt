package com.clementroncolatoCV.cvclementroncolato.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

import com.clementroncolatoCV.cvclementroncolato.screen.AccueilScreen
import com.clementroncolatoCV.cvclementroncolato.screen.CompetencesScreen
import com.clementroncolatoCV.cvclementroncolato.screen.ContactScreen
import com.clementroncolatoCV.cvclementroncolato.screen.DetailScreen
import com.clementroncolatoCV.cvclementroncolato.screen.ExperiencesScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val pages = listOf(
        Screen.Accueil,
        Screen.Experiences,
        Screen.Competences,
        Screen.Contact,
        Screen.Detail

    )
    val previousPage = remember { mutableStateOf(1) }

    // ✅ Stocke l'expérience/compétence sélectionnée pour `DetailScreen`
    val selectedExperienceCompetence = remember { mutableStateOf("Liste des fonctionnalités") }

    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        when (pages.getOrNull(page)) {
            Screen.Accueil -> AccueilScreen()
            Screen.Experiences -> ExperiencesScreen(
                pagerState,
                selectedExperienceCompetence,
                previousPage
            )
            Screen.Competences -> CompetencesScreen(
                pagerState,
                selectedExperienceCompetence,
                previousPage
            )
            Screen.Contact -> ContactScreen()
            Screen.Detail -> DetailScreen(
                title = selectedExperienceCompetence.value,
                pagerState = pagerState,
                previousPage = previousPage,
                resetExperience = { selectedExperienceCompetence.value = "Liste des fonctionnalités" }
            ) // ✅ Passe la sélection à DetailScreen
            else -> {}
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage != pages.indexOf(Screen.Detail)) {
            selectedExperienceCompetence.value = "Liste des fonctionnalités"
        }
    }

    // ✅ Navigation fluide entre les pages avec `pagerState`
    LaunchedEffect(pagerState.currentPage) {
        val newRoute = pages[pagerState.currentPage].route
        if (navController.currentDestination?.route != newRoute && newRoute != Screen.Detail.route) {
            if (navController.currentBackStackEntry != null) { // Vérifie que le graph est prêt
                navController.navigate(newRoute) {
                    popUpTo(navController.graph.startDestinationId) { inclusive = false }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
}
