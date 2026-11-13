# Evidencias reales de las continuaciones

Fecha de ejecución: 13 de noviembre de 2026 (Ecuador UTC−5). El reloj del emulador utiliza UTC.

Emulador Cupcake_API29, Android 10 / API 29, x86_64, pantalla 1080 × 1920. Densidad 256 dpi para la primera continuación y 420 dpi para la galería. Se restauró la densidad original de 256 dpi al terminar.

Capturas directas sin editar. Se usaron `android screen capture` y `adb shell screencap -p`, seguido de `adb pull`. Las fotografías se descargaron mediante la app; no son datos simulados ni vistas previas de Compose.

Código de la primera continuación: [4eb7a1e](https://github.com/Erickelrojo-22/Mars-Photos-App/tree/4eb7a1ea4c1574aae999ed4f79fffa803033f912). Código de la galería: [ce100ef](https://github.com/Erickelrojo-22/Mars-Photos-App/tree/ce100ef1b7035ad11e10ee2bebe80010069f2253).

- [01_repositorio_di.png](01_repositorio_di.png): Primera continuación en ejecución con el mensaje Success: 838 Mars photos retrieved.
- [02_galeria.png](02_galeria.png): Fotografías reales de Marte en una cuadrícula de dos columnas.
- [03_desplazamiento.png](03_desplazamiento.png): Cuadrícula mostrando otras fotografías después de desplazarse.
- [04_carga.png](04_carga.png): Indicador visible mientras se obtiene la lista de fotos.
- [05_error_retry.png](05_error_retry.png): Error Failed to load y botón Retry al iniciar sin red.
- [06_recuperacion_retry.png](06_recuperacion_retry.png): Galería recuperada al restablecer la conexión y pulsar Retry.
- [07_imagenes_sin_red.png](07_imagenes_sin_red.png): Iconos de imagen rota al desplazarse sin conexión a imágenes aún no descargadas.

## Procedimiento

1. Compilar e instalar la versión con repositorio e inyección. Comprobar 838 registros y capturar.
2. Compilar e instalar la versión con Coil. Comprobar carga, galería y desplazamiento.
3. Deshabilitar Wi-Fi y datos con `adb shell svc wifi disable` y `adb shell svc data disable`. Desplazarse a imágenes aún no cargadas y capturar los iconos de error.
4. Reiniciar sin red, esperar `Failed to load` y capturar el botón Retry.
5. Habilitar Wi-Fi y datos. Pulsar Retry, sin reiniciar la app, y comprobar la recuperación de la galería.
6. Restaurar la conectividad y la densidad original.

## Huellas SHA256

- `01_repositorio_di.png`: `259c053b62dc5a33114913c83f9baf272193bd99b74ce9b7ee498b8aed78de09`
- `02_galeria.png`: `8a6b80aaaf858999dd2af0343a8a5e56f6deb4960cbdf812d9654db4a30de300`
- `03_desplazamiento.png`: `68d69de9481f9bc1c0397f868077b1ae06c8906876e794f8798bb9b8465b2007`
- `04_carga.png`: `7db1ed22643dcdc010ec92b91b0295a896d4e1c8aea23ebb428b6aebb1970cbf`
- `05_error_retry.png`: `c3be21b025f9987ad73ded2e2182c272b71955fbbda8201c4c8111b9a4dc159d`
- `06_recuperacion_retry.png`: `51c960c82e9707d088f01a0b7b1f34fadcb50bd192f70f96e495bb0e4912643d`
- `07_imagenes_sin_red.png`: `1b24089dc425ef3adda235922f0cd1ea54d8ea28d71940452889db18b76d22d6`

[Informe editable](../../docs/Evidencias_Mars_Photos_Continuacion.docx)
