# Capturas reales de ejecución

Fecha local: 11 de noviembre de 2026 (America/Guayaquil, UTC−5). El reloj visible del emulador utiliza UTC.

Emulador: Cupcake_API29, Android 10 / API 29, x86_64, 1080 × 1920. Paquete: com.example.marsphotos, versión 1.0.

Código ejecutado: `bba6238715536fbb91231444003dfccdeca80116`.
Compilación comprobada: `gradlew.bat assembleDebug` con JDK 17; resultado `BUILD SUCCESSFUL`.

Las imágenes son capturas PNG directas obtenidas mediante `android screen capture --device emulator-5554 -o <archivo>`. No son vistas previas de Compose ni imágenes generadas o retocadas.

## Casos ejecutados

1. **screen_success.png:** iniciar la app con conexión. Mensaje: `Success: 838 Mars photos retrieved`.
2. **screen_loading.png:** ralentizar la red con `adb emu network delay 5000` y `adb emu network speed gsm`, reiniciar la app y capturar el indicador durante la petición real.
3. **screen_error.png:** restaurar velocidad y retardo normales, deshabilitar Wi-Fi y datos con `adb shell svc wifi disable` y `adb shell svc data disable`, y reiniciar. Mensaje: `Failed to load`.
4. **Recuperación:** habilitar Wi-Fi y datos, reiniciar y comprobar nuevamente `Success: 838 Mars photos retrieved`. Se dejó la conectividad restaurada.

La estructura de la interfaz se inspeccionó con `android layout`. El contenido de las tres capturas se revisó visualmente. El indicador de carga es el recurso gráfico `loading_img`; una captura no demuestra una animación.

## Huellas SHA256

- `screen_error.png`: `dce5495085f419c8c2f9e6387840f359392e99b0232a574521073793755f9d5a`
- `screen_loading.png`: `e505ab1824dddf80dec139b6bdcb27937802728cafe1d36fc0bede5f54c20d7a`
- `screen_success.png`: `36ce0d77b29df4db0d3cdba3ff101015c1a653ad2d13aaee03163b8ff574aed3`

[Informe editable de ejecución](../docs/Evidencias_Mars_Photos.docx)
