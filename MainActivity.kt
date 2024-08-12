package com.example.banco_movil

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banco_movil.ui.theme.Banco_movilTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Iniciar la pantalla de inicio
        setContent {
            Banco_movilTheme {
                SplashScreen()
            }
        }

        // Redirigir a la pantalla de autenticación
        GlobalScope.launch {
            delay(2000)
            startActivity(Intent(this@MainActivity, AutenticacionActivity::class.java))
            finish()
        }
    }
}

@Composable
fun SplashScreen() {
    val transitionDuration = 2000
    var startAnimation by remember { mutableStateOf(false) }

    // Iniciar animación
    LaunchedEffect(Unit) {
        delay(500)
        startAnimation = true
    }

    val yOffset by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 200.dp,
        animationSpec = tween(durationMillis = transitionDuration)
    )

    // Fondo degradado
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFFFFFFF), Color(0xFFCCCCCC))
    )

    // Diseño de la pantalla de inicio
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(yOffset)) // Esto mueve el logo de abajo hacia arriba


            // Logo del banco
            Image(
                painter = painterResource(id = R.drawable.android_robot),
                contentDescription = "Logo del banco",
                modifier = Modifier.size(128.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Nombre del proyecto
            Text(
                text = "banco_movil",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Banco_movilTheme {
        SplashScreen()
    }
}
