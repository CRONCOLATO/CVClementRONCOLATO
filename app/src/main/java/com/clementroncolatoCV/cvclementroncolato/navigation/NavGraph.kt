package com.clementroncolatoCV.cvclementroncolato.navigation

sealed class Screen(val route: String){
    object Accueil : Screen("Accueil")
    object Experiences : Screen("Experiences")
    object Competences : Screen("Competences")
    object Contact : Screen("Contacts")

    object Detail: Screen("details/{title}"){
        fun createRoute(title: String) = "details/$title"
    }

}