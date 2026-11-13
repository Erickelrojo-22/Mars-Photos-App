# Validación de las continuaciones de Mars Photos

Fecha: 13 de noviembre de 2026.

- Repositorio e inyección manual: `4eb7a1ea4c1574aae999ed4f79fffa803033f912`.
- Galería con Coil y Retry: `ce100ef1b7035ad11e10ee2bebe80010069f2253`.
- JDK 17; Gradle 8.12; Android Gradle Plugin 8.8.0.

## Verificación automatizada

`gradlew.bat testDebugUnitTest assembleDebug lintDebug`

Resultado observado: `BUILD SUCCESSFUL`. 7 pruebas, 0 fallos y 0 errores.

Android Lint: 0 errores; 11 advertencias (versiones de dependencias y elementos de la plantilla).

| Componente | Comportamiento | Resultado |
| --- | --- | --- |
| Repositorio | Devuelve la lista proporcionada por el servicio falso. | Correcto |
| Repositorio | Propaga IOException al fallar la red. | Correcto |
| ViewModel | Obtiene el estado Success desde el repositorio inyectado. | Correcto |
| ViewModel | Permanece en Loading mientras la respuesta está pendiente. | Correcto |
| ViewModel | Muestra Error al recibir IOException. | Correcto |
| ViewModel | Muestra Error al recibir un error HTTP 503. | Correcto |
| ViewModel | Recupera Success al volver a consultar después de un fallo. | Correcto |

Las pruebas usan FakeDataSource, FakeMarsApiService, FakeNetworkMarsPhotosRepository y TestDispatcherRule. Se comprobó primero que las pruebas requerían las interfaces y la inyección nuevas. Al avanzar a imágenes se actualizó la prueba de Success para exigir la lista y se observó el fallo por el tipo String anterior antes de adaptar el código.

## Ejecución real

Contador de 838 registros después de introducir repositorio e inyección; galería descargada con Coil; desplazamiento; estado de carga; errores en imágenes no almacenadas en caché; fallo de petición sin red; recuperación al pulsar Retry con conexión restaurada.

APK de la primera continuación: SHA256 `a3858f1fe98a35d0d37dde16aa684ef621a3916448fccd3382e04139550934fa`.

APK de la galería: SHA256 `c6e3e24562343f3a6f46acb8847c406618a10832af0a59120ffe72d7919d43ef`.

[Capturas y procedimiento](../screenshots/continuacion/README.md) · [Informe Word](Evidencias_Mars_Photos_Continuacion.docx)
