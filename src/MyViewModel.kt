package com.example.adivinapalabra

import androidx.lifecycle.ViewModel
import com.example.adivinapalabras.Datos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

// Enum para los estados del juego
enum class EstadoJuego {
    JUGANDO, GANADO, PERDIDO
}

// ViewModel para manejar la lógica del juego
class MyViewModel : ViewModel() {

    // Estado del juego usando StateFlow (para patrón Observer)
    private val _estadoJuego = MutableStateFlow(EstadoJuego.JUGANDO)
    val estadoJuego: StateFlow<EstadoJuego> get() = _estadoJuego

    // Variables de estado del juego
    private val _palabra = MutableStateFlow("")
    val palabra: StateFlow<String> get() = _palabra

    private val _palabraJugador = MutableStateFlow("")
    val palabraJugador: StateFlow<String> get() = _palabraJugador

    private val _pistaActual = MutableStateFlow("")
    val pistaActual: StateFlow<String> get() = _pistaActual

    private val _intento = MutableStateFlow(0)
    val intento: StateFlow<Int> get() = _intento

    private val _ronda = MutableStateFlow(0)
    val ronda: StateFlow<Int> get() = _ronda

    private val _textoResultado = MutableStateFlow("")
    val textoResultado: StateFlow<String> get() = _textoResultado

    private var pistasDisponibles = listOf<String>()

    /**
     * Inicializa una nueva palabra para adivinar.
     * Si el juego ya terminó, no hace nada.
     * Si el juego está en curso, elige una nueva palabra aleatoria y muestra la primera pista.
     * Si el juego está en curso, pero no hay más pistas disponibles, muestra "Sin pistas"
     */
    fun nuevaPalabra() {
        if (_estadoJuego.value != EstadoJuego.JUGANDO) return  // Si el juego ya terminó, no hacer nada

        _palabra.value = Datos.obtenerPalabraAleatoria()
        pistasDisponibles = Datos.obtenerPistas(_palabra.value).toMutableList()
        _pistaActual.value = pistasDisponibles.firstOrNull() ?: "Sin pistas"
        _palabraJugador.value = ""
        _intento.value = 0
        _estadoJuego.value = EstadoJuego.JUGANDO
    }

    /**
     * Actualiza la palabra ingresada por el jugador.
     * @param palabra Palabra ingresada por el jugador.
     */
    fun actualizarPalabraJugador(palabra: String) {
        _palabraJugador.value = palabra
    }

    /**
     * Comprueba si la palabra ingresada por el jugador es correcta.
     * Si la palabra es correcta, muestra un mensaje de felicitación y termina el juego.
     * Si la palabra es incorrecta, incrementa el número de intentos y muestra la siguiente pista.
     * Si el número de intentos supera el máximo permitido, muestra un mensaje de derrota y termina el juego.
     * @return true si la palabra es correcta, false si no lo es.
     */
    fun comprobarPalabra(): Boolean {
        if (_estadoJuego.value != EstadoJuego.JUGANDO) return false

        val acierto = _palabra.value.equals(_palabraJugador.value, ignoreCase = true)
        if (acierto) {
            _estadoJuego.value = EstadoJuego.GANADO
            _textoResultado.value = "¡Felicidades! Has adivinado la palabra."
            return true
        } else {
            _intento.value += 1
            if (_intento.value >= Datos.INTENTOS_MAX) {
                _estadoJuego.value = EstadoJuego.PERDIDO
                _textoResultado.value = "¡Perdiste! La palabra era '${_palabra.value}'."
            } else {
                mostrarSiguientePista()
            }
        }
        return false
    }

    /**
     * Muestra la siguiente pista disponible.
     * Si no hay más pistas disponibles, muestra "No hay más pistas".
     */
    private fun mostrarSiguientePista() {
        if (pistasDisponibles.isNotEmpty()) {
            pistasDisponibles = pistasDisponibles.drop(1)
            _pistaActual.value = pistasDisponibles.firstOrNull() ?: "No hay más pistas"
        }
    }

    /**
     * Reinicia el juego, mostrando una nueva palabra para adivinar.
     * Si el juego ya terminó, no hace nada.
     * Si el juego está en curso, reinicia el juego con una nueva palabra.
     */
    fun reiniciarJuego() {
        _estadoJuego.value = EstadoJuego.JUGANDO
        nuevaPalabra()
    }
}

