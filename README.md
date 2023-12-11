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
- Asegúrese de habilitar `View Binding` en el archivo `Graddle`. Vease en enlaces útiles si es necesario.

## Enlaces Útiles
- [Documentación oficial de Android Developer](https://developer.android.com/docs)
- [Documentación de MediaPlayer](https://developer.android.com/reference/android/media/MediaPlayer)
- [Documentación de AudioManager](https://developer.android.com/reference/android/media/AudioManager)
- [Documentación de View Binding](https://developer.android.com/topic/libraries/view-binding?hl=es-419)
