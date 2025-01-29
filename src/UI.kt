package com.example.adivinapalabra

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adivinapalabra.MyViewModel

@Composable
        /**
         * Interfaz de usuario para el juego de adivinar la palabra.
         * @param viewModel ViewModel que maneja la lógica del juego.
         * @param palabra Palabra que el jugador debe adivinar.
         * @param palabraJugador Palabra ingresada por el jugador.
         * @param pista Pista actual para la palabra.
         * @param intento Número de intentos realizados por el jugador.
         * @param estadoJuego Estado actual del juego.
         * @param textoResultado Texto con el resultado del juego.
         */
fun UI(viewModel: MyViewModel = viewModel()) {
    val palabra by viewModel.palabra.collectAsState()
    val palabraJugador by viewModel.palabraJugador.collectAsState()
    val pista by viewModel.pistaActual.collectAsState()
    val intento by viewModel.intento.collectAsState()
    val estadoJuego by viewModel.estadoJuego.collectAsState()
    val textoResultado by viewModel.textoResultado.collectAsState()

    // Layout principal para la UI del juego
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Adivina la palabra", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Intento: $intento de ${Datos.INTENTOS_MAX}", fontSize = 20.sp)
        Text("Pista: $pista", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para que el jugador introduzca la palabra
        TextField(
            value = palabraJugador,
            onValueChange = { viewModel.actualizarPalabraJugador(it) },
            label = { Text("Introduce la palabra") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botones para comprobar la palabra y obtener una nueva palabra
        Button(onClick = { viewModel.comprobarPalabra() }) {
            Text("Comprobar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.nuevaPalabra() }) {
            Text("Nueva palabra")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (estadoJuego != EstadoJuego.JUGANDO) {
            Text(textoResultado, fontSize = 22.sp)
            Button(onClick = { viewModel.reiniciarJuego() }) {
                Text("Reiniciar juego")
            }
        }
    }
}
