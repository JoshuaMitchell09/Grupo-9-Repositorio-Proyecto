🃏 Proyecto de Juego de Cartas – Avance II
👥 Integrantes

Joshua Mitchell – Carné: FH22012006

Alexis José Sandí – Carné: (pendiente si deseas agregarlo)

📚 Curso

Programación I

💻 Editores / IDEs Utilizados

Visual Studio Code

IntelliJ IDEA Community Edition

Notepad++ (uso secundario para revisión rápida de archivos)

📌 Descripción General del Proyecto

Este proyecto implementa un juego de cartas por consola desarrollado en Java, con una arquitectura modular que separa claramente:

Mazo (baraja)

Pozo (cartas descartadas)

Mano del jugador

Entidades Carta

Motor del juego (JuegoEngine) encargado de analizar combinaciones

Interfaz por consola (MainCLI)

El objetivo del programa es permitir al usuario interactuar con un sistema de cartas donde puede:

✔ Robar cartas
✔ Ver su mano
✔ Evaluar si tiene un sándwich
✔ Descartar cartas al pozo
✔ Ejecutar acciones de manera secuencial por menú
✔ Procesar combinaciones de forma automática

🥪 ¿Qué es un Sándwich en el Juego?

Un sándwich es una combinación válida de tres cartas, bajo cualquiera de estas reglas:

1️⃣ Tres valores consecutivos

Ejemplo:

4, 5, 6

9, 10, 11

2️⃣ Tres cartas del mismo valor

Ejemplo:

7, 7, 7

3, 3, 3

El motor del juego (JuegoEngine) se encarga de verificar estas reglas.

📂 Estructura del Proyecto
/src
 ├── Carta.java
 ├── Mazo.java
 ├── Mano.java
 ├── Pozo.java
 ├── JuegoEngine.java
 ├── JuegoEngineImpl.java
 ├── MainCLI.java


Cada archivo cumple un rol específico dentro de la lógica del juego.

⚙️ Descripción Técnica Completa
1. Carta.java

Representa una carta con:

valor (int)

palo (String)
Incluye métodos:

getters

toString()

2. Mazo.java

Gestiona la baraja de cartas:

Crea el mazo completo

Permite mezclar las cartas

Permite robar una carta (sacar())

3. Mano.java

Representa la mano del jugador:

Usa una lista de cartas

Puede ordenar las cartas

Puede agregar o eliminar cartas

Permite retornar las cartas actuales

4. Pozo.java

Estructura que almacena las cartas descartadas:

Método agregar(carta)

Se comporta como acumulador

5. JuegoEngine.java / JuegoEngineImpl.java

Motor del juego:

Verifica si la mano tiene un sándwich

Evalúa permutaciones posibles

Revisa combinaciones válidas

Devuelve índices para jugadas correctas

6. MainCLI.java

Interfaz por consola que permite al usuario:

Robar cartas

Ver la mano

Ver si tiene un sándwich

Simular jugadas automáticas

Descartar al pozo

Salir del sistema

Ejemplo menú:

1. Robar carta
2. Ver mano
3. Evaluar sándwich
4. Salir

📥 Instructivo Completo
🔧 1. Instalación

Instala Java JDK 17 o superior
Descargar desde: https://www.oracle.com/java/technologies/javase-downloads.html

Asegúrate de que el comando java y javac funcionan en tu terminal:

java -version
javac -version


Descarga o copia los archivos .java en una misma carpeta, por ejemplo:

C:\Users\joshu\OneDrive\Desktop\Proyecto programacion

🛠 2. Compilación

Abre la terminal dentro del folder donde están los .java:

cd C:\Users\joshu\OneDrive\Desktop\Proyecto programacion


Compila todo:

javac *.java


Si todo está correcto, no aparecerán errores.

▶️ 3. Ejecución del Juego

Una vez compilado, ejecuta:

java MainCLI


Aparecerá el menú principal del juego.

🧪 Ejemplo de Funcionamiento
1. Robar carta
2. Ver mano
3. Evaluar sándwich
4. Salir
Seleccione una opción: 1

Robaste: 5 CORAZONES

🌐 Bibliografía / Recursos Utilizados

Documentación oficial de Java
https://docs.oracle.com/javase/

GeeksForGeeks – Estructuras de datos
https://geeksforgeeks.org

StackOverflow
Consultado para problemas de bucles, sort y sintaxis

Prompts y respuestas generadas por ChatGPT durante el desarrollo

✔️ Notas Finales

Este proyecto fue diseñado para cumplir los requerimientos del curso, mostrando:

Lógica clara

Modularidad

Buenas prácticas básicas

Ejecución 100% en consola

Código organizado y fácil de leer

Puede expandirse en el futuro con:

GUI en Swing

Persistencia en archivos

Múltiples jugadores

Animaciones o sonidos en la interfaz
