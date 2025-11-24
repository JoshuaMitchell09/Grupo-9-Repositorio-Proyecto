📘 README – Juego de Cartas (Versión Consola)
👤 Autor

Joshua Mitchell
Curso: Programación
IDE recomendado: VS Code o IntelliJ IDEA

📌 Descripción General del Proyecto

Este proyecto implementa un juego de cartas por consola, donde el jugador interactúa con:

Mazo (baraja de cartas)

Pozo (cartas descartadas o acumuladas)

Mano del jugador

Motor del juego (JuegoEngine) para evaluar sándwiches

Cartas con valor y palo

El juego permite:

✔ Robar cartas
✔ Evaluar si existe un “sándwich” válido en la mano
✔ Mostrar cartas por consola
✔ Ejecutarse 100% desde terminal
✔ Lógica modular y separada

🃏 ¿Qué es un “Sándwich”?

Un sándwich es una combinación válida de 3 cartas, según estas reglas:

Tres valores consecutivos
Ejemplo: 4, 5, 6

Tres cartas del mismo valor
Ejemplo: 8, 8, 8

📂 Estructura del Proyecto
/src
 ├── Carta.java
 ├── Mazo.java
 ├── Mano.java
 ├── Pozo.java
 ├── JuegoEngine.java
 ├── JuegoEngineImpl.java
 ├── MainCLI.java

▶️ Cómo Ejecutarlo

Ubícate en la carpeta donde tengas los .java:

cd C:\Users\joshu\OneDrive\Desktop\Proyecto programacion


Compila todos los archivos:

javac *.java


Ejecuta el juego:

java MainCLI

⚙️ Lógica del Juego (resumen técnico pero entendible)
1. Carta.java

Define una carta con:

valor (int)

palo (String)

Incluye getters y toString().

2. Mazo.java

Crea la baraja completa

Permite mezclar

Permite sacar cartas (sacar())

3. Mano.java

Contiene las cartas del jugador

Ordena cartas para mostrarlas

Permite agregar o eliminar cartas

4. Pozo.java

Recibe cartas descartadas

Funciona como acumulador

5. JuegoEngineImpl.java

Define toda la lógica:

Determinar si existe un sándwich

Evaluar combinaciones y devolver índices

Reglas completas del juego

6. MainCLI.java

Interfaz por consola donde el usuario puede:

Robar cartas

Ver su mano

Ver si tiene sándwich

Simular jugadas

Salir del juego

🧪 Ejemplo de Uso
1. Robar carta
2. Ver mano
3. Evaluar sándwich
4. Salir
Seleccione una opción: 1
Robaste: 5 CORAZONES

🌐 Bibliografía / Recursos Utilizados

Estos recursos fueron consultados durante el desarrollo:

Documentación oficial de Java: https://docs.oracle.com/javase/

GeeksForGeeks — Estructuras de Datos: https://geeksforgeeks.org

StackOverflow — dudas puntuales de sintaxis Java

Preguntas y respuestas generadas en ChatGPT (incluidas durante el desarrollo)

✔️ Notas Finales

Este proyecto está diseñado para ser simple, entendible y funcional en consola.

Puedes extenderlo agregando turnos, jugadores múltiples o reglas adicionales.
