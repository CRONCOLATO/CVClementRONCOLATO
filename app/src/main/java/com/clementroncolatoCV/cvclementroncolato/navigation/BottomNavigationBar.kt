package com.clementroncolatoCV.cvclementroncolato.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavigationBar(pagerState: PagerState) {
    val items = listOf(
        Screen.Accueil to Icons.Default.Home,
        Screen.Experiences to Icons.Default.Work,
        Screen.Competences to Icons.Default.School,
        Screen.Contact to Icons.Default.Email
    )

    val coroutineScope = rememberCoroutineScope()

    NavigationBar {
        items.forEachIndexed { index, (screen, icon) ->

            NavigationBarItem(
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index) // Change la page en scrollant
                    }
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = screen.route,
                        modifier = Modifier.size(24.dp) // Ajuste la taille de l'icône
                    )
                },
                label = {
                    BoxWithConstraints(
                        modifier = Modifier.fillMaxWidth() // ✅ Permet de connaître la largeur dispo
                    ) {
                        val dynamicFontSize = when {
                            maxWidth < 50.dp -> 8.sp // ✅ Réduction de la police si très petit
                            maxWidth < 65.dp -> 10.sp // ✅ Taille intermédiaire
                            else -> 12.sp // ✅ Taille normale
                        }

                        Text(
                            text = screen.route,
                            style = TextStyle(
                                fontSize = dynamicFontSize // ✅ Ajuste la taille du texte
                            ),
                            textAlign = TextAlign.Center, // ✅ Centre le texte
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 1, // ✅ Toujours sur une seule ligne
                            softWrap = false // ✅ Empêche le retour à la ligne
                        )
                    }
                }
            )
        }
    }
}
