package com.developeravsk.composeclass1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developeravsk.composeclass1.ui.theme.ComposeClass1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeClass1Theme {
                DemoScreen()
            }
        }
    }
}

@Composable
fun DemoSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..38f,
        value = sliderPosition,
        onValueChange = { onPositionChange(it) }
    )
}

@Composable
fun DemoScreen() {
    var sliderPosition by remember {
        mutableStateOf(20f)
    }
    val handlePositions = { position: Float -> sliderPosition = position }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DemoText(message = "Welcome to LearningHub", fontSize = sliderPosition)
        Spacer(modifier = Modifier.height(160.dp))
        DemoSlider(sliderPosition = sliderPosition, onPositionChange = handlePositions)
        Text(text = sliderPosition.toInt().toString()+"sp",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun DemoText(message: String, fontSize: Float) {
    Text(text = message, fontWeight = FontWeight.Bold, fontSize = fontSize.sp)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeClass1Theme {
        DemoScreen()
    }
}