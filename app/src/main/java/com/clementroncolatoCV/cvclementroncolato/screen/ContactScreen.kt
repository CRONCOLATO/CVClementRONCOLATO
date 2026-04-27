package com.clementroncolatoCV.cvclementroncolato.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun ContactScreen() {
    val context = LocalContext.current
    val email = "clement.roncolato.dev@outlook.com"
    val telephone = "+33 6 95 32 02 49"
    val linkedinUrl = "https://www.linkedin.com/in/cl%C3%A9ment-roncolato-878239232/"
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val isVisible = remember { MutableTransitionState(false).apply { targetState = true } }

        // ✅ Titre animé
        AnimatedVisibility(
            visibleState = isVisible,
            enter = slideInVertically() + fadeIn()
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Mail,
                    contentDescription = "Icône Contact",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Me contacter",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        // ✅ Informations de contact
        ContactInfoItem(label = "Email", value = email) {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            context.startActivity(intent)
        }

        Spacer(modifier = Modifier.height(12.dp))

        ContactInfoItem(label = "Téléphone", value = telephone) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telephone"))
            context.startActivity(intent)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ✅ Section LinkedIn
        Text(
            text = "Mon profil LinkedIn",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Voir mon profil sur LinkedIn",
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary),
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl))
                    try {
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                .padding(4.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // ✅ Bouton d'envoi d'email avec animation
        AnimatedVisibility(
            visibleState = isVisible,
            enter = slideInVertically(initialOffsetY = { 100 }) + fadeIn()
        ) {
            Button(
                onClick = { envoyerEmail(context) },
                modifier = Modifier
                    .fillMaxWidth(0.8f) // ✅ Ajustement pour un rendu plus équilibré
            ) {
                Text("Envoyer un email")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Confidentialité : cette application ne collecte, ne stocke et ne transmet aucune donnée personnelle. Les boutons de contact ouvrent uniquement les applications choisies par l'utilisateur.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Composable
fun ContactInfoItem(label: String, value: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary),
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = Modifier.clickable { onClick() }
        )
    }
}

fun envoyerEmail(context: Context) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "message/rfc822"
        putExtra(Intent.EXTRA_EMAIL, arrayOf("clement.roncolato.dev@outlook.com"))
        putExtra(Intent.EXTRA_SUBJECT, "Demande de contact")
        putExtra(Intent.EXTRA_TEXT, "Bonjour, je souhaite vous contacter pour ...")
    }
    context.startActivity(Intent.createChooser(intent, "Envoyer un email"))
}
