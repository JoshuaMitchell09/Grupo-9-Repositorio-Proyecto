🃏 The Sandwich Guy — Proyecto Final SC-304 (Estructuras de Datos)
Descripción General

Este proyecto implementa el juego The Sandwich Guy, un juego de cartas para un solo jugador, cuyo objetivo es formar “sándwiches” con combinaciones válidas de tres cartas.
El programa fue desarrollado conforme a todos los requerimientos establecidos en el enunciado oficial del curso SC-304 Estructuras de Datos, incluyendo el uso obligatorio de estructuras como: lista doble, pila, cola, lista circular y árbol binario.

El sistema incorpora:

Interfaz gráfica de escritorio (Java Swing).

Lógica completa del juego.

Evaluación de sándwiches con sus respectivas reglas.

Permutaciones de tripletas utilizando un árbol binario.

Persistencia mediante archivos XML usando el módulo java.xml.

Control total de partidas guardadas y cargadas.

El enfoque del desarrollo fue garantizar claridad estructural, modularidad y consistencia lógica.

Integrantes
Nombre	Carné	GitHub	Correo
Joshua Mitchell Navarro	FH22012006	USUARIO_GITHUB	TU_CORREO
Objetivos del Proyecto

Aplicar estructuras de datos avanzadas a un caso práctico real.

Desarrollar una aplicación gráfica funcional utilizando Java SE 21.

Implementar manejo de archivos para guardar y cargar estados de partida.

Manejar colecciones de datos mediante referencias, evitando duplicación de objetos.

Implementar un sistema de reglas que permita validar combinaciones de cartas.

Desarrollar un software robusto, legible y completamente funcional.

Estructuras de Datos Implementadas y Justificación
1. Carta (Clase Propia)

Representa cada una de las 52 cartas de la baraja inglesa.
Incluye:

Valor (A, 2–10, J, Q, K)

Palo (♥, ♦, ♠, ♣)

Color según el palo

Métodos de comparación y representación textual

2. Caja (Lista doble — Doubly Linked List)

Se utiliza para almacenar las 52 cartas al iniciar una partida.
Permite:

Recorrer hacia adelante y hacia atrás.

Extraer cartas para transferirlas al Mazo.

Visualización ordenada al comenzar.

Justificación: El enunciado exige explícitamente una lista doble para la Caja.

3. Mazo (Pila — Stack)

Estructura tipo LIFO que contiene las cartas barajadas boca abajo.
Operaciones:

push(carta) al barajar

pop() al tomar cartas

Tamaño dinamico

Justificación: Simula perfectamente la acción de tomar cartas de un mazo físico.

4. Mano (Lista circular)

Contiene hasta 8 cartas boca arriba.
Característica principal:

Navegación modular (índice % tamaño)

Permite mantener un orden circular de las cartas

Facilita el manejo de índices sin errores

Justificación: El enunciado exige una lista circular para la Mano.

5. Pozo (Cola — Queue)

Cuando una tripleta se descarta, las cartas se insertan en el Pozo boca abajo, siguiendo el orden FIFO.

Justificación: La cola se ajusta al comportamiento de un pozo de descarte, donde solo interesa el orden de llegada.

6. Árbol Binario para Permutaciones

Cada tripleta seleccionada genera 6 permutaciones, y cada una:

Se inserta en un nodo del árbol.

Almacena la cantidad de cartas permitidas para robar.

Se recorre en orden para presentar los resultados al usuario.

Justificación: El enunciado solicita utilizar una estructura de búsqueda (árbol binario) para manejar las permutaciones.

Reglas del Juego Implementadas
Evaluación de Sándwich

Una tripleta es válida si:

La carta central está entre las otras dos según su valor en un ciclo (K → A).

Las tres cartas tienen el mismo valor.

Cantidad de cartas que se pueden robar del Mazo
Condición	Cantidad
Las tres cartas del mismo palo	4
Las tres cartas del mismo color	3
Las tres cartas de distinto color	2
No válida	0
Estados de Partida

EN_PROGRESO — Mientras existan movimientos válidos.

GANADA — Cuando el mazo queda vacío y no quedan cartas en mano.

PERDIDA — Cuando no existe ninguna combinación válida en la Mano.

Flujo de Juego

Se inicia una partida nueva → Las 52 cartas están en la Caja.

Al presionar Barajar, las cartas pasan al Mazo en orden aleatorio.

Se reparten automáticamente hasta 8 cartas a la Mano.

El usuario selecciona 3 cartas y el sistema muestra las 6 permutaciones:

Con su respectiva cantidad de cartas a robar.

Si decide aplicar la mejor permutación:

Las cartas se envían al Pozo.

Se roban nuevas cartas del Mazo según la regla correspondiente.

Se verifica automáticamente si el juego termina.

El usuario puede Guardar o Cargar en cualquier momento.

Persistencia con XML

El módulo java.xml se usa para almacenar:

Todas las cartas de cada estructura (Caja, Mazo, Mano, Pozo)

El estado de la partida

El orden exacto de las cartas

El archivo XML permite retomar la partida en cualquier momento.

Interfaz Gráfica

La interfaz fue desarrollada con Swing y contiene:

Panel de control con botones:

Nueva Partida

Barajar

Ordenar

Validar

Guardar

Cargar

Ver Mazo

Ver Pozo

Visualización de:

Caja

Mazo (oculto)

Pozo (oculto)

Mano (hasta 8 cartas seleccionables)

Los paneles se actualizan dinámicamente con cada acción.

Estructura del Proyecto
/src
 ├── Main.java
 ├── VentanaPrincipal.java
 ├── Juego.java
 ├── Carta.java
 ├── Valor.java
 ├── Palo.java
 ├── Caja.java
 ├── Mazo.java
 ├── Mano.java
 ├── Pozo.java
 ├── ResultadoPermutacion.java
 ├── ArbolTripletas.java
 ├── NodoTripleta.java
 ├── SandwichEvaluator.java
 ├── PersistenciaXML.java

Instrucciones de Instalación, Compilación y Ejecución
1. Requisitos

JDK 21 instalado.

Variables de entorno configuradas.

2. Ubicación del proyecto

Colocar todos los archivos .java en una sola carpeta.

3. Compilación

En CMD:

cd "C:\Users\joshu\OneDrive\Desktop\PROYECTO PROGRAMACION 2"
del *.class
javac *.java

4. Ejecución
java Main

Pruebas realizadas

Validación de sándwiches en diferentes combinaciones.

Barajado aleatorio consistente.

Carga y guardado de XML verificando integridad.

Ordenamiento de la Mano.

Detección correcta de partida ganada y perdida.

Navegación estable en la interfaz gráfica.

Estado Final del Proyecto

✔ 100% funcional
✔ Cumple todas las especificaciones del enunciado
✔ Estructuras de datos implementadas correctamente
✔ Interfaz gráfica intuitiva
✔ Persistencia XML estable
✔ Código organizado, modular y legible
