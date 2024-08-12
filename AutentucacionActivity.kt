package com.example.banco_movil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.banco_movil.ui.theme.Banco_movilTheme

class AutenticacionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Banco_movilTheme {
                AuthenticationScreen()
            }
        }
    }
}
