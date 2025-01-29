# Adivina la Palabra - Android App

## Descripción

**Adivina la Palabra** es un juego interactivo para Android en el que el jugador debe adivinar una palabra a partir de una serie de pistas. Cada intento realizado cuenta, y el jugador tiene un número limitado de intentos para adivinar correctamente la palabra. El juego ofrece un conjunto de pistas y muestra el progreso a medida que el jugador intenta adivinar.

La aplicación está construida utilizando **Jetpack Compose** para la UI y **StateFlow** para gestionar el estado reactivo del juego, lo que permite una experiencia de usuario fluida y eficiente.


## Estructura del Proyecto

El proyecto está estructurado en las siguientes clases principales:

1. **MainActivity**: La actividad principal que inicializa el juego y establece el contenido de la interfaz de usuario.
2. **MyViewModel**: El **ViewModel** que gestiona la lógica del juego. Aquí se manejan los estados del juego, como la palabra actual, las pistas, los intentos, y los resultados (ganado, perdido).
3. **Datos**: Un singleton que contiene un conjunto de palabras con sus pistas asociadas. Se selecciona una palabra aleatoria para el juego, y el jugador puede utilizar las pistas disponibles para adivinar la palabra.
4. **JuegoUI**: La interfaz de usuario del juego, construida con **Jetpack Compose**, donde el jugador puede introducir palabras, recibir pistas y ver los resultados.

## Cómo Funciona

1. **Inicio del Juego**: El juego comienza con una palabra aleatoria seleccionada de un conjunto predefinido.
2. **Interfaz**: La UI muestra la pista inicial y permite al jugador ingresar su palabra de adivinanza.
3. **Intentos**: El jugador tiene un número limitado de intentos (3 intentos en este caso). Después de cada intento incorrecto, el juego muestra una nueva pista.
4. **Finalización del Juego**: Si el jugador adivina la palabra correctamente, gana. Si se agotan los intentos sin adivinar correctamente, el juego muestra la palabra correcta y el jugador pierde.
5. **Reinicio**: El jugador puede reiniciar el juego para jugar una nueva ronda con una palabra diferente.

## Gestión del Estado

El estado del juego se gestiona mediante **StateFlow** para asegurar que la UI se actualice de manera eficiente cuando cambian los datos importantes (como la palabra, los intentos, o el estado del juego).

- **Estado del Juego**: El juego puede estar en uno de tres estados: **JUGANDO**, **GANADO** o **PERDIDO**.
- **Palabra y Pistas**: El `ViewModel` selecciona aleatoriamente una palabra y sus pistas asociadas.
- **Intentos**: El jugador tiene un número limitado de intentos (3), que se incrementan después de cada intento fallido.

## Características y Funcionalidad

### Funciones Implementadas

- **Selección aleatoria de palabra**: El juego selecciona una palabra aleatoria de un conjunto predefinido.
- **Pistas**: Se proporciona un conjunto de pistas que ayudan al jugador a adivinar la palabra.
- **Control de intentos**: El jugador tiene un número limitado de intentos antes de perder.
- **Gestión del estado del juego**: Los estados del juego se gestionan de forma reactiva con **StateFlow**, lo que permite que la UI se actualice automáticamente según los cambios en el estado del juego.
- **Reinicio del juego**: El jugador puede reiniciar el juego después de ganar o perder.

### Arquitectura

- **Jetpack Compose**: Utilizado para construir la interfaz de usuario moderna y declarativa.
- **MVVM** (Modelo-Vista-ViewModel): Separación de la lógica de negocio (en el **ViewModel**) de la interfaz de usuario (en la **UI**).
- **StateFlow**: Maneja el estado reactivo del juego y permite que la interfaz se actualice automáticamente cuando cambian los valores del estado.

## Ajuste a los Requisitos

### 1. **Uso de Singleton y Enum**
- **Singleton**: Se ha utilizado el patrón **Singleton** en la clase `Datos`, que maneja el diccionario de palabras y pistas, asegurando que solo exista una instancia de este objeto.
- **Enum**: Se ha usado el **enum** `EstadoJuego` para definir los posibles estados del juego: **JUGANDO**, **GANADO**, y **PERDIDO**.

### 2. **Uso de Estados**
- El estado del juego se gestiona mediante **StateFlow** y el **enum** `EstadoJuego`. Esto permite que el estado del juego se actualice de manera reactiva en la UI a medida que cambian las condiciones del juego (por ejemplo, si el jugador adivina correctamente, o si pierde el juego).

### 3. **Uso del Patrón Observer**
- Se implementa el **patrón Observer** utilizando **StateFlow**. El `ViewModel` observa y actualiza los valores de las variables de estado del juego (como los intentos, la palabra, y la pista actual), y estos cambios se reflejan automáticamente en la interfaz de usuario.

### 4. **Esquema MVVM**
- El proyecto sigue el patrón de **arquitectura MVVM** (Modelo-Vista-ViewModel). El **ViewModel** maneja la lógica de negocio, el **Modelo** contiene los datos (palabra y pistas), y la **Vista** (UI) se encarga de la interfaz de usuario.

### 5. **Uso de Métodos con Parámetros y Retorno de Valores**
- Se utilizan métodos con parámetros y valores de retorno en el `ViewModel`, como el método `comprobarPalabra()`, que verifica si la palabra ingresada por el jugador es correcta y devuelve un valor booleano que indica si el jugador ganó.

### 6. **Funcionamiento de la Aplicación**
- La aplicación funciona correctamente, permitiendo a los jugadores adivinar palabras con pistas y un número limitado de intentos.

### 7. **Explicación de la Implementación**
- Este archivo `README.md` proporciona una explicación detallada de la implementación del juego, cómo funciona, y cómo el proyecto se ajusta a los requisitos especificados.

## Sugerencias de Funcionalidades para el Futuro

Aquí algunas ideas de funcionalidades adicionales que podrías agregar en el futuro:

### 1. **Nivel de dificultad**:
- Añadir diferentes niveles de dificultad (fácil, intermedio, difícil), con más pistas en niveles fáciles y menos pistas en niveles difíciles.

### 2. **Temática de palabras**:
- Permitir que el jugador elija un tema para las palabras (por ejemplo, animales, tecnología, deportes) para hacer el juego más variado y desafiante.


### 3. **Puntuación**:
- Implementar un sistema de puntuación donde el jugador obtenga puntos por adivinar correctamente y pierda puntos por intentos incorrectos o por no adivinar a tiempo.

### 4. **Animaciones y efectos visuales**:
- Mejorar la experiencia de usuario añadiendo animaciones y efectos visuales cuando el jugador gana o pierde, o cuando se cambia de pista.

### 5. **Base de datos de palabras y pistas**:
- Usar una base de datos (por ejemplo, Firebase) para almacenar más palabras y pistas, lo que permitirá que el juego tenga una base de datos más amplia y diversa.

