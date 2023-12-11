
# Español
# MyRadio App

## Descripción
MyRadio es una aplicación de radio simple para dispositivos Android que permite a los usuarios reproducir una estación de radio en línea de manera fácil y rápida. La aplicación utiliza la clase `MediaPlayer` para la reproducción de audio y proporciona controles básicos, como reproducción, pausa y control de volumen.

## Funcionalidades
- **Reproducción de Audio:** Utiliza la clase `MediaPlayer` para reproducir la estación de radio en línea especificada en el archivo de recursos (`res/values/strings.xml`).

- **Controles de Reproducción:**
  - Botón de "Play": Inicia la reproducción de la estación de radio.
  - Botón de "Pause": Pausa la reproducción de la estación de radio.

- **Control de Volumen:**
  - Barra deslizante (`volumeControl`): Permite al usuario ajustar el volumen de la reproducción de audio.

## Cómo funciona
La aplicación sigue una estructura básica de Android y utiliza el patrón de diseño Modelo-Vista-Controlador (MVC):

- **Inicialización y Configuración:**
  - En el método `onCreate`, se inicializa la interfaz de usuario mediante la vinculación de vistas utilizando `ActivityMainBinding`.
  - Se configura el `AudioManager` para controlar el volumen del dispositivo.
  - Se inicia la configuración del reproductor llamando al método `init()`.

- **Configuración del Reproductor (`init`):**
  - Se inicializa el objeto `MediaPlayer` y se configuran sus atributos de audio mediante `AudioAttributes`.
  - Se establece la fuente de datos del reproductor con la URL de la estación de radio especificada en `res/values/strings.xml`.
  - Se utiliza `prepareAsync()` para preparar el reproductor de manera asíncrona y se inicia la reproducción en el evento de preparación (`setOnPreparedListener`).

- **Controles de Reproducción (`listener`):**
  - Se establecen los listeners para los botones de reproducción y pausa.
  - La barra de desplazamiento `volumeControl` tiene un listener que ajusta el volumen mediante el `AudioManager`.

## Notas
- Asegúrate de proporcionar la URL correcta de la estación de radio en el archivo `res/values/strings.xml`.
- La aplicación está diseñada para funcionar con el flujo de música (`STREAM_MUSIC`) del `AudioManager`.
- Se manejan excepciones como `IllegalArgumentException`, `IllegalStateException`, y `IOException` durante la configuración del reproductor.
- Asegúrece de agregar los permisos necesarios en el archivo `AndroidManifest` de la aplicación.
- Asegúrese de habilitar `View Binding` en el archivo `Graddle`. Véase en enlaces útiles si es necesario.

## Enlaces Útiles
- [Documentación oficial de Android Developer](https://developer.android.com/docs)
- [Documentación de MediaPlayer](https://developer.android.com/reference/android/media/MediaPlayer)
- [Documentación de AudioManager](https://developer.android.com/reference/android/media/AudioManager)
- [Documentación de View Binding](https://developer.android.com/topic/libraries/view-binding?hl=es-419)

# English

# MyRadio App

## Description
MyRadio is a simple radio application for Android devices that allows users to play an online radio station easily and quickly. The application uses the `MediaPlayer` class for audio playback and provides basic controls such as play, pause, and volume control.

## Features
- **Audio Playback:** Uses the `MediaPlayer` class to play the radio station specified in the resource file (`res/values/strings.xml`).

- **Playback Controls:**
  - "Play" Button: Initiates the playback of the radio station.
  - "Pause" Button: Pauses the playback of the radio station.

- **Volume Control:**
  - Slider (`volumeControl`): Allows the user to adjust the volume of the audio playback.

## How It Works
The application follows a basic Android structure and uses the Model-View-Controller (MVC) design pattern:

- **Initialization and Configuration:**
  - In the `onCreate` method, the user interface is initialized by binding views using `ActivityMainBinding`.
  - The `AudioManager` is configured to control the device's volume.
  - The player configuration is initiated by calling the `init()` method.

- **Player Configuration (`init`):**
  - The `MediaPlayer` object is initialized, and its audio attributes are configured using `AudioAttributes`.
  - The player's data source is set with the URL of the radio station specified in `res/values/strings.xml`.
  - `prepareAsync()` is used to asynchronously prepare the player, and playback is initiated in the preparation event (`setOnPreparedListener`).

- **Playback Controls (`listener`):**
  - Listeners are set for the play and pause buttons.
  - The slider `volumeControl` has a listener that adjusts the volume using `AudioManager`.

## Notes
- Ensure to provide the correct URL of the radio station in the `res/values/strings.xml` file.
- The application is designed to work with the music stream (`STREAM_MUSIC`) of `AudioManager`.
- Exceptions such as `IllegalArgumentException`, `IllegalStateException`, and `IOException` are handled during player setup.
- Make sure to add the necessary permissions in the `AndroidManifest` file of the application.
- Ensure to enable `View Binding` in the Gradle file. Refer to the useful links if needed.

## Useful Links
- [Official Android Developer Documentation](https://developer.android.com/docs)
- [MediaPlayer Documentation](https://developer.android.com/reference/android/media/MediaPlayer)
- [AudioManager Documentation](https://developer.android.com/reference/android/media/AudioManager)
- [View Binding Documentation](https://developer.android.com/topic/libraries/view-binding)
