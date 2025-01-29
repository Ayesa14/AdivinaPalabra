package com.example.AdivinaPalabra

class Datos private constructor(){
    val palabras = listOf("Hola", "Adios", "Ejemplo", "Perro", "Gato", "Alegre", "Triste", "Casa", "Profesor")
    val intentosMax = 3
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

    // Companion object para manejar la única instancia
    companion object {
        @Volatile
        private var instancia: Datos? = null  // Variable de instancia única

        fun getInstance(): Datos {
            return instancia ?: synchronized(this) { // Doble verificación para hilos
                instancia ?: Datos().also { instancia = it }
            }
        }
    }
}