package com.clementroncolatoCV.cvclementroncolato.data

import com.clementroncolatoCV.cvclementroncolato.R

data class Experience(
    val title: String,
    val company: String,
    val date: String,
    val description: String,
    val logo: Int
)

// Liste des expériences centralisée
val experienceList = listOf(
    Experience(
        title = "Stagiaire Data Analyst",
        company = "IN Groupe",
        date = "01/09/2024 - 24/01/2025",
        description = "Collecte et intégration de données multi-sources en Python pour la création de dashboards interactifs sous ElasticSearch.\n" +
                "Automatisation des processus d'extraction et de transformation des données pour optimiser l'analyse en utilisant Jenkins.",
        logo = R.drawable.in_groupe_logo
    ),
    Experience(
        title = "Développeur Web E-commerce",
        company = "EPF Projets",
        date = "01/05/2024 - 01/12/2024",
        description = "Développement et déploiement d’un site e-commerce sous PrestaShop pour une start-up.\n" +
                "Intégration de fonctionnalités et optimisation de l’expérience utilisateur.",
        logo = R.drawable.epf_projets_logo
    ),
    Experience(
        title = "Stagiaire IT Project Officer",
        company = "CACEIS",
        date = "15/09/2023 - 14/01/2024",
        description = "Gestion de projet : coordination du renouvellement d’équipements IT à l’international.\n" +
                "Automatisation des tâches récurrentes en utilisant VBA et PowerShell pour améliorer l’efficacité de mon équipe.\n" +
                "Résolution de problèmes techniques.",

        logo = R.drawable.caceis_logo
    ),
    Experience(
        title = "Projet de semestre 3ème année",
        company = "Festilight",
        date = "06/2023",
        description = "Projet de semestre pour l’entreprise Festilight en 2023. Choix de matériaux recyclables et imprimables en 3D, dimensionnement et validation des modèles avec CATIA V5.",
        logo = R.drawable.festilight_logo
    ),
    Experience(
        title = "Gestionnaire de commandes",
        company = "Castorama",
        date = "01/07/2021 - 12/08/2021",
        description = "Suivi des commandes et gestion des stocks.",
        logo = R.drawable.castorama_logo
    ),
    Experience(
        title = "Stage Ouvrier",
        company = "Saint-Gobain PAM",
        date = "06/2020 - 07/2020",
        description = "Découverte du secteur industriel et gestion des équipements.",
        logo = R.drawable.saint_gobain_pam_logo
    )
)
