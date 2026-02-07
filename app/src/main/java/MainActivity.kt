package com.vectorvision.svgv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun Bundle? onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VectorVisionTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF0A0A0C)) {
                    Dashboard()
                }
            }
        }
    }
}

@Composable
fun Dashboard() {
    var isFidelityLocked by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("VECTORVISION", style = MaterialTheme.typography.headlineLarge, color = Color(0xFF00FFCC), fontWeight = FontWeight.Bold)
        Text("SVGV v1.0 | Prototype Mode", color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))

        // Simulated Vector Preview Window
        Box(modifier = Modifier.fillMaxWidth().height(250.dp).background(Color(0xFF16161A))) {
            Text("LIVE VECTOR STREAM", modifier = Modifier.align(Alignment.Center), color = Color(0xFF7000FF))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Anti-Trash Toggle
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Anti-Trash Fidelity Lock", color = Color.White, fontWeight = FontWeight.Medium)
                Text("Coordinate-based noise reduction", color = Color.Gray, style = MaterialTheme.typography.bodySmall)
            }
            Switch(checked = isFidelityLocked, onCheckedChange = { isFidelityLocked = it })
        }

        Spacer(modifier = Modifier.height(40.dp))
        
        Button(
            onClick = { /* TODO: Start Engine */ },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7000FF))
        ) {
            Text("INITIALIZE C++/NDK ENGINE")
        }
    }
}
