package com.example.banco_movil

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthenticationScreen() {
    // Contenido de la pantalla de autenticación
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Usuario y contraseña
            Text(text = "Pantalla de Autenticación", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            // Ejemplo de campo de texto y botón
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Usuario") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Contraseña") })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Manejar el clic del botón */ }) {
                Text("Iniciar sesión")
            }
        }
    }
}
