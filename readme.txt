¡Buenas!

Este proyecto entrega números de la secuencia Fibonacci como fue pedido, ademas contiene un endpoint
para poder ver cuales fueron los más solicitados y la cantidad de veces que lo fueron.

Para almacenar el valor de los valores de Fibonacci se utilizo el tipo String, ya que los
números aumentan exponencialmente a medida que se avanza en la secuencia, esto haciendo que al guardarlos
lo mejor sea utilizar un String para poder luego convertirlos, ya que incluso utilizando BigInteger el valor
era demaciado grande para los números mas altos de la secuencia, esto ademas se hizo para que la API no tuviera
un limite logico a partir del cual no respondiera.

Los endpoints a utilizar son:

/fibonacci/top-consulted/{n}
Metodo GET
Parametros:
n: Este es el limite de números mas consultados a mostrar,si queremos ver el más consultado pondremos 1, si
queremos ver los 10 más consultados pondremos 10 y así sucesivamente.

/fibonacci/{n}
Metodo GET
Parametros:
n: Esta sería la posición dentro de la secuencia de la cual queremos saber el valor, siendo el inicio de la
secuencia 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89... . Ejemplo n:6 nos entregaría el valor 6

El proyecto contiene un TEST el cual verifica en su totalidad cada parte usada en la API, este se ejecuta
corriendo el archivo FibonacciServiceTest.java dentro de la carpeta src/main/java/com.example.demo/logica/test.

La API esta subida a Railway , la dirección de la misma es http://fibonacci-production-d155.up.railway.app
La Base de datos esta almacenada en Aiven usando MySQL.

Los datos de la base de datos fueron dejados en el properties en caso de que deseen ver como es la misma (no estan
protegidos ya que considerando que es un proyecto demostrativo no lo vi necesario,ademas permite que interactuen con
la base si lo desean)

Dejo aquí los CURLs de la aplicación en el entorno subido a Railway