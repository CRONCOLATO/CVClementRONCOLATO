package com.clementroncolatoCV.cvclementroncolato.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clementroncolatoCV.cvclementroncolato.AffihageCard.AffichageCardCompetence
import com.clementroncolatoCV.cvclementroncolato.data.competencesList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CompetencesScreen(
    pagerState: PagerState,
    selectedCompetence: MutableState<String>,
    previousPage: MutableState<Int>
) {
    val sortedCompetences = competencesList.sortedByDescending { it.mastery }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.School,
                contentDescription = "Icône Skills",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Mes compétences",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espacement optimisé
        ) {
            items(sortedCompetences) { competence ->
                AffichageCardCompetence(
                    competence = competence,
                    pagerState = pagerState,
                    selectedCompetence = selectedCompetence,
                    previousPage = previousPage
                )
            }
        }
    }



}
