# Conversor de Monedas

## Descripción
Este programa permite al usuario convertir una moneda a otra especificando la cantidad a convertir.  
El programa utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio en tiempo real.

## Funcionalidades
- Conversión entre varias monedas:
  - Dólar (USD) ↔ Peso argentino (ARS)
  - Dólar (USD) ↔ Real brasileño (BRL)
  - Dólar (USD) ↔ Peso colombiano (COP)
- Ingreso de la cantidad a convertir por parte del usuario.
- Muestra el resultado de la conversión en la consola.
- Menú interactivo con opción de salir.

## Tecnologías
- Java
- Gson (para parsear JSON)
- HttpClient (para hacer llamadas HTTP)
- IntelliJ IDEA (IDE)

## Cómo usar
1. Ejecutar el programa en IntelliJ o desde su IDE favorito.
2. Debe descargar y agregar la libreria [GSON](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.13.1) a su IDE para que funcione la aplicación.
3. Elegir la opción de conversión deseada en el menú.
4. Ingresar la cantidad que se desea convertir.
5. Ver el resultado en pantalla.
6. Repetir o salir del programa según se desee.
