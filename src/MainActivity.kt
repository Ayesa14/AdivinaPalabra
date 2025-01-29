package com.example.adivinapalabra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.AdivinaPalabra.ui.theme.AdivinaPalabraTheme
import com.example.adivinapalabra.MyViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MyViewModel = MyViewModel()

        //enableEdgeToEdge()
        setContent {
            AdivinaPalabraTheme {
                // A surface container using the 'background' color from the theme
                UI(model = viewModel)
            }
        }
    }
}