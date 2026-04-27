package com.clementroncolatoCV.cvclementroncolato.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.ui.graphics.vector.ImageVector

data class Fonctionnalite(
    val title: String,
    val description: String,
    val logo: ImageVector = Icons.Filled.Build, // Icône par défaut
)

val fonctionnalitesList = listOf(
    Fonctionnalite(
        "Optimisation de l'affichage des compétences",
        "Utilisation de LazyColumn et items() pour améliorer la fluidité de l'affichage et éviter de charger toutes les compétences en une seule fois. Chargement dynamique au défilement."
    ),
    Fonctionnalite(
        "Affichage du logo des compétences",
        "Chaque compétence est désormais associée à un logo spécifique, offrant une meilleure lisibilité et une identification rapide."
    ),
    Fonctionnalite(
        "Ajout d’un indicateur de maîtrise",
        "Une notation de maîtrise sur 5 a été ajoutée pour chaque compétence, avec une représentation sous forme de cercles progressifs."
    ),
    Fonctionnalite(
        "Swipe latéral pour navigation",
        "Permet de naviguer entre les différentes pages sans passer par le menu en bas de l'écran. Ce swipe facilite la transition fluide entre les sections de l'application."
    ),
    Fonctionnalite(
        "Swipe retour intelligent",
        "Possibilité de quitter un écran de détail (expérience ou compétence) en effectuant un swipe vers la gauche ou la droite. Ce geste est désactivé pour les fonctionnalités générales afin d’éviter toute confusion."
    ),
    Fonctionnalite(
        "Gestion de l’état des écrans",
        "Sauvegarde l’état des écrans de l’application lors de la navigation pour éviter la perte de données lorsque l’utilisateur revient en arrière. Permet aussi de restaurer la position du scroll et la sélection actuelle."
    ),
    Fonctionnalite(
        "Réinitialisation automatique des données",
        "Lorsqu’un utilisateur quitte un écran de détail (expérience ou compétence), les données de sélection sont automatiquement réinitialisées pour éviter des affichages incorrects lors du retour."
    ),
    Fonctionnalite(
        "Affichage conditionnel des détails",
        "Affichage dynamique des écrans de détails selon la sélection : si l’utilisateur clique sur une expérience, une compétence ou accède directement à l’écran, le contenu affiché s’adapte de manière intelligente."
    ),
    Fonctionnalite(
        "Mode sombre automatique",
        "Détection automatique du mode sombre du système et application d’un thème adapté pour améliorer l’accessibilité et le confort visuel."
    ),
    Fonctionnalite(
        "Animations dynamique",
        "Les animations d'affichage de la page Accueil et du détail des expériences et compétences ont été optimisées pour un affichage dynamique tout en restant fluide."
    ),
    Fonctionnalite(
        "Affichage dynamique des icônes",
        "Les icônes des expériences et compétences sont automatiquement attribuées en fonction de la catégorie sélectionnée. Les fonctionnalités ont un affichage spécifique avec une icône dédiée."
    ),
    Fonctionnalite(
        "QR Code et accès LinkedIn",
        "Affichage d’un QR Code et d’un lien direct vers le profil LinkedIn pour un accès rapide aux informations professionnelles."
    ),
    Fonctionnalite(
        "Navigation fluide par menu",
        "Un menu de navigation en bas de l’écran permet un accès rapide aux principales sections de l’application (Accueil, Expériences, Compétences, Contact)."
    ),
    Fonctionnalite(
        "Scroll optimisé",
        "Optimisation du scroll pour s’assurer que le contenu ne soit jamais masqué par le menu de navigation, améliorant ainsi l’expérience utilisateur."
    ),
    Fonctionnalite(
        "Mise en page adaptative",
        "Mise en page responsive qui ajuste dynamiquement les espacements et tailles en fonction de la taille de l’écran de l’utilisateur."
    ),
    Fonctionnalite(
        "Retour intelligent",
        "Retour dynamique à la page d’origine après consultation des détails d’une expérience ou d’une compétence, garantissant une navigation intuitive et fluide."
    ),
    Fonctionnalite(
        "Animation des cartes",
        "Animations fluides des cartes d’expériences et compétences lors de leur apparition pour un effet visuel agréable et une meilleure lisibilité."
    ),
    Fonctionnalite(
        "Affichage des informations détaillées",
        "Chaque expérience et compétence est affichée sous forme de liste détaillée avec un format clair et structuré."
    ),
    Fonctionnalite(
        "Envoi d’e-mail depuis l’application",
        "Permet d’ouvrir directement l’application d’e-mail du téléphone pour envoyer un message professionnel en un clic."
    )
)
