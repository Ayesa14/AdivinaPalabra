package com.example.AdivinaPalabra

object Datos{
    val palabras = listOf("Hola", "Adios", "Ejemplo", "Perro", "Gato", "Alegre", "Triste", "Casa", "Profesor")
    var ronda = 0
    var intento = 0
    val intentosMax = 3
    var pista = ""
    val toastText = listOf("Has fallado", "Has acertado", "Has usado todas las pistas", "Has usado todos los intentos")
    val pistas = mapOf(
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
}