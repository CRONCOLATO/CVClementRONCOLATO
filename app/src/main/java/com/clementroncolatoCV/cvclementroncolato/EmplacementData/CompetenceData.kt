package com.clementroncolatoCV.cvclementroncolato.data

import com.clementroncolatoCV.cvclementroncolato.R

data class Competence(
    val title: String,
    val description: String,
    val logo: Int,
    val mastery: Float // ✅ Ajout de l'indicateur de maîtrise (sur 5)
)

val competencesList = listOf(
    // ✅ Compétences principales (4.5/5)
    Competence(
        "Kotlin",
        "Langage de programmation moderne utilisé principalement pour le développement Android.",
        R.drawable.kotlin_logo,
        4.5f
    ),
    Competence(
        "Java",
        "Langage de programmation orienté objet largement utilisé pour le développement d'applications.",
        R.drawable.java_logo,
        4.5f
    ),
    Competence(
        "Python",
        "Langage de programmation polyvalent utilisé pour l'IA, la data science et le développement web.",
        R.drawable.python_logo,
        4.5f
    ),
    Competence(
        "Docker",
        "Plateforme de conteneurisation permettant de déployer des applications dans des environnements isolés.",
        R.drawable.docker_logo,
        4.5f
    ),
    Competence(
        "Git",
        "Système de gestion de versions utilisé pour suivre les modifications du code source.",
        R.drawable.git_logo,
        4.5f
    ),
    Competence(
        "VBA",
        "Langage de programmation utilisé dans les applications Microsoft Office pour l'automatisation des tâches.",
        R.drawable.vba_logo,
        4.5f
    ),
    Competence(
        "VS Code",
        "Environnement de développement léger et performant adapté à plusieurs langages de programmation.",
        R.drawable.vs_code_logo,
        4.5f
    ),
    Competence(
        "HTML",
        "Langage de balisage utilisé pour structurer les pages web.",
        R.drawable.html5_logo,
        4.5f
    ),
    Competence(
        "CSS",
        "Langage utilisé pour styliser les pages web et gérer la mise en page.",
        R.drawable.css_logo,
        4.5f
    ),
    Competence(
        "JavaScript",
        "Langage de programmation utilisé pour ajouter de l'interactivité aux pages web.",
        R.drawable.javascript_logo,
        4.5f
    ),
    Competence(
        "PHP",
        "Langage de programmation backend utilisé pour développer des applications web dynamiques.",
        R.drawable.php_logo,
        4.5f
    ),

    // ✅ Compétences supplémentaires (3/5)
    Competence(
        "Angular",
        "Framework JavaScript développé par Google pour créer des applications web dynamiques et modulaires.",
        R.drawable.angular_logo,
        3.0f
    ),
    Competence(
        "C#",
        "Langage de programmation développé par Microsoft, utilisé principalement pour les applications Windows et les jeux vidéo.",
        R.drawable.c_sharp_logo,
        3.0f
    ),
    Competence(
        "Linux",
        "Système d'exploitation open-source couramment utilisé dans les environnements serveurs et de développement.",
        R.drawable.linux_logo,
        3.0f
    ),
    Competence(
        "Arduino",
        "Plateforme open-source pour la création de projets électroniques interactifs.",
        R.drawable.arduino_logo,
        3.0f
    ),
    Competence(
        "Gherkin",
        "Langage utilisé pour écrire des tests fonctionnels lisibles par les humains et exécutables par des outils comme Cucumber.",
        R.drawable.gherkin_logo,
        3.0f
    ),
    Competence(
        "Microsoft Tools",
        "Suite d'outils Microsoft incluant Excel, Word, PowerPoint, SharePoint, Teams et Outlook.",
        R.drawable.microsoft_logo,
        3.0f
    ),
    Competence(
        "Unity",
        "Moteur de jeu utilisé pour créer des jeux vidéo et des expériences interactives.",
        R.drawable.unity_logo,
        3.0f
    ),
    Competence(
        "PrestaShop",
        "Solution e-commerce open-source utilisée pour créer et gérer des boutiques en ligne.",
        R.drawable.prestashop_logo,
        3.0f
    ),
    Competence(
        "Catia V5",
        "Logiciel de conception assistée par ordinateur utilisé dans l'industrie pour la modélisation 3D.",
        R.drawable.catia_logo,
        3.0f
    ),
    Competence(
        "Canva",
        "Outil de conception graphique en ligne permettant de créer des visuels pour le web et l'impression.",
        R.drawable.canva_logo,
        3.0f
    )
)
