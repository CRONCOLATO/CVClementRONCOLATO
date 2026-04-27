package com.clementroncolatoCV.cvclementroncolato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.clementroncolatoCV.cvclementroncolato.navigation.BottomNavigationBar
import com.clementroncolatoCV.cvclementroncolato.navigation.NavigationGraph
import com.clementroncolatoCV.cvclementroncolato.ui.theme.Background
import com.clementroncolatoCV.cvclementroncolato.ui.theme.CVClémentRONCOLATOTheme
import androidx.compose.foundation.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CVClémentRONCOLATOTheme {
                val navController = rememberNavController()
                val pagerState = rememberPagerState(initialPage = 0, pageCount = { 5 })

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(pagerState) }
                ) { innerPadding ->
                    Box {
                        Background()

                        NavigationGraph(
                            navController = navController,
                            pagerState = pagerState,
                            modifier = Modifier.padding(innerPadding)
                        )

                    }
                }
            }
        }
    }
}
