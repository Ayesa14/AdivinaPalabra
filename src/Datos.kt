package com.example.adivinapalabras

import kotlin.random.Random

// Singleton que maneja el diccionario de palabras y pistas
object Datos {

    private val palabrasConPistas = mapOf(
        "Hola" to listOf("Saludo", "Hi", "Saludar"),
        "Adios" to listOf("Despedida", "Bye", "Chao"),
        "Ejemplo" to listOf("Muestra", "Demostración", "Modelo"),
        "Perro" to listOf("Can", "Mascota", "Animal"),
        "Gato" to listOf("Felino", "Mascota", "Animal"),
        "Alegre" to listOf("Contento", "Eufórico", "Feliz"),
        "Triste" to listOf("Deprimido", "Acongojado", "Decaído"),
        "Casa" to listOf("Vivienda", "Hogar", "Residencia"),
        "Profesor" to listOf("Maestro", "Docente", "Educador")
    )

    const val INTENTOS_MAX = 3  // Máximo de intentos permitidos

    /**
     * Obtiene una palabra aleatoria del diccionario.
     * Si el diccionario está vacío, devuelve una cadena vacía.
     * Si el diccionario no está vacío, devuelve una palabra aleatoria.
     * @return Palabra aleatoria del diccionario.
     */
    fun obtenerPalabraAleatoria(): String {
        return palabrasConPistas.keys.random()
    }

    /**
     * Obtiene la lista de pistas asociadas a una palabra dada.
     * Si la palabra no existe en el diccionario, devuelve una lista vacía.
     * Si la palabra existe en el diccionario, devuelve la lista de pistas asociadas.
     * @param palabra Palabra de la que se desean obtener las pistas.
     * @return Lista de pistas asociadas a la palabra dada.
     */
    fun obtenerPistas(palabra: String): List<String> {
        return palabrasConPistas[palabra] ?: emptyList()
    }
}
